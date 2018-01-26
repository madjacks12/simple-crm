package models;

public class ClientType {

    private int id;
    private String typeName;
    private int clientId;

    public ClientType(String typeName, int clientId) {
        this.typeName=typeName;
        this.clientId=clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

        ClientType that = (ClientType) o;

        if (id != that.id) return false;
        if (clientId != that.clientId) return false;
        return typeName.equals(that.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typeName.hashCode();
        result = 31 * result + clientId;
        return result;
    }
}
