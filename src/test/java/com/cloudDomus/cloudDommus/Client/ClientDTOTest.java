/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Client;


/**
 *
 * @author ana
 */
public class ClientDTOTest{
    
   public static ClientDTO createDTO(Long id, String firstName, String lastName) {
        ClientDTO dto = new ClientDTO();

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
    
    
}
