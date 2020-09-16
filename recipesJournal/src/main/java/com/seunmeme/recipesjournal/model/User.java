package com.seunmeme.recipesjournal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId", referencedColumnName = "id")
//    List<Post> posts = new ArrayList<>();
}

