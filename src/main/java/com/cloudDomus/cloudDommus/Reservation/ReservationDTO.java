/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Reservation;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

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

    public ReservationDTO() {
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    
    
    
    
}
