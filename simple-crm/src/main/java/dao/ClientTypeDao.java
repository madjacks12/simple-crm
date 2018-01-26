package dao;

import models.Client;
import models.ClientType;

import java.util.List;

public interface ClientTypeDao {
    void add(ClientType clientType); // N
    void addFoodtypeToRestaurant(ClientType clientType, Client client); // D

    //read
    List<ClientType> getAll(); // we may need this in the future. We can use it to retrieve all Foodtypes.
    List<Client> getAllClientsForAClientType(int id); //E we will implement this soon.

    //update
    //omit for now

    //delete
    void deleteById(int id); //see above
}
