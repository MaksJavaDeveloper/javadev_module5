package javadev_module5.populate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static javadev_module5.populate.insert.PrepareStatementTest.insertClient;

public class PopulateClient {

    public static void main(String[] args) {

        String filePath = "client.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String name;
            while ((name = bufferedReader.readLine()) != null) {

                insertClient(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
