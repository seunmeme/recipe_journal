package com.seunmeme.recipesjournal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    private String password;
    private String dob;
    private String gender;

    @CreationTimestamp
    @Column(name="dateCreated", nullable=false, updatable=false)
    private Timestamp dateCreated;

}

