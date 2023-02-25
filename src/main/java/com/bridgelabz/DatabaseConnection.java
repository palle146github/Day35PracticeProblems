package com.bridgelabz;

import java.util.*;
import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "d11cpk1211";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the class", e);
        }
        listDrivers();

        try {
            System.out.println("Connectiong to database");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection is successful" + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("  " + driverClass.getClass().getName());
        }
    }
}

