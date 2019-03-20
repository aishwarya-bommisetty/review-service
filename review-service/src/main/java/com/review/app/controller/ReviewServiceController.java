package com.review.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.app.model.ReviewModel;
import com.review.app.services.ReviewServiceImpl;

@RestController
@RequestMapping("/Review")
public class ReviewServiceController {
	@Autowired
	private ReviewServiceImpl reviewService;
	
	@GetMapping("getAll")
	ResponseEntity<List<ReviewModel>> getAll() {
		return ResponseEntity.ok().body(reviewService.findAll());
	}
	@GetMapping("get/{id}")
	ResponseEntity<ReviewModel> getProductById(@PathVariable int id) {
		return ResponseEntity.ok().body(reviewService.findReviewById(id));
	}
	
	@PostMapping("add")
	void addProduct(@RequestBody ReviewModel model) {
		reviewService.addReview(model);
	}
	
	@PutMapping("{id}/{name}/updateName")
	void modifyProduct( @PathVariable("id") int id, @PathVariable("name") String name) {
		reviewService.updateName(id, name);
	}
	
	@DeleteMapping("delete/{id}")
	void deleteProductById(@PathVariable("id") int id) {
		reviewService.deleteById(id);
	}
}
