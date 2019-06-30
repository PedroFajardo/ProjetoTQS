package com.cloudDomus.cloudDommus.Worker;

import com.cloudDomus.cloudDommus.Reservation.Reservation;
import com.cloudDomus.cloudDommus.User.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@ApiModel(description = "All details about a Worker.")
public class Worker extends User{

    @Column
    @ApiModelProperty(notes = "Worker Comments")
    private String[] comments;

    @Column
    @ApiModelProperty(notes = "Worker review scores")
    private int[] reviewScores;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @ApiModelProperty(notes = "Worker Reservation List")
    @JsonManagedReference
    private List<Reservation> reservations = new ArrayList<>();

    public Worker(String firstName, String lastName, String email, String username, String password, String address, int phone, String[] comments, int[] reviewScores, List<Reservation> reservations) {
        super(firstName, lastName, email, username, password, address, phone);
        this.comments = comments;
        this.reviewScores = reviewScores;
        this.reservations = reservations;
    }

    public Worker(){}


    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public int[] getReviewScores() {
        return reviewScores;
    }

    public void setReviewScores(int[] reviewScores) {
        this.reviewScores = reviewScores;
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "comments=" + Arrays.toString(comments) +
                ", reviewScores=" + Arrays.toString(reviewScores) +
                ", reservations=" + reservations.toString() +
                "} " + super.toString();
    }
}
