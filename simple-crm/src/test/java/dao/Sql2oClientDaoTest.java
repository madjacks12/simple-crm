package dao;

import models.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oClientDaoTest {

    private Connection conn;
    private Sql2oClientDao clientDao;
    private Sql2oClientTypeDao clientTypeDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        clientDao = new Sql2oClientDao(sql2o);
        clientTypeDao = new Sql2oClientTypeDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingClientSetsId_1() throws Exception {
        Client testClient = setupClient();
        int originalClientId = testClient.getId();
        clientDao.add(testClient);
        assertEquals(1, testClient.getId());

    }

    @Test
    public void addClientToClientType() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getAllClientTypesForAClient() {
    }

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