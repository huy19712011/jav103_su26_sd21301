package org.example.jav103_su26_sd21301.jdbc;

import org.example.jav103_su26_sd21301.utils.EntityManagerUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcMain {

    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("jav103_su26_sd21301", "sa", "123456");

        //test connection
        try (Connection connection = dcm.getConnection()) {

            System.out.println("Connected...");

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }

        //creating EM => auto create tables in DB
        try (var em = EntityManagerUtils.getEntityManager()){

            System.out.println("Created tables...");

        } catch (Exception e) {
            System.out.println("Failed to create Entity Manager");
            e.printStackTrace();
        }
    }

}
