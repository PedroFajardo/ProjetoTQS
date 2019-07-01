/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Service.Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ana
 */
public class ReservationDTO extends Reservation {
    @NotEmpty
    private Long id;
    
    private Date startHour;
    
    private Date endHour;
    
    private String address;
    
    private String description;
    
    private List<Service> service;
    
    private Double priceHour;

    public ReservationDTO() throws ParseException {
        this.address="testAddress";
        this.priceHour=Double.valueOf(2.5);
        this.description="testDescription";
        this.service = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }
    
    

    @Override
    public String toString() {
        String params = "{ 'service': "+this.service + ", 'description':'"+this.description+"', 'priceHour': "+this.priceHour+", id:"+this.id;
        return params;
    }
    
    
    
    
    
}
