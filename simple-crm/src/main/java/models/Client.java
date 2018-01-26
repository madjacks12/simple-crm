package models;

public class Client {

    private String name;
    private String phone;
    private String email;
    private int clientId;

    public Client(String name, String phone, String email, int clientId) {
        this.name=name;
        this.phone=phone;
        this.email = email;
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return clientId;
    }

    public void setId(int id) {
        this.clientId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (!name.equals(client.name)) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        return email != null ? email.equals(client.email) : client.email == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + clientId;
        return result;
    }
}
