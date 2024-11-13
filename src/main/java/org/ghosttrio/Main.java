package org.ghosttrio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // 여러 자원을 try-with-resources로 사용
        try (
                BufferedReader br = new BufferedReader(new FileReader("csv.txt"));
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM my_table")
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            while (rs.next()) {
                System.out.println("레코드: " + rs.getString("column_name"));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}