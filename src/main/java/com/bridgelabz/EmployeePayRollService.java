package com.bridgelabz;
import java.util.*;
import java.sql.*;

public class EmployeePayRollService {
    static String url = "jdbc:mysql://localhost:3306/payroll_service";
    static String userName = "root";
    static String password = "Hariprasad@12";

    public void retrieveDataFromDatabase(String quaryFetch) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("The error in the class -" + e);
        }
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement st = connection.createStatement();
            System.out.println("The fetching the data is started  \n");
            ResultSet resultSet = st.executeQuery(quaryFetch);
            //The result we want in the table format so we use RS
            //fetch the data
            System.out.println("The result set - " + resultSet);
            while (resultSet.next()) {
                String userData =resultSet.getInt(1)+":"+resultSet.getString(2)+":"+resultSet.getString(3)+":"+resultSet.getDouble(4)+":"+resultSet.getDate(5).toLocalDate()+":"+resultSet.getString(6)+":"+resultSet.getString(7)+":"+resultSet.getString(8)+":"+resultSet.getFloat(9)+":"+resultSet.getFloat(10)+":"+resultSet.getFloat(11)+":"+resultSet.getFloat(12)+":"+resultSet.getFloat(13);
                System.out.println(userData);
            }
            System.out.println("Closing point of the Fetch method");
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("The error at the Connection - " + e);
        }
    }

    public static void main(String[] args) {
        EmployeePayRollService employeePayRollService = new EmployeePayRollService();
        employeePayRollService.retrieveDataFromDatabase("select * from payroll_service"E);
    }
}
