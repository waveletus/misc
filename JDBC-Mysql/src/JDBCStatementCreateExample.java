package com.mkyong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by xaliu on 6/12/15.
 */


public class JDBCStatementCreateExample {

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:MKYONGCOM";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";
    private static final DateFormat dateFormat = new SimpleDateFormat(
            "yyyy/MM/dd HH:mm:ss");

    public static void main(String[] argv) {

        try {

            //createDbUserTable();
            insertRecordIntoDbUserTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void createDbUserTable() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE DBUSER("
                + "USER_ID integer(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(createTableSQL);
            // execute the SQL stetement
            statement.execute(createTableSQL);

            System.out.println("Table \"dbuser\" is created!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {
//
//            dbConnection = DriverManager.getConnection(
//                    DB_CONNECTION, DB_USER, DB_PASSWORD);
//

            dbConnection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mkyongcom","root", "password");
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    private static void insertRecordIntoDbUserTable() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

//        String insertTableSQL = "INSERT INTO DBUSER"
//                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
//                + "(1,'mkyong','system', " + "to_date('"
//                + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";

        String insertTableSQL = "INSERT INTO DBUSER"
                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
                + "(1,'mkyong','system', " + "CURDATE())";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(insertTableSQL);

            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static void getDataFromDbUserTable() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

//        String insertTableSQL = "INSERT INTO DBUSER"
//                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
//                + "(1,'mkyong','system', " + "to_date('"
//                + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";

        String sql = "select created_date from DBUSER where user_id = 1";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(sql);

            // execute insert SQL stetement
            statement.execute(sql);

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static String getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return dateFormat.format(today.getTime());

    }

}