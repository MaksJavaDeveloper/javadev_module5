package javadev_module5;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseInitService {
    public static void main(String[] args) {
        String filePath = "sql/init_db.sql";

        String sql = FileUtils.readSQLFile(filePath);

        if (sql != null) {
            try (Connection connection = DriverManager.getConnection("jdbc:h2:./test")) {
                connection.prepareStatement(sql).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}