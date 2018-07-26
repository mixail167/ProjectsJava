package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC&useUnicode=true&amp;&characterEncoding=utf8", "root", "m19n28j375k");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preStatement;
            if (conn != null) {
                preStatement = conn.prepareStatement("SELECT g_id FROM genres WHERE g_name IN (?, ?)");
                preStatement.setString(1, "Программирование");
                preStatement.setString(2, "Классика");
                ResultSet result = preStatement.executeQuery();
                while (result.next()) {
                    System.out.println("Item: " + result.getString(1));
                }
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
