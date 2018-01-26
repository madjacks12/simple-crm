package models;

public class Contact{

    private String firstName;
    private String lastName;
    private String position;
    private String contactPhone;
    private String contactEmail;
    private int id;
    private int clientId;

    public Contact(String firstName, String lastName, String position, String contactPhone, String contactEmail, int clientId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
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

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (clientId != contact.clientId) return false;
        if (!firstName.equals(contact.firstName)) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
        if (position != null ? !position.equals(contact.position) : contact.position != null) return false;
        if (!contactPhone.equals(contact.contactPhone)) return false;
        return contactEmail.equals(contact.contactEmail);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + contactPhone.hashCode();
        result = 31 * result + contactEmail.hashCode();
        result = 31 * result + id;
        result = 31 * result + clientId;
        return result;
    }
}
