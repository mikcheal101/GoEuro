/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mikky.hemen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uncle-samba
 */
public class CsvWriter {

    private String filename;
    private List<GoEuro> results;
    
    /*
    * @param filename; csv file to create
    */
    public CsvWriter(String filename) {
        this.filename = filename;
    }
    
    /*
    * @param filename; csv file to create
    */
    public CsvWriter(String filename, List<GoEuro> goEuro) {
        this.filename = filename;
        this.results = goEuro;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the results
     */
    public List<GoEuro> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<GoEuro> results) {
        this.results = results;
    }
    
    public boolean writeToFile () {
        boolean fileWritten = false;
        
        try (FileWriter fw = new FileWriter(this.filename)) {
            System.out.println("Writing to csv file [ " + getFilename() + " ]");
            StringBuilder sb;
            // append the head of the csv file
            fw.append("_id, name, type, latitude, longitude\n");
            for(GoEuro g: results) {
                sb = new StringBuilder();
                
                sb.append(g.getId());
                sb.append(',');
                
                sb.append(g.getName());
                sb.append(',');
                
                sb.append(g.getType());
                sb.append(',');
                
                sb.append(g.getGeo_position().getLatitude());
                sb.append(',');
                
                sb.append(g.getGeo_position().getLongitude());
                sb.append(',');
                sb.append('\n');
                
                fw.append(sb.toString());
                fw.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(CsvWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        fileWritten = true;
        System.out.println("Done Writing to csv file [ " + getFilename() + " ]");
        return fileWritten;
    }
    
    
}
