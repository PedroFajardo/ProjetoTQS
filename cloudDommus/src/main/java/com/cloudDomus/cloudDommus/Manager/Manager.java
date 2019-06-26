package com.cloudDomus.cloudDommus.Manager;

import com.cloudDomus.cloudDommus.Reservation.Reservation;
import com.cloudDomus.cloudDommus.User.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@ApiModel(description = "All details about a Client.")
public class Manager {

    @ApiModelProperty(notes = "The database generated Client ID")
    private @Id @GeneratedValue Long id;

    @ApiModelProperty(notes = "Client Inherited User")
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    @ApiModelProperty(notes = "Client Comments")
    private String[] comments;

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "Client Reservation List")
    private List<Reservation> reservationList = new ArrayList<>();

    public Manager(User user, String[] comments, List<Reservation> reservationList) {
        this.user = user;
        this.comments = comments;
        this.reservationList = reservationList;
    }

    public Manager(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", user=" + user +
                ", comments=" + Arrays.toString(comments) +
                ", reservationList=" + reservationList.toString() +
                '}';
    }
}