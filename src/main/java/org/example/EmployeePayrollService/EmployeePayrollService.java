package org.example.EmployeePayrollService;

import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "*******";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            String sql1 = "SELECT * FROM employee_payroll WHERE StartDate BETWEEN '18-10-2020' AND NOW()";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.execute(sql1);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println();
            System.out.println("EmployeeID\t\tName\t\tSalary\t\tStartDate\tgender");
            System.out.println("----------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t\t"
                        + resultSet.getString(4) + "\t\t"
                        + resultSet.getString(5));
            }
            connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}