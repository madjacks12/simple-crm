package dao;

import models.Contact;
import models.Notes;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNotesDao implements NotesDao {

    private final Sql2o sql2o;

    public Sql2oNotesDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Notes notes) {
        String sql = "INSERT INTO contacts (writtenBy, content, createdAt, clientId) VALUES (:writtenBy, :content, :createdAt, :clientId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(notes)
                    .executeUpdate()
                    .getKey();
            notes.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Notes> getAllNotessByClient(int clientId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM notes WHERE clientId = :clientId")
                    .addParameter("clientId", clientId)
                    .executeAndFetch(Notes.class);
        }
    }

    @Override
    public List<Notes> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM notes")
                    .executeAndFetch(Notes.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from notes WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
