package com.cloudDomus.cloudDommus.Manager;

import com.cloudDomus.cloudDommus.User.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@ApiModel(description = "All details about a Manager.")
public class Manager extends User {

    public Manager() {}


    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }
}