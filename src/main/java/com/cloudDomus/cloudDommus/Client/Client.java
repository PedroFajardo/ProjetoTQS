package com.cloudDomus.cloudDommus.Client;

import com.cloudDomus.cloudDommus.Reservation.Reservation;
import com.cloudDomus.cloudDommus.User.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ApiModel(description = "All details about a Client.")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client extends User implements Serializable {

    @ApiModelProperty(notes = "The database generated Client ID")
    private @Id @GeneratedValue Long id;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @ApiModelProperty(notes = "Client Reservation List")
    private List<Reservation> reservationList = new ArrayList<>();

    public Client(String firstName, String lastName, String email, String username, String password, String address, int phone, List<Reservation> reservationList) {
        super(firstName, lastName, email, username, password, address, phone);
        this.reservationList = reservationList;
    }

    public Client(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", reservationList=" + reservationList +
                "} " + super.toString();
    }
}
