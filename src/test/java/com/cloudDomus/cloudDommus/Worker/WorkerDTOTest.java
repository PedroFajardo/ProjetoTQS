/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Worker;


/**
 *
 * @author ana
 */
public class WorkerDTOTest {
    
    public WorkerDTOTest() {
    }
    public static WorkerDTO createDTO(Long id) {
        WorkerDTO dto = new WorkerDTO();

        dto.setId(id);
        return dto;
    }

    public static Worker createModelObjectWorker(Long id) {
        Worker model = new Worker();

        model.setId(id);

        return model;
    }
    
    
}
