package models;

public class Client {

    private String name;
    private String phone;
    private String email;
    private int id;

    public Client(String name, String phone, String email) {
        this.name=name;
        this.phone=phone;
        this.email = email;
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
