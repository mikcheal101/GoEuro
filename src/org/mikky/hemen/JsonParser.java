/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mikky.hemen;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uncle-samba
 */
public class JsonParser {
    private String url;
    private String jsonData;
    
    private JsonObject jObject;
    private com.google.gson.JsonParser jParser;
    private JsonArray jArray;
    
    private List<GoEuro> goEuro;
    
    public JsonParser(String url) {
        this.url = url;
        this.jsonData = "";
        jParser = new com.google.gson.JsonParser();
    }
    
    private String getJson () {
        BufferedReader br = null;
        StringBuilder sb = null;
        URL uri = null;
        
        try {
            uri = new URL(url);
            br = new BufferedReader(new InputStreamReader(uri.openStream()));
            sb = new StringBuilder();
            String read;
            
            while ((read = br.readLine()) != null) sb.append(read).append("\n");
            jsonData = sb.toString();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jsonData;
    }
    
    public List<GoEuro> getData () {
        this.getJson();
        jArray = (JsonArray) jParser.parse(jsonData);
        goEuro = new ArrayList<>(jArray.size());
        
        
        for (JsonElement element: jArray) {
            JsonObject jo = (JsonObject) element;
            GoEuro go_euro = new GoEuro();
            
            go_euro.setId((!jo.get("_id").isJsonNull())? jo.get("_id").getAsInt() : 0);
            go_euro.setKey(jo.get("key").toString());
            go_euro.setName(jo.get("name").toString());
            go_euro.setFullname(jo.get("fullName").toString());
            go_euro.setIata_airport_code(jo.get("iata_airport_code").toString());
            go_euro.setType(jo.get("type").toString());
            go_euro.setCountry(jo.get("country").toString());
            go_euro.setLocation_id((!jo.get("locationId").isJsonNull())?jo.get("locationId").getAsInt():0);
            go_euro.setInEurope(jo.get("inEurope").getAsBoolean());
            go_euro.setCountryCode(jo.get("countryCode").toString());
            go_euro.setCoreCountry(jo.get("coreCountry").getAsBoolean());
            
            go_euro.setDistance((!jo.get("distance").isJsonNull())?jo.get("distance").getAsInt():0);
            
            GoEuro.GeoPosition geoPosition = go_euro.getGeo_position();
            
            JsonObject jo_ = (JsonObject) jo.get("geo_position");
            geoPosition.setLatitude(jo_.get("latitude").getAsDouble());
            
            geoPosition.setLongitude(jo_.get("longitude").getAsDouble());
            go_euro.setGeo_position(geoPosition);
            
            goEuro.add(go_euro);
        }
        return goEuro;
    }
    
    
}
