/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Reservation;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author ana
 */
public class ReservationControllerTest {
    
    private final Long ID = Long.valueOf(5);
    private ReservationController reservationController;
    private ReservationRepository reservationRepositoryMock;
    
    public ReservationControllerTest() {
    }
    @Before
    public void setUp() {
        reservationController = new ReservationController();
        reservationRepositoryMock = mock(ReservationRepository.class);
        reservationController.setRepository(reservationRepositoryMock);
    }

    /**
     * Test of all method, of class ReservationController.
     */
    @Test
    public void testAll() {
        List<Reservation> reservations = new ArrayList<>();
        when(reservationRepositoryMock.findAll()).thenReturn(reservations);
        List<Reservation> result = reservationController.all();
        verify(reservationRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(reservationRepositoryMock);
        assertEquals(reservations, result);
    }

    /**
     * Test of newReservation method, of class ReservationController.
     */
    @Test
    public void testNewReservation() {
        ReservationDTO created = ReservationDTOTest.createDTO(ID, null, null, null);
        Reservation expected = ReservationDTOTest.createModelObjectReservation(ID, null, null, null);
        when(reservationRepositoryMock.save(any(Reservation.class))).thenReturn(expected);
        Reservation result = reservationController.newReservation(created);
        assertEquals(expected, result);
    }

    /**
     * Test of getReservationByID method, of class ReservationController.
     */
    @Test
    public void testGetReservationByID() {
        Reservation expected = ReservationDTOTest.createModelObjectReservation(ID, null, null, null);
        when(reservationRepositoryMock.findByID(ID)).thenReturn(expected);
        Reservation result = reservationController.getReservationByID(ID) ;
        assertEquals(expected, result);
    }

    /**
     * Test of deleteReservation method, of class ReservationController.
     */
    @Test
    public void testDeleteReservation() throws ReservationNotFoundException{
        Reservation expected = ReservationDTOTest.createModelObjectReservation(null, null, null, null);
        Reservation reservation = ReservationDTOTest.createModelObjectReservation(ID, null, null, null);
        when(reservationRepositoryMock.findByID(ID)).thenReturn(reservation);
        Reservation result = reservationController.deleteReservation(ID);
        verify(reservationRepositoryMock, times(2)).findByID(ID);
        verify(reservationRepositoryMock, times(1)).deleteById(ID);
        verifyNoMoreInteractions(reservationRepositoryMock);
        assertEquals(expected, result);
    }
    
    @Test(expected = ReservationNotFoundException.class)
    public void deleteWhenReservationIsNotFound() throws ReservationNotFoundException {
        when(reservationRepositoryMock.findByID(ID)).thenReturn(null);
        reservationController.deleteReservation(ID);
        verify(reservationRepositoryMock, times(1)).findByID(ID);
        verifyNoMoreInteractions(reservationRepositoryMock);
    }
    
}
