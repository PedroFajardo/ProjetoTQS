/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Client.ClientController;
import com.cloudDomus.cloudDommus.Client.ClientRepository;
import com.cloudDomus.cloudDommus.Service.ServiceController;
import com.cloudDomus.cloudDommus.User.UserController;
import com.cloudDomus.cloudDommus.Worker.Worker;
import com.cloudDomus.cloudDommus.Worker.WorkerController;
import com.cloudDomus.cloudDommus.Worker.WorkerRepository;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author ana
 */
public class ReservationControllerTest {
    
    private final Long ID = Long.valueOf(5);
    private ReservationController reservationController;
    private ReservationRepository reservationRepositoryMock;
    private WorkerRepository workerRepositoryMock;
    private WorkerController wc;
    private ClientRepository clientRepositoryMock;
    private ClientController cc;
    
    public ReservationControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Before
    public void setUp() {
        reservationController = new ReservationController();
        wc = mock(WorkerController.class);
        cc = mock(ClientController.class);
        reservationController.setWorkerController(wc);
        reservationController.setClientController(cc);
        reservationRepositoryMock = mock(ReservationRepository.class);
        workerRepositoryMock = mock(WorkerRepository.class);
        clientRepositoryMock = mock(ClientRepository.class);
        reservationController.setRepository(reservationRepositoryMock);
        wc.setRepository(workerRepositoryMock);
        cc.setRepository(clientRepositoryMock);
    }

    @After
    public void tearDown() throws Exception {
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
    public void testNewReservation() throws JSONException, ParseException {
        ReservationDTO created = ReservationDTOTest.createDTO(ID);
        System.out.println(created);
        Reservation expected = ReservationDTOTest.createModelObjectReservation(ID);
        Worker w = new Worker();
        w.setId(ID);
        workerRepositoryMock.save(w);
        when(reservationRepositoryMock.save(any(Reservation.class))).thenReturn(expected);
        Reservation result = reservationController.newReservation(created.toString()+", user_id:"+w.getId()+", 'startHour': '15:00:00', 'endHour': '18:00:00' }");
        assertEquals(expected.getId(), result.getId());
    }

    /**
     * Test of getReservationByID method, of class ReservationController.
     */
    @Test
    public void testGetReservationByID() {
        Reservation expected = ReservationDTOTest.createModelObjectReservation(ID);
        when(reservationRepositoryMock.getById(ID)).thenReturn(expected);
        Reservation result = reservationController.getReservationByID(ID) ;
        assertEquals(expected, result);
    }

    /**
     * Test of deleteReservation method, of class ReservationController.
     */
    @Test
    public void testDeleteReservation() throws ReservationNotFoundException{
        Reservation expected = ReservationDTOTest.createModelObjectReservation(null);
        Reservation reservation = ReservationDTOTest.createModelObjectReservation(ID);
        when(reservationRepositoryMock.getById(ID)).thenReturn(reservation);
        Reservation result = reservationController.deleteReservation(ID);
        verify(reservationRepositoryMock, times(1)).getById(ID);
        verify(reservationRepositoryMock, times(1)).deleteById(ID);
        verifyNoMoreInteractions(reservationRepositoryMock);
        assertEquals(expected, result);
    }
    
    @Test(expected = ReservationNotFoundException.class)
    public void deleteWhenReservationIsNotFound() throws ReservationNotFoundException {
        when(reservationRepositoryMock.getById(ID)).thenReturn(null);
        reservationController.deleteReservation(ID);
        verify(reservationRepositoryMock, times(1)).getById(ID);
        verifyNoMoreInteractions(reservationRepositoryMock);
    }

    /**
     * Test of getReservationsByWorkerID method, of class ReservationController.
     */
    /*@Test
    public void testGetReservationsByWorkerID() {
        Reservation rs = ReservationDTOTest.createModelObjectReservation(ID);
        Worker w = new Worker();
        w.setId(ID);
        rs.setWorker(w);
        reservationRepositoryMock.save(rs);
        w.addReservation(rs);
        workerRepositoryMock.save(w);
        List<Reservation> expected = reservationRepositoryMock.getByWorker(w);
        List<Reservation> result = reservationController.getReservationsByWorkerID(w.getId());
        assertEquals(expected, result);
    }*/

    /**
     * Test of getReservationsByClientID method, of class ReservationController.
     */
    /*@Test
    public void testGetReservationsByClientID() {
        Client w = new Client();
        w.setId(ID);
        clientRepositoryMock.save(w);
        List<Reservation> expected = w.getReservationList();
        List<Reservation> result = reservationController.getReservationsByClientID(ID);
        assertEquals(expected, result);
    }*/
    
}
