package dao;

import models.Address;
import models.Contact;

import java.util.List;

public interface ContactDao {

    void add(Contact contact);

    //read
    List<Contact> getAllContactsByClient(int clientId);
    List<Contact> getAll();

    void deleteById(int id);
}
