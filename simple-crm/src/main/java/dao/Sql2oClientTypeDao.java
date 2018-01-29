package dao;

import models.Client;
import models.ClientType;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oClientTypeDao implements ClientTypeDao {

    private final Sql2o sql2o;

    public Sql2oClientTypeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(ClientType clientType) {
        String sql = "INSERT INTO clienttypes (clientname) VALUES (:clientname)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(clientType)
                    .executeUpdate()
                    .getKey();
            clientType.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addFoodtypeToRestaurant(ClientType clientType, Client client) {
        String sql = "INSERT INTO clients_clienttypes (clientid, clienttypeid) VALUES (:clientid, :clienttypeid)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("clientid", client.getId())
                    .addParameter("clienttypeid", clientType.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<ClientType> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM clienttypes")
                    .executeAndFetch(ClientType.class);
        }
    }

    @Override
    public List<Client> getAllClientsForAClientType(int clienttypeId) {
        ArrayList<Client> clients = new ArrayList<>();

        String joinQuery = "SELECT clientid FROM clients_clienttypes WHERE clienttypeId = :clienttypeId";

        try (Connection con = sql2o.open()) {
            List<Integer> allClientIds = con.createQuery(joinQuery)
                    .addParameter("clienttypeId", clienttypeId)
                    .executeAndFetch(Integer.class);
            for (Integer clientId : allClientIds){
                String clientQuery = "SELECT * FROM clients WHERE id = :clientId";
                clients.add(
                        con.createQuery(clientQuery)
                                .addParameter("clientId", clientId)
                                .executeAndFetchFirst(Client.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return clients;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from clienttypes WHERE id = :id";
        String deleteJoin = "DELETE from clients_clienttypes WHERE clientTypeid = :clientTypeId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

            con.createQuery(deleteJoin)
                    .addParameter("clienttypeId", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
