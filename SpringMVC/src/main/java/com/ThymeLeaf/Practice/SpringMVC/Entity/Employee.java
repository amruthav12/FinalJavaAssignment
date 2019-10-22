package com.ThymeLeaf.Practice.SpringMVC.Entity;

import javax.persistence.*;

@Entity //to create a table with the column names as the entities.
// @TABLE as creating the table. in the bracket provide the table name.
//syntax: @Table(name ="table_name")
@Table(name = "emp_table")
public class Employee {
    @Id // to give primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto increment the pk
    private long id;
    // for providing column name
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "emp_email")
    private String Email;
    //to access the details for that we will use getters and setters.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    //to string - if we are giving any object we will get the values.
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
