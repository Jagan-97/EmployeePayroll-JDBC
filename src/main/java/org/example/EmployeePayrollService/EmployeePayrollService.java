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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll");
            while (resultSet.next()) {
                System.out.println("Name :" + resultSet.getString("Name"));
                System.out.println("basic_pay :" + resultSet.getString("basic_pay"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}