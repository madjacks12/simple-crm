package dao;

import models.Address;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAddressDao implements AddressDao {

    private final Sql2o sql2o;

    public Sql2oAddressDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Address address) {
        String sql = "INSERT INTO addresses (street, postalcode, country, city, state, clientId) VALUES (:street, :postalcode, :country, :city, :state, :clientId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(address)
                    .executeUpdate()
                    .getKey();
            address.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Address> getAllAddressesByClient(int clientId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM addresses WHERE clientId = :clientId")
                    .addParameter("clientId", clientId)
                    .executeAndFetch(Address.class);
        }
    }

    @Override
    public List<Address> getAll() {
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT * FROM addresses")
                        .executeAndFetch(Address.class);
            }
        }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from addresses WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
