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
public class Worker {

    @ApiModelProperty(notes = "The database generated Worker ID")
    private @Id @GeneratedValue Long id;

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

    @ApiModelProperty(notes = "Worker Inherited User")
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Worker(String[] comments, int[] reviewScores, List<Service> services, User user) {
        this.comments = comments;
        this.reviewScores = reviewScores;
        this.services = services;
        this.user = user;
    }

    public Worker(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", comments=" + Arrays.toString(comments) +
                ", reviewScores=" + Arrays.toString(reviewScores) +
                ", services=" + services.toString() +
                ", user=" + user +
                '}';
    }
}
