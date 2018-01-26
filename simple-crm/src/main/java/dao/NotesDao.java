package dao;

import models.Contact;
import models.Notes;

import java.util.List;

public interface NotesDao {

    void add(Notes notes);

    //read
    List<Contact> getAllNotessByClient(int clientId);
    List<Contact> getAll();

    void deleteById(int id);

}
