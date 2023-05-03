package com.example.parsing_xls;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWriter {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/JavaTest";
    static final String USER = "postgres";
    static final String PASS = "123305";
    private static Connection con;
    private static ResultSet rs;
    public static List<outputCell> outputCells = new ArrayList<>();


    //Подключение к базе данных
    public static void main() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    //Выполнение запроса в базе данных
    public static void QueryExecute() {


        outputCells.forEach(outputCell -> {
            try {
                con = DriverManager.getConnection(DB_URL, USER, PASS);

                var stmt = con.createStatement();

                System.out.println(outputCell.getCellValue());

            String FillQuery = "INSERT INTO parsedxls VALUES ("+outputCell.getSheet()+", '"+outputCell.getCellAdress()+"', '"+outputCell.getCellValue()+"','"+outputCell.getCelltype()+"')";
            rs = stmt.executeQuery(FillQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}