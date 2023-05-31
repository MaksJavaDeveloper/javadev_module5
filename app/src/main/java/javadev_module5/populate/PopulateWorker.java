package javadev_module5.populate;

import javadev_module5.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static javadev_module5.populate.insert.PrepareStatementTest.insertWorker;


public class PopulateWorker {

    public static void main(String[] args) {
        String filePath = "worker.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                Date birthday1 = null;
                String level = fields[2];
                int salary = Integer.parseInt(fields[3].strip());

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date birthday;

                birthday1 = (Date) dateFormat.parse(fields[1]);
                birthday = new java.sql.Date(birthday1.getTime());



                insertWorker(name, birthday, level, salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}

