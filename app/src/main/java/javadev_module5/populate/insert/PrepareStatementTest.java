package javadev_module5.populate.insert;

import org.h2.store.DataReader;

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

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertClient(String name) {
        String sql = "INSERT INTO client (name) VALUES (?)";

        try(Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertProject(int clientId, Date startDate, Date finishDate) {
        String sql = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, clientId);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertProjectWorker(int projectId, int workerId) {
        String sql = "INSERT INTO project_worker(project_id, worker_id) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, projectId);
            preparedStatement.setInt(2, workerId);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
