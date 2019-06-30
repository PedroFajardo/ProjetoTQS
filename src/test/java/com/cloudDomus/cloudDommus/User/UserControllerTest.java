/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.User;


import com.cloudDomus.cloudDommus.Client.ClientRepository;
import com.cloudDomus.cloudDommus.Manager.ManagerRepository;
import com.cloudDomus.cloudDommus.Worker.WorkerRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author ana
 */
public class UserControllerTest {
    
    private final String EMAIL = "email";
    private final String PASSWORD = "PASSWORD";
    private static final Long USER_ID = Long.valueOf(5);
    private UserController userController;
    private UserRepository userRepositoryMock;
    private ClientRepository clientRepositoryMock;
    private ManagerRepository managerRepositoryMock;
    private WorkerRepository workerRepositoryMock;
    
    public UserControllerTest() {
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
    

    /**
     * Test of loginValidation method, of class UserController.
     */
    @Test
    public void testLoginValidation() throws Exception {
        UserDTO create = UserDTOTest.createDTO(USER_ID, null, null, null, EMAIL, null, PASSWORD, null, 0);
        User expected = UserDTOTest.createModelObjectUSer(USER_ID, null, null, EMAIL, null, PASSWORD, null, 0);
        when(userRepositoryMock.findByID(USER_ID)).thenReturn(expected);
    }
    
}
