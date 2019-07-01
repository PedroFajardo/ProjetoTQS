/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Worker;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author ana
 */
public class WorkerControllerTest {
    
    private static final Long USER_ID = Long.valueOf(5);
    
    private WorkerController workerController;
    private WorkerRepository workerRepositoryMock;
    
    public WorkerControllerTest() {
    }
    
    @Before
    public void setUp() {
        workerController = new WorkerController();
        workerRepositoryMock = mock(WorkerRepository.class);
        workerController.setRepository(workerRepositoryMock);
    }
    

    /**
     * Test of all method, of class WorkerController.
     */
    @Test
    public void testAll() {
        List<Worker> clients = new ArrayList<>();
        when(workerRepositoryMock.findAll()).thenReturn(clients);
        List<Worker> result = workerController.all();
        verify(workerRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(workerRepositoryMock);
        assertEquals(clients, result);
    }

    /**
     * Test of newWorker method, of class WorkerController.
     */
    @Test
    public void testNewWorker() {
        WorkerDTO created = WorkerDTOTest.createDTO(USER_ID);
        Worker expected = WorkerDTOTest.createModelObjectWorker(USER_ID);
        when(workerRepositoryMock.save(any(Worker.class))).thenReturn(expected);
        Worker result = workerController.newWorker(created);
        assertEquals(expected, result);
    }

    /**
     * Test of getWorkerByID method, of class WorkerController.
     */
    @Test
    public void testGetWorkerByID() {
        Worker mn = WorkerDTOTest.createModelObjectWorker(USER_ID);
        when(workerRepositoryMock.getById(USER_ID)).thenReturn(mn);
        Worker result = workerController.getWorkerByID(USER_ID) ;
        assertEquals(mn, result);
    }

    /**
     * Test of deleteWorker method, of class WorkerController.
     */
    @Test
    public void testDeleteWorker() {
        Worker expected = WorkerDTOTest.createModelObjectWorker(null); 
        Worker manager = WorkerDTOTest.createModelObjectWorker(USER_ID);
        when(workerRepositoryMock.getById(USER_ID)).thenReturn(manager);
        Worker result = workerController.deleteWorker(USER_ID);
        verify(workerRepositoryMock, times(1)).getById(USER_ID);
        verify(workerRepositoryMock, times(1)).deleteById(USER_ID);
        verifyNoMoreInteractions(workerRepositoryMock);
        assertEquals(expected, result);
    }

    @Test(expected = WorkerNotFoundException.class)
    public void deleteWhenManagerIsNotFound() throws WorkerNotFoundException {
        when(workerRepositoryMock.getById(USER_ID)).thenReturn(null);
        workerController.deleteWorker(USER_ID);
        verify(workerRepositoryMock, times(1)).getById(USER_ID);
        verifyNoMoreInteractions(workerRepositoryMock);
    }
    
}
