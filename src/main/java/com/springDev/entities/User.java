package com.springDev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;




import jakarta.persistence.Column;



@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="USER_NAME",length=50,nullable = false,unique = true)
    private String userName;
    @Column(name="FIRST_NAME",length=50,nullable = false)
    private String firstName;
    @Column(name="LAST_NAME",length=50,nullable = false)
    private String lastName;
    @Column(name="EMAIL",length=50,nullable = false)
    private String email;

    @Column(name="ROLE",length=50,nullable = false)
    private String role;

    @Column(name="SSN",length=50,nullable = false,unique = true)
    private String ssn;

    //NO arg constructor
    public User() {
    }
    //field constructor
    public User(Long id, String userName, String firstName, String lastName, String email,String role, String ssn) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role=role;
        this.ssn = ssn;
    }
    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
