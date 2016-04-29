/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mikky.hemen;

/**
 *
 * @author uncle-samba
 */
public class GoEuro {
    private int _id;
    private String key;
    private String name;
    private String fullname;
    private String iata_airport_code;
    private String type;
    private String country;
    
    private GeoPosition geo_position;
    private long location_id;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private long distance;

    public GoEuro() {
        this._id = 0;
        this.key = "";
        this.name = "";
        this.fullname = "";
        this.iata_airport_code = "";
        this.type = "";
        this.country = "";
        this.geo_position = new GeoPosition();
        this.location_id = 0;
        this.inEurope = false;
        this.countryCode = "";
        this.coreCountry = false;
        this.distance = 0;
    }

    public GoEuro(int _id, String key, String name, String fullname, String iata_airport_code, String type, String country, GeoPosition geo_position, long location_id, boolean inEurope, String countryCode, boolean coreCountry, long distance) {
        this._id = _id;
        this.key = key;
        this.name = name;
        this.fullname = fullname;
        this.iata_airport_code = iata_airport_code;
        this.type = type;
        this.country = country;
        this.geo_position = geo_position;
        this.location_id = location_id;
        this.inEurope = inEurope;
        this.countryCode = countryCode;
        this.coreCountry = coreCountry;
        this.distance = distance;
    }

    
    
    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        try {
            this.key = key;
        } catch (NullPointerException e) {
            this.key = "";
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        
        try {
            this.name = name;
        } catch (NullPointerException e) {
            this.name = "";
        }
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        
        try {
            this.fullname = fullname;
        } catch (NullPointerException e) {
            this.fullname = "";
        }
    }

    /**
     * @return the iata_airport_code
     */
    public String getIata_airport_code() {
        return iata_airport_code;
    }

    /**
     * @param iata_airport_code the iata_airport_code to set
     */
    public void setIata_airport_code(String iata_airport_code) {
        try {
            this.iata_airport_code = iata_airport_code;
        } catch (NullPointerException e) {
            this.iata_airport_code = "";
        }
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        try {
            this.type = type;
        } catch (NullPointerException e) {
            this.type = "";
        }
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        
        try {
            this.country = country;
        } catch (NullPointerException e) {
            this.country = "";
        }
    }

    /**
     * @return the geo_position
     */
    public GeoPosition getGeo_position() {
        return geo_position;
    }

    /**
     * @param geo_position the geo_position to set
     */
    public void setGeo_position(GeoPosition geo_position) {
        this.geo_position = geo_position;
    }

    /**
     * @return the location_id
     */
    public long getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the inEurope
     */
    public boolean isInEurope() {
        return inEurope;
    }

    /**
     * @param inEurope the inEurope to set
     */
    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        try {
            this.countryCode = countryCode;
        } catch (NullPointerException e) {
            this.countryCode = "";
        }
    }

    /**
     * @return the coreCountry
     */
    public boolean isCoreCountry() {
        return coreCountry;
    }

    /**
     * @param coreCountry the coreCountry to set
     */
    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    /**
     * @return the distance
     */
    public long getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(long distance) {
        this.distance = distance;
    }

    class GeoPosition {
        protected double latitude;
        protected double longitude;

        public GeoPosition(double latitude, double longitude) {
            this.setLatitude(latitude);
            this.setLongitude(longitude);
        }

        public GeoPosition() {
            this.setLatitude(0);
            this.setLongitude(0);
        }
        
        /**
         * @return the latitude
        */
        public double getLatitude() {
            return latitude;
        }

       /**
        * @param latitude the latitude to set
        */
        public final void setLatitude(double latitude) {
            this.latitude = latitude;
        }

       /**
        * @return the longitude
        */
        public double getLongitude() {
            return longitude;
        }

       /**
        * @param longitude the longitude to set
        */
        public final void setLongitude(double longitude) {
            this.longitude = longitude;
        }
        
    }
}
