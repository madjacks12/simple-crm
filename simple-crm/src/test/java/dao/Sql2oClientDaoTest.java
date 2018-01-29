package dao;

import models.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.sql.*;
import java.sql.PreparedStatement;

import static org.junit.Assert.*;

public class Sql2oClientDaoTest {

    private final String url = "jdbc:postgresql://localhost:5432/crm";
    private final String user = "admin";
    private final String password = "admin";

    private Connection conn;
    private Sql2oClientDao clientDao;
    private Sql2oClientTypeDao clientTypeDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/crm";
        Sql2o sql2o = new Sql2o(connectionString, "admin", "admin");
        clientDao = new Sql2oClientDao(sql2o);
        clientTypeDao = new Sql2oClientTypeDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        String delete = "DELETE FROM clients";
        conn.createQuery(delete)
            .executeUpdate();
        conn.close();
    }

    @Test
    public void addingClientSetsId_1() throws Exception {
        Client testClient = setupClient();
        int originalClientId = testClient.getId();
        clientDao.add(testClient);
        //must add +1 to expected every time.
        assertEquals(1, testClient.getId());

    }

    @Test
    public void getAllClientTypesForAClient() throws Exception{
    }

    @Test
    public void getAll() {
    }

//    @Test
//    public void getAllClientTypesForAClient() {
//    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    public Client setupClient() {
        return new Client("Test Company", "555-555-5555", "james@test.com");
    }
}