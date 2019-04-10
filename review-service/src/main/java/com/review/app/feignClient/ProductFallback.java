package com.review.app.feignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.review.app.model.ProductModel;

@Component
public class ProductFallback implements ProductClient{

	@Override
	public ResponseEntity<ProductModel> getProductByName(String name) {
		return ResponseEntity.badRequest().body(new ProductModel(0,"fallback product", "this is a safe fallback point"));
	}

}
