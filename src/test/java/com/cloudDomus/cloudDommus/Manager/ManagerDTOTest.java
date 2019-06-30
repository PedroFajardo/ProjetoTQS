/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Manager;


/**
 *
 * @author ana
 */
public class ManagerDTOTest {
    
    public static ManagerDTO createDTO(Long id, String firstName, String lastName) {
        ManagerDTO dto = new ManagerDTO();

        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        return dto;
    }

    public static Manager createModelObjectManager(Long id, String firstName, String lastName) {
        Manager model = new Manager();

        model.setId(id);

        return model;
    }
    
    
}
