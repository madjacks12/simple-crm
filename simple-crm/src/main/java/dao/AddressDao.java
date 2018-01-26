package dao;

import models.Address;

import java.util.List;

public interface AddressDao {
    //create
    void add(Address address);

    //read
    List<Address> getAllAddressesByClient(int clientId);
    List<Address> getAll();

    void deleteById(int id);

}
