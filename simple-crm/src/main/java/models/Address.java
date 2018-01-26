package models;

public class Address {

    private String street;
    private String number;
    private String postalCode;
    private String country;
    private String city;
    private String state;

    public Address(String street, String number, String postalCode, String country, String city, String state){
        this.street=street;
        this.number=number;
        this.postalCode = postalCode;
        this.country = country;
        this.city=city;
        this.state=state;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
}
