package com.cloudDomus.cloudDommus.Service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@ApiModel(description = "All details about a Service.")
public class Service {

    @ApiModelProperty(notes = "The database generated Service ID")
    private @Id @GeneratedValue Long id;

    @Column
    @ApiModelProperty(notes = "Service Type")
    private String type;

    @Column
    @ApiModelProperty(notes = "Service Description")
    private String description;

    public Service(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public Service(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
