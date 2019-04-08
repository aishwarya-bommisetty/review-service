package com.review.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.review.app.entities.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	public ReviewEntity findById(int id);
	public List<ReviewEntity> findAllByProductId(int id);
}
