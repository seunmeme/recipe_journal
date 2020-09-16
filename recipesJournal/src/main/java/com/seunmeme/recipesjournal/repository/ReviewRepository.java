package com.seunmeme.recipesjournal.repository;

import com.seunmeme.recipesjournal.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
