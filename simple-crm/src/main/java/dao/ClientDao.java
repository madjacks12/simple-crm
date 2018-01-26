package dao;

import models.Client;
import models.ClientType;

import java.util.List;

public interface ClientDao {

    //create
    void add (Client client);
    void addClientToClientType(Client client, ClientType clientType);

    //read
    List<Client> getAll();
    List<ClientType> getAllClientTypesForAClient(int clientId);

    Client findById(int id);

    //update
    void update(int id, String name, String email, String phone);

    //delete
    void deleteById(int id);


}
