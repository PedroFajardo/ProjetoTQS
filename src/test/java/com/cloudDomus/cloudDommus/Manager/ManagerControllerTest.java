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
    public void testDeleteManager() throws ManagerNotFoundException{
        Manager expected = ManagerDTOTest.createModelObjectManager(null, null, null); ;
        Manager manager = ManagerDTOTest.createModelObjectManager(USER_ID, null, null);
        when(managerRepositoryMock.deleteByID(USER_ID)).thenReturn(manager);
        Manager result = managerController.deleteManager(USER_ID);
        verify(managerRepositoryMock, times(1)).deleteByID(USER_ID);
        verify(managerRepositoryMock, times(1)).deleteById(USER_ID);
        verifyNoMoreInteractions(managerRepositoryMock);
        assertEquals(expected, result);
    }
    
    @Test(expected = ManagerNotFoundException.class)
    public void deleteWhenManagerIsNotFound() throws ManagerNotFoundException {
        when(managerRepositoryMock.deleteByID(USER_ID)).thenReturn(null);
        managerController.deleteManager(USER_ID);
        verify(managerRepositoryMock, times(1)).deleteByID(USER_ID);
        verifyNoMoreInteractions(managerRepositoryMock);
    }
    
}
