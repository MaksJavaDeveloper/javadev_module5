package javadev_module5.populate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import static javadev_module5.FileUtils.formatDate;
import static javadev_module5.populate.insert.PrepareStatementTest.insertProject;

public class PopulateProject {

    public static void main(String[] args) {
        String filePath = "project.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");

                int clientId = Integer.parseInt(fields[0].strip());
                String dateStart = fields[1].replace(" ", "").strip();
                String dateFinish = fields[2].replace(" ", "").strip();

                Date startDate = formatDate(dateStart);

                Date finishDate = formatDate(dateFinish);

                insertProject(clientId, startDate, finishDate);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
