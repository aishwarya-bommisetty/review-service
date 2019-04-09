package com.review.app.feignClient;

import org.springframework.http.ResponseEntity;

import com.review.app.model.ProductModel;

public class ProductFallback implements ProductClient{

	@Override
	public ResponseEntity<ProductModel> getProductByName(String name) {
		return ResponseEntity.ok().body(new ProductModel(0,"fallback product", "this is a safe fallback point"));
	}

}
