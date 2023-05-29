package javadev_module5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String filePath = "sql/populate_db.sql";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test")) {
            String sql = FileUtils.readSQLFile(filePath);
            connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}