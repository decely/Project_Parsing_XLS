package com.example.parsing_xls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.nio.file.Path;

import static java.lang.System.exit;

public class ParsingXlsApplication {

    public static void main(String[] args) throws IOException, SQLException {
        String folderPath = "D:\\Test\\";
        List<String> walkTree = walkFileTree.getWalkTree(folderPath);

        databaseInfo database1 = new databaseInfo("jdbc:postgresql://127.0.0.1:5432/JavaTest","postgres","123305");

        DatabaseConnector postgrecon = new DatabaseConnector(database1);

        var con = postgrecon.getConnection();

        if (postgrecon.hasConnection()) {
            List<outputCell> outputCells = XlsReader.SearchEngine(walkTree);
            DatabaseWriter.QueryExecute(outputCells,con);
            postgrecon.closeConnection();
            System.out.println("Exiting program...");
            exit(1);
        }
        else {
            System.out.println("Exiting program...");
            exit(0);
        }
    }
}
