package com.review.app.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.review.app.model.ProductModel;

@FeignClient(name = "PRODUCT-SERVICE", fallback = ProductFallback.class)
public interface ProductClient {

	@GetMapping("getProduct/{name}")
	ResponseEntity<ProductModel> getProductByName(@PathVariable(value = "name") String name);

}
