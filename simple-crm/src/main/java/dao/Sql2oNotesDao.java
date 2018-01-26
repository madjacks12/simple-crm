package dao;

import models.Contact;
import models.Notes;

import java.util.List;

public class Sql2oNotesDao implements NotesDao {
    @Override
    public void add(Notes notes) {

    }

    @Override
    public List<Contact> getAllNotessByClient(int clientId) {
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
