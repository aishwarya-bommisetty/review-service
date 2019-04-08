package com.review.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class ReviewEntity {

	@Id
	@Column(name = "review_id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "review_desc")
	private String description;

	@Column(name = "product_id")
	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
