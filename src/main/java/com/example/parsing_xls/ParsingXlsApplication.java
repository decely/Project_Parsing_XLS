package com.example.parsing_xls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.lang.System.exit;

public class ParsingXlsApplication {

    public static void main(String[] args) throws IOException, SQLException {
        databaseInfo database1 = new databaseInfo("jdbc:postgresql://127.0.0.1:5432/JavaTest","postgres","123305");
        String FileAddress = "D:\\Test\\Test2.xls";

        DatabaseConnector postgrecon = new DatabaseConnector(database1);

        var con = postgrecon.getConnection();

        if (postgrecon.hasConnection()) {
            List<outputCell> outputCells = XlsReader.SearchEngine(FileAddress);
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
