package com.bridgelabz;
import java.util.*;
import java.sql.*;

public class EmployeePayRollService {
    static String url = "jdbc:mysql://localhost:3306/payroll_service";
    static String userName = "root";
    static String password = "d11cpk1211";

    public void retrieveDataFromDatabase(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("The error in the class -" + e);
        }
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement st = connection.createStatement();
            System.out.println("The fetching the data is started  \n");
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)+":"+resultSet.getString(2)+":"+resultSet.getString(3)+":"+resultSet.getDouble(4)+":"+resultSet.getDate(5).toLocalDate()+":"+resultSet.getString(6)+":"+resultSet.getString(7)+":"+resultSet.getString(8)+":"+resultSet.getFloat(9)+":"+resultSet.getFloat(10)+":"+resultSet.getFloat(11)+":"+resultSet.getFloat(12)+":"+resultSet.getFloat(13));
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("The error at the Connection - " + e);
        }
    }

    public void updateDatabase(String query){
        try {
            Connection connection =DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            int count =statement.executeUpdate(query);
            System.out.println("The no row are updated "+ count);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Exception - "+ e.getMessage());
        }
    }
    public static void main(String[] args) {
        EmployeePayRollService employeePayRollService = new EmployeePayRollService();
        employeePayRollService.retrieveDataFromDatabase("select * from employee_payroll");
        employeePayRollService.updateDatabase("update employee_payroll set salary = 3000000.0 where name = 'Terissa' ");
        employeePayRollService.retrieveDataFromDatabase("select * from employee_payroll");
    }
}
