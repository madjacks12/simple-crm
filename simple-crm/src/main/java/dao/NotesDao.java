package dao;

import models.Contact;
import models.Notes;

import java.util.List;

public interface NotesDao {

    void add(Notes notes);

    //read
    List<Notes> getAllNotessByClient(int clientId);
    List<Notes> getAll();

    void deleteById(int id);

}
