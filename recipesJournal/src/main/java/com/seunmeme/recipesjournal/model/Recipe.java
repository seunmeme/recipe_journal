package com.seunmeme.recipesjournal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private String imageUrl = "/images/products/fun-to-eat-spaghetti-salad.jpg";

    @CreationTimestamp
    @Column(name="dateCreated", nullable=false, updatable=false)
    private Timestamp dateCreated;

    @UpdateTimestamp
    @Column(name="updatedAt", nullable=false)
    private Timestamp updatedAt;

    @ManyToOne(cascade = CascadeType.MERGE, fetch= FetchType.EAGER)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipeId", referencedColumnName = "id")
    List<Review> reviews = new ArrayList<Review>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipeId", referencedColumnName = "id")
    List<UpVote> upVotes = new ArrayList<UpVote>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipeId", referencedColumnName = "id")
    List<DownVote> downVotes = new ArrayList<DownVote>();

}
