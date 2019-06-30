/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Manager;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author ana
 */
public class ManagerControllerTest {
    
    private static final Long USER_ID = Long.valueOf(5);
    
    private ManagerController managerController;
    private ManagerRepository managerRepositoryMock;
    
    public ManagerControllerTest() {
    }

    @Before
    public void setUp() {
        managerController = new ManagerController();
        managerRepositoryMock = mock(ManagerRepository.class);
        managerController.setRepository(managerRepositoryMock);
    }
   

    /**
     * Test of all method, of class ManagerController.
     */
    @Test
    public void testAll() {
        List<Manager> clients = new ArrayList<>();
        when(managerRepositoryMock.findAll()).thenReturn(clients);
        List<Manager> result = managerController.all();
        verify(managerRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(managerRepositoryMock);
        assertEquals(clients, result);
    }

    /**
     * Test of newManager method, of class ManagerController.
     */
    @Test
    public void testNewManager() {
        ManagerDTO created = ManagerDTOTest.createDTO(USER_ID, null, null);
        Manager expected = ManagerDTOTest.createModelObjectManager(USER_ID, "aaa", "bbb");
        when(managerRepositoryMock.save(any(Manager.class))).thenReturn(expected);
        Manager result = managerController.newManager(created);
        assertEquals(expected, result);
    }

    /**
     * Test of getManagerByID method, of class ManagerController.
     */
    @Test
    public void testGetManagerByID() {
        Manager mn = ManagerDTOTest.createModelObjectManager(USER_ID, null, null);
        when(managerRepositoryMock.findByID(USER_ID)).thenReturn(mn);
        Manager result = managerController.getManagerByID(USER_ID) ;
        assertEquals(mn, result);
    }

    /**
     * Test of deleteManager method, of class ManagerController.
     */
    @Test
    public void testDeleteManager() {
        Manager expected = null;
        Manager manager = ManagerDTOTest.createModelObjectManager(USER_ID, "aaa", "bbb");
        when(managerRepositoryMock.deleteByID(USER_ID)).thenReturn(manager);
        if(manager!=null){  
            managerRepositoryMock.delete(manager);
            verify(managerRepositoryMock, times(1)).delete(manager);
            manager = managerController.getManagerByID(USER_ID);
        }
        assertEquals(expected, manager);
    }
    
    @Test(expected = ManagerNotFoundException.class)
    public void updateWhenManagerIsNotFound() throws ManagerNotFoundException {
        ManagerDTO updated = ManagerDTOTest.createDTO(USER_ID, null, null);
        when(managerRepositoryMock.findByID(updated.getId())).thenReturn(null);
        managerController.deleteManager(USER_ID);
    } 
    
}
