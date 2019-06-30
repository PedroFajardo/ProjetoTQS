/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.User;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Manager.Manager;

/**
 *
 * @author ana
 */
public class UserDTOTest {
    
    public UserDTOTest() {
    }
    
    public static UserDTO createDTO(Long id, String firstName, String lastName) {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        return dto;
    }

    public static Client createModelObjectClient(Long id, String firstName, String lastName) {
        Client model = new Client();

        model.setId(id);

        return model;
    }
    
    public static Manager createModelObjectManager(Long id, String firstName, String lastName) {
        Manager model = new Manager();

        model.setId(id);

        return model;
    }
}
