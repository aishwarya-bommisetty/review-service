package com.review.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.app.entities.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{
	public ReviewEntity findById(int id);
}
