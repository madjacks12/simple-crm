package dao;

import models.Client;
import models.ClientType;

import java.util.List;

public class Sql2oClientTypeDao implements ClientTypeDao {

    @Override
    public void add(ClientType clientType) {

    }

    @Override
    public void addFoodtypeToRestaurant(ClientType clientType, Client client) {

    }

    @Override
    public List<ClientType> getAll() {
        return null;
    }

    @Override
    public List<Client> getAllClientsForAClientType(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
