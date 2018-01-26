package models;

public class ClientType {

    private int id;
    private String typeName;

    public ClientType(String typeName) {
        this.typeName=typeName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientType that = (ClientType) o;

        if (id != that.id) return false;
        return typeName.equals(that.typeName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typeName.hashCode();
        return result;
    }
}
