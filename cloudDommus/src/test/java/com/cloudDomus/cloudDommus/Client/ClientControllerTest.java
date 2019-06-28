package com.cloudDomus.cloudDommus.Client;

import com.cloudDomus.cloudDommus.Reservation.Reservation;
import com.cloudDomus.cloudDommus.User.User;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


/**
 *
 * @author ana
 */
public class ClientControllerTest {
    
    private ClientController cc;
    private ClientRepository clientMock;
    
    public ClientControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.cc = new ClientController();
        this.clientMock = EasyMock.createMock(ClientRepository.class);
        this.cc.repository=this.clientMock;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of all method, of class ClientController.
     */
    @Test
    public void testAll() {
        List<Client> result = new ArrayList<>();
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        EasyMock.expect(this.cc.newClient(client1)).andReturn(client1);
        EasyMock.expect(this.cc.newClient(client2)).andReturn(client2);
        EasyMock.expect(this.cc.newClient(client1)).andReturn(client3);
        result.add(client1);
        result.add(client2);
        result.add(client3);
        System.out.println(result);
        EasyMock.expect(this.cc.all()).andReturn(result);
        EasyMock.replay(this.clientMock);
        
    }

    /**
     * Test of newClient method, of class ClientController.
     */
    @Test
    public void testNewClient() {
        Client newClient = new Client();
        newClient.setId(123456789L);
        long result = 123456789L;
        EasyMock.expect(this.clientMock.save(newClient)).andReturn(newClient);
        System.out.println(newClient);
        EasyMock.expect(this.clientMock.getOne(result)).andReturn(newClient);
        EasyMock.replay(this.clientMock);
    }

    /**
     * Test of getClientByID method, of class ClientController.
     */
    @Test
    public void testGetClientByID() {
        Long id = 123456789L;
        Client newClient = new Client();
        newClient.setId(id);
        EasyMock.expect(this.clientMock.findById(id).get()).andReturn(newClient);
        EasyMock.replay(this.clientMock);
        Long expResult = newClient.getId();
        System.out.println(expResult);
        
        Long result = this.cc.getClientByID(id).getId();
        System.out.println("oiiiiiiiiiii");
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
