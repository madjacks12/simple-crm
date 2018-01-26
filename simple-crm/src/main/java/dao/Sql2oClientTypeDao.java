package dao;

import models.Client;
import models.ClientType;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oClientTypeDao implements ClientTypeDao {

    private final Sql2o sql2o;

    public Sql2oClientTypeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


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
