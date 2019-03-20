package com.review.app.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.app.entities.ReviewEntity;
import com.review.app.model.ReviewModel;
import com.review.app.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	ReviewRepository ReviewRepository;

	DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public ReviewModel findReviewById(int id) {
		ReviewEntity entity = ReviewRepository.findById(id);
		return mapper.map(entity, ReviewModel.class);
	}

	@Override
	public void addReview(ReviewModel model) {

		ReviewEntity entity= mapper.map(model,ReviewEntity.class);
		ReviewRepository.save(entity);
		ReviewRepository.flush();

	}

	@Override
	public void updateName(int id, String name) {
		ReviewEntity entity = ReviewRepository.findById(id);
		entity.setName(name);
		ReviewRepository.save(entity);
	}


	@Override
	public List<ReviewModel> findAll() {
		List<ReviewEntity> entities = ReviewRepository.findAll();
		List<ReviewModel> models = new ArrayList<>();
		for(ReviewEntity entity : entities) {
			models.add(mapper.map(entity, ReviewModel.class));
		}
		return models;
	}

	@Override
	public void deleteById(int id) {
		ReviewRepository.deleteById(id);
		
	}
}
