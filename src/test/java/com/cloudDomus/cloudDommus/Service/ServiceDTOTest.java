/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Service;

/**
 *
 * @author ana
 */
public class ServiceDTOTest {
    
    public ServiceDTOTest() {
    }
    public static ServiceDTO createDTO(Long id, String type, String description) {
        ServiceDTO dto = new ServiceDTO();

        dto.setId(id);
        dto.setType(type);
        dto.setDescription(description);
        return dto;
    }

    public static Service createModelObjectService(Long id, String firstName, String lastName) {
        Service model = new Service();
        model.setId(id);
        return model;
    }
    
}
