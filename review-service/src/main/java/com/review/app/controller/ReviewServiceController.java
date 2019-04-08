package com.review.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.app.model.ReviewModel;
import com.review.app.services.ReviewService;

@RestController
@RequestMapping("/Review")
public class ReviewServiceController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("getAll")
	ResponseEntity<List<ReviewModel>> getAll() {
		return ResponseEntity.ok().body(reviewService.findAll());
	}
	
	@GetMapping("get/{id}")
	ResponseEntity<ReviewModel> getReviewById(@PathVariable int id) {
		return ResponseEntity.ok().body(reviewService.findReviewById(id));
	}
	
	@GetMapping("getProductReview/{productName}")
	ResponseEntity<List<ReviewModel>> getProductReview(@PathVariable String productName) {
		return ResponseEntity.ok().body(reviewService.findProductReview(productName));
	}
	
	@PostMapping("add")
	void addReview(@RequestBody ReviewModel model) {
		reviewService.addReview(model);
	}
	
	@DeleteMapping("delete/{id}")
	void deleteReviewById(@PathVariable("id") int id) {
		reviewService.deleteById(id);
	}
}
