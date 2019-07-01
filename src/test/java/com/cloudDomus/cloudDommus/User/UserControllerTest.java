/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.User;


import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Client.ClientRepository;
import com.cloudDomus.cloudDommus.Manager.Manager;
import com.cloudDomus.cloudDommus.Manager.ManagerRepository;
import com.cloudDomus.cloudDommus.Worker.Worker;
import com.cloudDomus.cloudDommus.Worker.WorkerRepository;
import java.util.*;
import org.junit.After;
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
public class UserControllerTest {
    
    private static final Long USER_ID = Long.valueOf(5);
    
    private UserController userController;
    private UserRepository userRepositoryMock;
    private ClientRepository clientRepositoryMock;
    private ManagerRepository managerRepositoryMock;
    private WorkerRepository workerRepositoryMock;
    
    public UserControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
   
    @Before
    public void setUp() {
        userController = new UserController();
        userRepositoryMock = mock(UserRepository.class);
        clientRepositoryMock = mock(ClientRepository.class);
        managerRepositoryMock = mock(ManagerRepository.class);
        workerRepositoryMock = mock(WorkerRepository.class);
        userController.setRepository(userRepositoryMock);
        userController.setClientRepository(clientRepositoryMock);
        userController.setManagerRepository(managerRepositoryMock);
        userController.setWorkerRepository(workerRepositoryMock);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of loginValidation method, of class UserController.
     */
    /*@Test
    public void testLoginValidation() throws Exception {
        String params ="";
        String expected="";
        String result = "";
        Worker worker = UserDTOTest.createModelObjectWorker(USER_ID, "worker", "email@worker.pt", "ola");
        System.out.println(worker.getEmail());
        workerRepositoryMock.save(worker);
        System.out.println(workerRepositoryMock.findByEmail(worker.getEmail()));
        params = "{ 'email':'email@worker.pt', 'password': 'ola', 'userType': 'worker', 'user_id': "+USER_ID+"}";
        expected = "{'userType':'worker', 'user_id': "+USER_ID+"}";
        result=userController.loginValidation(params);
        assertEquals(expected,result);
    }*/
    
}
