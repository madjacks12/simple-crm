package dao;

import models.Contact;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oContactDao implements ContactDao {
    private final Sql2o sql2o;

    public Sql2oContactDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Contact contact) {
        String sql = "INSERT INTO contacts (firstname, lastname, position, contactPhone, contactEmail, clientId) VALUES (:firstname, :lastname, :position, :contactPhone, :contactEmail, :clientId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(address)
                    .executeUpdate()
                    .getKey();
            address.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Contact> getAllContactsByClient(int clientId) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
