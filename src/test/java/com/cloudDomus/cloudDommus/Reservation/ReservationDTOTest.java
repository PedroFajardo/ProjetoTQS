/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Reservation;

import java.util.Date;

/**
 *
 * @author ana
 */
public class ReservationDTOTest {
    
    public ReservationDTOTest() {
    }
    
    public static ReservationDTO createDTO(Long id, Date startHour, Date endHour, String address) {
        ReservationDTO dto = new ReservationDTO();

        dto.setId(id);
        dto.setStartHour(startHour);
        dto.setEndHour(endHour);
        dto.setAddress(address);
        return dto;
    }

    public static Reservation createModelObjectReservation(Long id, Date startHour, Date endHour, String address) {
        Reservation model = new Reservation();
        model.setId(id);
        return model;
    }
    
}
