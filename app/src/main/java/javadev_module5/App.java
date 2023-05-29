/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javadev_module5;

import javadev_module5.select.*;

import java.util.List;

public class App {

    public static void main(String[] args) {

        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();


        for (MaxProjectCountClient client : maxProjectCountClients) {
            System.out.println("client = " + client.getName() + ", " + "projectCount = " + client.getProjectCount());
        }

        System.out.println();
        List<FindMaxSalaryWorker> findMaxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();

        for (FindMaxSalaryWorker findMaxSalaryWorker : findMaxSalaryWorkers) {
            System.out.println("name = " + findMaxSalaryWorker.getName() + ", " + "salary = " + findMaxSalaryWorker.getSalary());
        }

        System.out.println();
        List<FindYoungestEldestWorkers> findYoungestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();

        for (FindYoungestEldestWorkers findYoungestEldestWorker : findYoungestEldestWorkers) {
            System.out.println("type = " + findYoungestEldestWorker.getType() + ", "
                    + "name = " + findYoungestEldestWorker.getName() + ", "
            + "birthday = " + findYoungestEldestWorker.getBirthday());
        }

        System.out.println();
        List<FindLongestProject> findLongestProject = new DatabaseQueryService().findLongestProject();

        for (FindLongestProject longestProject : findLongestProject) {
            System.out.println("name = " + longestProject.getName() + ", " + "monthCount = " + longestProject.getMonthCount());
        }

        System.out.println();
        List<PrintProjectPrices> printProjectPrices = new DatabaseQueryService().printProjectPrices();

        for (PrintProjectPrices printProjectPrice : printProjectPrices) {
            System.out.println("name = " + printProjectPrice.getName() + ", " + "price = " + printProjectPrice.getPrice());

        }
    }
}