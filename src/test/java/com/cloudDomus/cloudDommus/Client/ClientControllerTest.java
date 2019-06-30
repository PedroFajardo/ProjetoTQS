/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Client;

import com.cloudDomus.cloudDommus.User.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;



/**
 *
 * @author ana
 */
public class ClientControllerTest {
    
    private static final Long USER_ID = Long.valueOf(5);
    
    private ClientController clientController;
    private ClientRepository clientRepositoryMock;
    
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
        clientController = new ClientController();
        clientRepositoryMock = mock(ClientRepository.class);
        clientController.setRepository(clientRepositoryMock);
    }

    /**
     * Test of all method, of class ClientController.
     */
    @Test
    public void testAll() {
        List<Client> clients = new ArrayList<>();
        when(clientRepositoryMock.findAll()).thenReturn(clients);
        List<Client> result = clientController.all();
        verify(clientRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(clientRepositoryMock);
        assertEquals(clients, result);
    }

    /**
     * Test of newClient method, of class ClientController.
     */
    @Test
    public void testNewClient() {
        ClientDTO created = ClientDTOTest.createDTO(USER_ID, null, null);
        Client expected = ClientDTOTest.createModelObjectClient(USER_ID, "aaa", "bbb");
        when(clientRepositoryMock.save(any(Client.class))).thenReturn(expected);
        Client result = clientController.newClient(created);
        
        verify(clientRepositoryMock, times(1)).save(created);
        verifyNoMoreInteractions(clientRepositoryMock);
        assertEquals(expected, result);
    }

    /**
     * Test of deleteClient method, of class ClientController.
     */
    @Test
    public void testDeleteClient() {
        Client client = ClientDTOTest.createModelObjectClient(USER_ID, "aaa", "bbb");
        when(clientRepositoryMock.deleteByID(USER_ID)).thenReturn(client);
        if(client!=null){  
            clientRepositoryMock.delete(client);
            verify(clientRepositoryMock, times(1)).delete(client);
            client = clientController.getClientByID(USER_ID);
        }
        assertEquals(null, client);
    }

    /**
     * Test of getClientByID method, of class ClientController.
     */
    @Test
    public void testGetClientByID() {
        Client client = ClientDTOTest.createModelObjectClient(USER_ID, null, null);
        when(clientRepositoryMock.findByID(USER_ID)).thenReturn(client);
        Client result = clientController.getClientByID(USER_ID);
        assertEquals(client, result);
    }
    
    @Test(expected = ClientNotFoundException.class)
    public void updateWhenClientIsNotFound() throws ClientNotFoundException {
        ClientDTO updated = ClientDTOTest.createDTO(USER_ID, null, null);
        when(clientRepositoryMock.findByID(updated.getId())).thenReturn(null);
        clientController.deleteClient(USER_ID);
    } 
}
