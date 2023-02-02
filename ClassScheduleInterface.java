package com.example.demo1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ClassScheduleInterface {
    static void createTable(Connection con, String sqlInsert)
    {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlInsert);
            System.out.println("Table is created succesfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static void dropTable(Connection con, String tableName)
    {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("drop table "+tableName);
            System.out.println(tableName+" was dropped succesfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
