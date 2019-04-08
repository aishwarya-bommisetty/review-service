package com.review.app.model;

import java.io.Serializable;

public class ReviewModel implements Serializable {
	private static final long serialVersionUID = -8845984014971040613L;
	private int id;
	private String description;
	private int productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
