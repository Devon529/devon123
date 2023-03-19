package com.kuang.lesson01;

import java.sql.*;


public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/jdbcStudy";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}

