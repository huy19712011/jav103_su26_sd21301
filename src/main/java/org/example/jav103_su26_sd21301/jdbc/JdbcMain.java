package org.example.jav103_su26_sd21301.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcMain {

    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("jav103_su26_sd21301", "sa", "123456");

        try (Connection connection = dcm.getConnection()) {

            System.out.println("Connected...");

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

}
