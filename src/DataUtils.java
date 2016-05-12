
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
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
public class DataUtils {
    
    public static List<Worker> createWorkers(String filename) {
        List<Worker> workers = new ArrayList<>();
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] workerValues = line.split(",");
                
                Worker worker = new Worker(
                        Integer.parseInt(workerValues[0]), 
                        workerValues[1], 
                        workerValues[2], 
                        workerValues[3], 
                        workerValues[12], 
                        NumberFormat.getInstance().parse(workerValues[13])
                );
                
                worker.setStreetNumber(workerValues[11]);
                worker.setStreetName(String.format("%s %s", workerValues[8], workerValues[14]));
                worker.setLocality(workerValues[7]);
                worker.setRegion(workerValues[9]);
                worker.setCountry(workerValues[6]);
                worker.setPostcode(workerValues[10]);
                
                if(workerValues[4] == "Male") {
                    worker.setGender(Gender.MALE);
                } else {
                    worker.setGender(Gender.FEMALE);
                }
            
                
                workers.add(worker);
            }
        } catch(Exception e) {
            // Do something?
            System.out.println(e.getMessage());
        }
        
        return workers;
    }
    
}
