/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Service;

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
public class ServiceControllerTest {
    
    private static final Long ID = Long.valueOf(5);
    
    private ServiceController serviceController;
    private ServiceRepository serviceRepositoryMock;
    
    public ServiceControllerTest() {
    }
    
    @Before
    public void setUp() {
        serviceController = new ServiceController();
        serviceRepositoryMock = mock(ServiceRepository.class);
        serviceController.setRepository(serviceRepositoryMock);
    }
    

    /**
     * Test of all method, of class ServiceController.
     */
    @Test
    public void testAll() {
        List<Service> clients = new ArrayList<>();
        when(serviceRepositoryMock.findAll()).thenReturn(clients);
        List<Service> result = serviceController.all();
        verify(serviceRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(serviceRepositoryMock);
        assertEquals(clients, result);
    }

    /**
     * Test of newService method, of class ServiceController.
     */
    @Test
    public void testNewService() {
        ServiceDTO created = ServiceDTOTest.createDTO(ID, null, null);
        Service expected = ServiceDTOTest.createModelObjectService(ID, "aaa", "bbb");
        when(serviceRepositoryMock.save(any(Service.class))).thenReturn(expected);
        Service result = serviceController.newService(created);
        assertEquals(expected, result);
    }

    /**
     * Test of getServiceByID method, of class ServiceController.
     */
    @Test
    public void testGetServiceByID() {
        Service service = ServiceDTOTest.createModelObjectService(ID, null, null);
        when(serviceRepositoryMock.getById(ID)).thenReturn(service);
        Service result = serviceController.getServiceByID(ID) ;
        assertEquals(service, result);
    }

    /**
     * Test of deleteService method, of class ServiceController.
     */
    @Test
    public void testDeleteService() throws ServiceNotFoundException{
        Service expected = ServiceDTOTest.createModelObjectService(null, null, null); ;
        Service service = ServiceDTOTest.createModelObjectService(ID, null, null);
        when(serviceRepositoryMock.getById(ID)).thenReturn(service);
        Service result = serviceController.deleteService(ID);
        verify(serviceRepositoryMock, times(1)).getById(ID);
        verify(serviceRepositoryMock, times(1)).deleteById(ID);
        verifyNoMoreInteractions(serviceRepositoryMock);
        assertEquals(expected, result);
    }
    
    @Test(expected = ServiceNotFoundException.class)
    public void deleteWhenServiceIsNotFound() throws ServiceNotFoundException {
        when(serviceRepositoryMock.getById(ID)).thenReturn(null);
        serviceController.deleteService(ID);
        verify(serviceRepositoryMock, times(1)).getById(ID);
        verifyNoMoreInteractions(serviceRepositoryMock);
    }
    
}
