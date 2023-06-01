package javadev_module5.populate;
import java.sql.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static javadev_module5.FileUtils.formatDate;
import static javadev_module5.populate.insert.PrepareStatementTest.insertWorker;


public class PopulateWorker {

    public static void main(String[] args) {
        String filePath = "worker.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                String name = fields[0].strip();
                String dateBirthday = fields[1].replace(" ", "").strip();
                String level = fields[2].strip();
                int salary = Integer.parseInt(fields[3].replace(" ", "").strip());

                Date birthday = formatDate(dateBirthday);
                insertWorker(name, birthday, level, salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

