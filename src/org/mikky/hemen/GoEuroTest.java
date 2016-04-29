/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mikky.hemen;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author uncle-samba
 */
public class GoEuroTest {
    public static void main (String[] args) {
        // read the entered arguements
        boolean correct = false;
        do {
            if (args.length < 1 || args.length > 1) {
                correct = false;
                System.out.println("Wrong input: Please Enter only a city name with no spaces");
                System.exit(0);
            } else {
                String city_name = args[0];
                String url = "http://api.goeuro.com/api/v2/position/suggest/en/" + city_name;
                JsonParser jp = new JsonParser(url);
                List<GoEuro> g = jp.getData();
                CsvWriter csvWriter = new CsvWriter(new Timestamp(new Date().getTime()) + ".csv");
                csvWriter.setResults(g);
                csvWriter.writeToFile();
                correct = true;
            }
            
        } while (!correct);
        
    }
}
