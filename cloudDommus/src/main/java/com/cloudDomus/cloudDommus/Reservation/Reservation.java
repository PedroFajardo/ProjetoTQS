package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Client.Client;
import com.cloudDomus.cloudDommus.Service.Service;
import com.cloudDomus.cloudDommus.User.User;
import com.cloudDomus.cloudDommus.Worker.Worker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ApiModel(description = "All details about a Reservation.")
public class Reservation {

    @ApiModelProperty(notes = "The database generated Reservation ID")
    private @Id @GeneratedValue Long id;

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "Reservation Service")
    private List<Service> service = new ArrayList<>();

    @Column
    @ApiModelProperty(notes = "Reservation Start Hour")
    private Date startHour;

    @Column
    @ApiModelProperty(notes = "Reservation End Hour")
    private Date endHour;

    @Column
    @ApiModelProperty(notes = "Reservation Adress")
    private String address;

    public Reservation( Date startHour, Date endHour, String address) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.address = address;
    }

    public Reservation() {}

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
        return "Reservation{" +
                "id=" + id +
                ", service=" + service +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", address='" + address + '\'' +
                '}';
    }
}