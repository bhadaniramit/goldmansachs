package PojoClass;

public class AddressPojo {
    private String house;
    private String street;
    private String city;
    private int zipcode;
    private String country;
    private GeoPojo geoPojo;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPojo getGeoPojo() {
        return geoPojo;
    }

    public void setGeoPojo(GeoPojo geoPojo) {
        this.geoPojo = geoPojo;
    }
}
