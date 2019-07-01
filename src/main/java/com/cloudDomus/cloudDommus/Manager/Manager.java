package com.cloudDomus.cloudDommus.Manager;

import com.cloudDomus.cloudDommus.User.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ApiModel(description = "All details about a Manager.")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager extends User implements Serializable {

    public Manager() {}


    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }
}