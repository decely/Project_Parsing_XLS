package com.example.parsing_xls;

import java.sql.*;
import java.util.List;

public class DatabaseWriter {

    public static void QueryExecute(List<outputCell> outputCells, Connection connection) throws SQLException {
        var stmt = connection.createStatement();

        outputCells.forEach(outputCell -> {
            try {
            String FillQuery = "INSERT INTO parsedxls VALUES ("
                    +outputCell.getSheet()+",'"
                    +outputCell.getCellAdress()+"','"
                    +outputCell.getCellValue()+"','"
                    +outputCell.getCelltype()+"')";
            stmt.execute(FillQuery);
            System.out.println("Output cell "+outputCell.getCellValue()+ " added successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        stmt.close();
    }
}