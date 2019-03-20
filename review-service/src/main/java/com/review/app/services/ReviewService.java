package com.review.app.services;

import java.util.List;

import com.review.app.model.ReviewModel;

public interface ReviewService {
	
	ReviewModel findReviewById(int id);

	void addReview(ReviewModel model);

	/**
	 * @param id
	 * @param name
	 */
	void updateName(int id, String name);

	/**
	 * @return
	 */
	List<ReviewModel> findAll();

	/**
	 * @param id
	 */
	void deleteById(int id);
}
