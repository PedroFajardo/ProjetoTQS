package com.cloudDomus.cloudDommus.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ApiModel(description = "All details about a User.")
public class User {

    @ApiModelProperty(notes = "The database generated User ID")
    private @Id @GeneratedValue Long id;

    @Column
    @ApiModelProperty(notes = "User First Name")
    private String firstName;

    @Column
    @ApiModelProperty(notes = "User Last Name")
    private String lastName;

    @Column
    @ApiModelProperty(notes = "User Email")
    private String email;

    @Column
    @ApiModelProperty(notes = "User Username")
    private String username;

    @Column
    @ApiModelProperty(notes = "User Password")
    private String password;

    @Column
    @ApiModelProperty(notes = "User Address")
    private String address;

    @Column
    @ApiModelProperty(notes = "User Phone")
    private int phone;

    public User(String firstName, String lastName, String email, String username, String password, String address, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
