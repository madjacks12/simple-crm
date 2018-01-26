package models;

public class Address extends Client {

    private String street;
    private String postalCode;
    private String country;
    private String city;
    private String state;

    public Address(String name, String phone, String email, String street, String postalCode, String country, String city, String state) {
        super(name, phone, email);
        this.street=street;
        this.postalCode=postalCode;
        this.country=country;
        this.city=city;
        this.state=state;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}