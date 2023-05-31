package javadev_module5.populate.insert;

import java.sql.*;


public class PrepareStatementTest {

    private static final String DATABASE_URL = "jdbc:h2:./test";

    public static void insertWorker(String name, Date birthday, String level, int salary) {

        String sql = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, birthday);
            preparedStatement.setString(3, level);
            preparedStatement.setInt(4, salary);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
