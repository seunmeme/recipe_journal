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
@Entity(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;


    @CreationTimestamp
    @Column(name="dateCreated", nullable=false, updatable=false)
    private Timestamp dateCreated;

    @ManyToOne(cascade = CascadeType.MERGE, fetch= FetchType.EAGER)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;



}
