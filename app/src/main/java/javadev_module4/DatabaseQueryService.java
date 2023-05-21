package javadev_module4;

import javadev_module4.select.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String DATABASE_URL = "jdbc:h2:./test";

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFilePath = "sql/find_max_projects_client.sql";
        String sql = FileUtils.readSQLFile(sqlFilePath);

        if (sql != null) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                List<MaxProjectCountClient> result = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int projectCount = resultSet.getInt("project_count");

                    MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                    result.add(client);
                }
                return result;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    public List<FindMaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilePath = "sql/find_max_salary_worker.sql";
        String sql = FileUtils.readSQLFile(sqlFilePath);

        if(sql != null) {
            try(Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

                List<FindMaxSalaryWorker> result = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int salary = resultSet.getInt("salary");

                    FindMaxSalaryWorker findMaxSalaryWorker = new FindMaxSalaryWorker(name,salary);
                    result.add(findMaxSalaryWorker);
                }
                return result;
            }catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return null;
    }


    List<FindYoungestEldestWorkers> findYoungestEldestWorkers() {
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";
        String sqlFile = FileUtils.readSQLFile(sqlFilePath);

        if(sqlFile != null) {
            try(Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlFile)) {

                    List<FindYoungestEldestWorkers> result = new ArrayList<>();
                    while(resultSet.next()) {
                        String type = resultSet.getString("type");
                        String name = resultSet.getString("name");
                        Date date = resultSet.getDate("birthday");

                        FindYoungestEldestWorkers findYoungestEldestWorkers = new FindYoungestEldestWorkers(type, name, date);
                        result.add(findYoungestEldestWorkers);
                    }
                    return result;
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
        }
        return null;
    }

    List<FindLongestProject> findLongestProject() {
        String sqlFilePath = "sql/find_longest_project.sql";
        String sql = FileUtils.readSQLFile(sqlFilePath);

        if(sql != null) {
            try(Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

                List<FindLongestProject> result = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int monthCount = resultSet.getInt("month_count");

                    FindLongestProject findLongestProject = new FindLongestProject(name, monthCount);
                    result.add(findLongestProject);
                }
                return result;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    List<PrintProjectPrices> printProjectPrices() {
        String sqlFilePath = "sql/print_project_prices.sql";
        String sql = FileUtils.readSQLFile(sqlFilePath);

        if(sql != null) {
            try(Connection connection = DriverManager.getConnection(DATABASE_URL);
                ResultSet resultSet = connection.createStatement().executeQuery(sql)) {

                List<PrintProjectPrices> result = new ArrayList<>();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");

                    PrintProjectPrices printProjectPrices = new PrintProjectPrices(name, price);
                    result.add(printProjectPrices);
                }
                return result;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
