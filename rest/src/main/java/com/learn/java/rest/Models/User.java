package com.learn.java.rest.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "JavaUsers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String occupation;
}
