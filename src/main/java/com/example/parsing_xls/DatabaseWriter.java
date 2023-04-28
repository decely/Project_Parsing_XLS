package com.example.parsing_xls;

import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseWriter {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/JavaTest";
    static final String USER = "postgres";
    static final String PASS = "123305";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


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
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = con.createStatement();

            String CreateQuery = "CREATE TABLE table_name (\n" +
                    "    column1 varchar,\n" +
                    "    column2 Integer,\n" +
                    "    column3 varchar\n" +
                    "); ";

            String FillQuery = "INSERT INTO table_name VALUES ('anna', 10, 'dog')";
            rs = stmt.executeQuery(CreateQuery + FillQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}