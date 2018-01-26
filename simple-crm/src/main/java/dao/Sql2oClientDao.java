package dao;

import models.Client;
import models.ClientType;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oClientDao implements ClientDao {
    private final Sql2o sql2o;

    public Sql2oClientDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Client client) {
        String sql = "INSERT INTO clients (name, phone, email) VALUES (:name, :phone, email)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(client)
                    .executeUpdate()
                    .getKey();
            client.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addClientToClientType(Client client, ClientType clientType) {
        String sql = "INSERT INTO clients_clienttypes (clientid, clienttypeid) VALUES (:clientId, :clientTypeId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("restaurantId", client.getId())
                    .addParameter("foodtypeId", clientType.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Client> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM clients")
                    .executeAndFetch(Client.class);
        }
    }



    @Override
    public List<ClientType> getAllClientTypesForAClient(int clientId) {
        ArrayList<ClientType> clientTypes = new ArrayList<>();

        String joinQuery = "SELECT clienttypeid FROM clients_clienttypes WHERE clientid = :clientId";

        try (Connection con = sql2o.open()) {
            List<Integer> allClientTypeIds = con.createQuery(joinQuery)
                    .addParameter("clientId", clientId)
                    .executeAndFetch(Integer.class);
            for (Integer typeId : allClientTypeIds){
                String clienttypeQuery = "SELECT * FROM clienttypes WHERE id = :clientTypeId";
                clientTypes.add(
                        con.createQuery(clienttypeQuery)
                                .addParameter("clientTypeId", typeId)
                                .executeAndFetchFirst(ClientType.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return clientTypes;
    }

    @Override
    public Client findById(int id) {
        String sql = "SELECT * FROM clients WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Client.class);
        }
    }

    @Override
    public void update(int id, String name, String email, String phone) {
        String sql = "UPDATE clients SET name = :name, phone = :phone, email = :email";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("phone", phone)
                    .addParameter("email", email)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql ="DELETE FROM clients WHERE id = :id";
        String deleteJoin = "DELETE from clients_clienttypes WHERE clientid = :clientId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("clientId", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
