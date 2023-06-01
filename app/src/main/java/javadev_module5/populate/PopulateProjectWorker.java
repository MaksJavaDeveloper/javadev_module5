package javadev_module5.populate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static javadev_module5.populate.insert.PrepareStatementTest.insertProjectWorker;

public class PopulateProjectWorker {

    public static void main(String[] args) {
        String filePath = "project_worker.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                int projectId = Integer.parseInt(fields[0].strip());
                int workerId = Integer.parseInt(fields[1].strip());

                insertProjectWorker(projectId, workerId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
