package com.review.app.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.review.app.entities.ReviewEntity;
import com.review.app.feignClient.ProductClient;
import com.review.app.model.ProductModel;
import com.review.app.model.ReviewModel;
import com.review.app.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
    
	@Autowired
	ProductClient productClient;
	
	DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public ReviewModel findReviewById(int id) {
		ReviewEntity entity = reviewRepository.findById(id);
		return mapper.map(entity, ReviewModel.class);
	}

	@Override
	public List<ReviewModel> findProductReview(String name) {		
		ResponseEntity<ProductModel> product= productClient.getProductByName(name);
		List<ReviewEntity> entities = reviewRepository.findAllByProductId(product.getBody().getId());
		List<ReviewModel> models = new ArrayList<>();
		for(ReviewEntity entity : entities) {
			models.add(mapper.map(entity, ReviewModel.class));
		}
		return models;
	}
	
	@Override
	public void addReview(ReviewModel model) {
		ReviewEntity entity= mapper.map(model,ReviewEntity.class);
		reviewRepository.save(entity);
		reviewRepository.flush();
	}

	@Override
	public List<ReviewModel> findAll() {
		List<ReviewEntity> entities = reviewRepository.findAll();
		List<ReviewModel> models = new ArrayList<>();
		for(ReviewEntity entity : entities) {
			models.add(mapper.map(entity, ReviewModel.class));
		}
		return models;
	}

	@Override
	public void deleteById(int id) {
		reviewRepository.deleteById(id);
		
	}
}
