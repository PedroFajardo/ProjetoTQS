package com.cloudDomus.cloudDommus.Reservation;

import com.cloudDomus.cloudDommus.Service.Service;
import com.cloudDomus.cloudDommus.Worker.Worker;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToMany
    @ApiModelProperty(notes = "Reservation Service")
    private List<Service> service = new ArrayList<>();

    @Column
    @ApiModelProperty(notes = "Reservation Description")
    private String description;

    @Column
    @ApiModelProperty(notes = "Reservation Start Hour")
    private Date startHour;

    @Column
    @ApiModelProperty(notes = "Reservation End Hour")
    private Date endHour;

    @Column
    @ApiModelProperty(notes = "Reservation Price per Hour")
    private Double priceHour;

    @Column
    @ApiModelProperty(notes = "Reservation Client Address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn
    @JsonBackReference
    private Worker worker;

    public Reservation(List<Service> service, String description, Date startHour, Date endHour, Double priceHour, String address) {
        this.service = service;
        this.description = description;
        this.startHour = startHour;
        this.endHour = endHour;
        this.priceHour = priceHour;
        this.address = address;
    }
    public Reservation(String description, Date startHour, Date endHour, Double priceHour) {
        this.description = description;
        this.startHour = startHour;
        this.endHour = endHour;
        this.priceHour = priceHour;
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

    public void addService(Service service){
        this.service.add(service);
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public Double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(Double priceHour) {
        this.priceHour = priceHour;
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


    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String   toString() {
        return "Reservation{" +
                "id=" + id +
                ", service=" + service +
                ", description='" + description + '\'' +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", priceHour=" + priceHour +
                ", address='" + address + '\'' +
                '}';
    }
}