package javadev_module5.populate;

import javadev_module5.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javadev_module5.populate.insert.PrepareStatementTest.insertWorker;


public class PopulateWorker {
    private static final String DATABASE_URL = "jdbc:h2:./test";

    public static void main(String[] args) {
        String filePath = "worker.txt";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String sql = FileUtils.readSQLFile(filePath);
            connection.prepareStatement(sql).execute();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null)  {
                    String[] fields = line.split(",");

                    String name = fields[0];
                    String birthdayString = fields[1];
                    int level = Integer.parseInt(fields[2]);
                    int salary = Integer.parseInt(fields[3]);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = dateFormat.parse(birthdayString);

                    insertWorker(name, (java.sql.Date) birthday, level, salary);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
