package javadev_module4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        String filePath = "sql/init_db.sql";

        String sql = FileUtils.readSQLFile(filePath);

        if (sql != null) {
            try (Connection connection = DriverManager.getConnection("jdbc:h2:./test")) {
                connection.createStatement().executeQuery(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}