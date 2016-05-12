
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java
 */
public class Example {
    public static void main(String[] args) {
        
        // Create a set of workers
        ArrayList<Worker> workers = (ArrayList)DataUtils.createWorkers("/Users/java/NetBeansProjects/WeekTwoTutoring/data/MOCK_DATA.csv");
        
        System.out.println("\n\n====== Collection Operations (Sort w/Comparator, forEach...) ======");
        // Sort and output
        Collections.sort(workers, new GivenNameComparator());
        consoleWorkers("Given Name (natural)", workers);
        
        // Sort and output
        Collections.sort(workers, new IncomeComparator());
        consoleWorkers("Income (natural)", workers);
        
        
        System.out.println("\n\n====== Lambda forEach / map ======");
        workers.subList(0, 3).forEach(worker -> System.out.println(worker)); // Alt syntax
        workers.subList(0, 3).stream().map(worker -> {
            if(worker.getIncome().doubleValue() < 60000) {
                worker.setIncome(worker.getIncome().doubleValue() * 1.1);
            } else if(worker.getIncome().doubleValue() < 75000) {
                worker.setIncome(worker.getIncome().doubleValue() * 1.15);
            }
            return worker;
        }).forEach(worker -> {
            System.out.println(
                    String.format("After raise.. %s %s $%.2f", 
                            worker.getGivenName(), 
                            worker.getFamilyName(), 
                            worker.getIncome()
                    )
            );
        });
        
    }
    
    public static void consoleWorkers(String operation, ArrayList<Worker> workers) {
        System.out.println(String.format("\n\n------ %s ------", operation));
        workers.subList(0, 5).stream().forEach(System.out::println);
        System.out.println("...");
        workers.subList(workers.size() -5, workers.size()).forEach(System.out::println);
    }
    
}



class GivenNameComparator implements Comparator<Worker> {
    public int compare(Worker w1, Worker w2) {
        return w1.getGivenName().compareTo(w2.getGivenName());
    }
}

class RegionComparator implements Comparator<Worker> {
    public int compare(Worker w1, Worker w2) {
        return w1.getRegion().compareTo(w2.getRegion());
    }
}

class IncomeComparator implements Comparator<Worker> {
    public int compare(Worker w1, Worker w2) {
        return (
                w1.getIncome().doubleValue() > w2.getIncome().doubleValue() ? 1 : (
                    w1.getIncome().doubleValue() < w2.getIncome().doubleValue() ? -1 : 0)
                );
                
        
    }
}