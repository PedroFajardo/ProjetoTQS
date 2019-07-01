/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.User;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Manager.Manager;
import com.cloudDomus.cloudDommus.Worker.Worker;


/**
 *
 * @author ana
 */
public class UserDTOTest {
    
    
    public static UserDTO createDTO(Long id, String type, String email, String password) {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setType(type);
        return dto;
    }
    
    public static User createModelObjectUser(Long id, String type, String email, String password) {
        User model = new User();
        model.setId(id);
        model.setEmail(email);
        model.setPassword(password);
        return model;
    }
    
    public static Client createModelObjectClient(Long id, String type, String email, String password) {
        Client model = new Client();
        model.setId(id);
        model.setEmail(email);
        model.setPassword(password);
        return model;
    }
    
    public static Worker createModelObjectWorker(Long id, String type, String email, String password) {
        Worker model = new Worker();
        model.setId(id);
        model.setEmail(email);
        model.setPassword(password);
        return model;
    }
    
    public static Manager createModelObjectManager(Long id, String type, String email, String password) {
        Manager model = new Manager();
        model.setId(id);
        model.setEmail(email);
        model.setPassword(password);
        return model;
    }
}
