package models;

public class Address extends Client {

    private String street;
    private String postalCode;
    private String country;
    private String city;
    private String state;
    private int id;
    private int clientId;

    public Address(String name, String phone, String email, int clientId, String street, String postalCode, String country, String city, String state) {
        super(name, phone, email, clientId);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (clientId != address.clientId) return false;
        if (!street.equals(address.street)) return false;
        if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (!city.equals(address.city)) return false;
        return state != null ? state.equals(address.state) : address.state == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + clientId;
        return result;
    }
}