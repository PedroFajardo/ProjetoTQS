/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.User;


/**
 *
 * @author ana
 */
public class UserDTOTest {
    
    
    public static UserDTO createDTO(Long id, String type, String firstName, String lastName, String email, String username, String password, String address, int phone) {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setAddress(address);
        dto.setPhone(phone);
        dto.setUsername(username);
        dto.setType(type);
        return dto;
    }
    
    public static User createModelObjectUSer(Long id, String firstName, String lastName, String email, String username, String password, String address, int phone) {
        User model = new User();
        model.setId(id);
        return model;
    }
}
