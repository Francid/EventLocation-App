package com.example.franchez.myswipe;

/**
 * Created by Franchez on 2015-11-28.
 */
public class EventBrite_Venue_Class {

    /**
     * address_1 : 55 Town Centre Court, Suite 401
     * address_2 : null
     * city : Scarborough, Ontario
     * region : null
     * postal_code : M1P 4X4
     * country : CA
     * latitude : 43.7738822
     * longitude : -79.2541809
     */

    private AddressEntity address;
    /**
     * address : {"address_1":"55 Town Centre Court, Suite 401","address_2":null,"city":"Scarborough, Ontario ","region":null,"postal_code":"M1P 4X4","country":"CA","latitude":43.7738822,"longitude":-79.2541809}
     * resource_uri : https://www.eventbriteapi.com/v3/venues/12125984/
     * id : 12125984
     * name : Catholic Crosscultural Services
     * latitude : 43.7738822
     * longitude : -79.2541809
     */

    private String resource_uri;
    private String id;
    private String name;
    private String latitude;
    private String longitude;

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public String getResource_uri() {
        return resource_uri;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public static class AddressEntity {
        private String address_1;
        private Object address_2;
        private String city;
        private Object region;
        private String postal_code;
        private String country;
        private double latitude;
        private double longitude;

        public void setAddress_1(String address_1) {
            this.address_1 = address_1;
        }

        public void setAddress_2(Object address_2) {
            this.address_2 = address_2;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setRegion(Object region) {
            this.region = region;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getAddress_1() {
            return address_1;
        }

        public Object getAddress_2() {
            return address_2;
        }

        public String getCity() {
            return city;
        }

        public Object getRegion() {
            return region;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public String getCountry() {
            return country;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}
