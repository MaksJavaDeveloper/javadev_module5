package javadev_module4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String filePath = "sql/populate_db.sql";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test")) {
            String sql = FileUtils.readSQLFile(filePath);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}