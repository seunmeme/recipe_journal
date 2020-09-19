package com.seunmeme.recipesjournal.service.serviceImpl;

import com.seunmeme.recipesjournal.model.Recipe;
import com.seunmeme.recipesjournal.model.Review;
import com.seunmeme.recipesjournal.repository.ReviewRepository;
import com.seunmeme.recipesjournal.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

}
