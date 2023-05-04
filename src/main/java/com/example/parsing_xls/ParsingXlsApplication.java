package com.example.parsing_xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.nio.file.Path;

import static java.lang.System.exit;

public class ParsingXlsApplication {

    public static void main(String[] args) throws IOException, SQLException {
        List<inputCell> input = List.of(
                new inputCell("D:\\Test\\Test2.xls",1, "E14", cellFinder.Type.TOWNNAME),
                new inputCell("D:\\Test\\Test2.xls",2, "C28", cellFinder.Type.NUMOFPROPERTY),
                new inputCell("D:\\Test\\Test2.xls",2, "C36", cellFinder.Type.NUMOFTAXES),
                new inputCell("D:\\Test\\Test2.xls",3,"C29", cellFinder.Type.NUMOFPROPERTY),
                new inputCell("D:\\Test\\Test2.xls",3,"C37", cellFinder.Type.NUMOFTAXES),
                new inputCell("D:\\Test\\Test2.xls",4,"K52", cellFinder.Type.NUMOFPROPERTY),
                new inputCell("D:\\Test\\ChildFolder\\Test3.xls",4,"K66", cellFinder.Type.NUMOFTAXES)
        );
        String folderPath = "D:\\Test\\";
        List<String> walkTree = walkFileTree.getWalkTree(folderPath);

        databaseInfo database1 = new databaseInfo("jdbc:postgresql://127.0.0.1:5432/JavaTest","postgres","123305");

        DatabaseConnector postgrecon = new DatabaseConnector(database1);

        var con = postgrecon.getConnection();
        if (postgrecon.hasConnection()) {
            walkTree.forEach(x -> {
                List<cellFinder> cellFinders = FormingCellFinder.form(input, x);
                List<outputCell> outputCells = null;
                try {
                    outputCells = XlsReader.SearchEngine(new FileInputStream(x), cellFinders);
                    System.out.println("\n" + x + " Read Successful \n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    DatabaseWriter.QueryExecute(outputCells, con);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        else {
            System.out.println("Exiting program...");
            exit(0);
        }
        try {
            postgrecon.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exiting program...");
        exit(1);
    }
}
