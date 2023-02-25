package com.bridgelabz;

import java.util.*;
import java.sql.*;

public class DatabaseConnection {
    public static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(driverClass.getClass().getName());
        }
    }
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String passWord = "d11cpk1211";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find driver in the class path", e);
        }
        listDrivers();
        try {
            System.out.println("Connecting to databse : " + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, passWord);
            System.out.println("Connection is Successful " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

