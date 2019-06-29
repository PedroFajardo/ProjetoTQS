package com.cloudDomus.cloudDommus.Worker;

import com.cloudDomus.cloudDommus.Service.Service;
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
@ApiModel(description = "All details about a Worker.")
public class Worker extends User{

    @Column
    @ApiModelProperty(notes = "Worker Comments")
    private String[] comments;

    @Column
    @ApiModelProperty(notes = "Worker review scores")
    private int[] reviewScores;

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "Worker Service List")
    private List<Service> services = new ArrayList<>();

    public Worker(String firstName, String lastName, String email, String username, String password, String address, int phone, String[] comments, int[] reviewScores, List<Service> services) {
        super(firstName, lastName, email, username, password, address, phone);
        this.comments = comments;
        this.reviewScores = reviewScores;
        this.services = services;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "comments=" + Arrays.toString(comments) +
                ", reviewScores=" + Arrays.toString(reviewScores) +
                ", services=" + services +
                "} " + super.toString();
    }
}
