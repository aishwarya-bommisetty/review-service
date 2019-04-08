package com.review.app.services;

import java.util.List;

import com.review.app.model.ReviewModel;

public interface ReviewService {
	
	ReviewModel findReviewById(int id);

	void addReview(ReviewModel model);

	/**
	 * @return
	 */
	List<ReviewModel> findAll();
    /**
     * @param name
     * @return
     */
    List<ReviewModel> findProductReview(String name);
	/**
	 * @param id
	 */
	void deleteById(int id);
}
