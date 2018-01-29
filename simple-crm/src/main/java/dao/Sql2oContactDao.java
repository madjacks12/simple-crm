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
                    .bind(contact)
                    .executeUpdate()
                    .getKey();
            contact.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Contact> getAllContactsByClient(int clientId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM contacts WHERE clientId = :clientId")
                    .addParameter("clientId", clientId)
                    .executeAndFetch(Contact.class);
        }
    }

    @Override
    public List<Contact> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM contacts")
                    .executeAndFetch(Contact.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from contacts WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
