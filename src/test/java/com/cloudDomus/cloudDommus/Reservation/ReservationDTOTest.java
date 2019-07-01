/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Service.Service;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ana
 */
public class ReservationDTOTest {
    
    public ReservationDTOTest() {
    }
    
    public static ReservationDTO createDTO(Long id) throws ParseException {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(id);
        return dto;
    }

    public static Reservation createModelObjectReservation(Long id) {
        Reservation model = new Reservation();
        model.setId(id);
        return model;
    }
    
}
