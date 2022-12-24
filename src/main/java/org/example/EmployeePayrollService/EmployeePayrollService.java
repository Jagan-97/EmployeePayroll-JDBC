package org.example.EmployeePayrollService;

import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "********";
        Connection connection;
        Statement statement;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcurl, username, password);
            statement = connection.createStatement();
            //Updating record in the table
            String sql1 = "UPDATE employee_payroll SET Salary ='60000' WHERE Name ='Kamal'";
            //here addBatch is used to add individual statement to the batch.
            statement.addBatch(sql1);
            //to execute statement executeBatch used
            statement.executeBatch();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll");
            System.out.println("\tName\t\tSalary");
            System.out.println("-----------------------------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + "\t"
                        + resultSet.getString(4));
            }
            connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}