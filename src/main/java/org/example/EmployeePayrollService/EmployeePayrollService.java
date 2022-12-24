package org.example.EmployeePayrollService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "********";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcurl, username, password);
            connection.createStatement();
            System.out.println("Database connection to payroll_service mysql DB is established.");

        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}