package com.cdac.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;//Integer
	@Column(length = 20,name="product_name") //col name , varchar size
	private String productName;
	@Column(length = 200,name="product_description") //col name , varchar size
	private String productDescription;
	private LocalDate manufactureDate;
	private Double price;
	private int available_quantity;
	
	public Product(){
		
	}

	public Product(Long productId, String productName, String productDescription, LocalDate manufactureDate,
			Double price, int available_quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.manufactureDate = manufactureDate;
		this.price = price;
		this.available_quantity = available_quantity;
	}
	
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", manufactureDate=" + manufactureDate + ", price=" + price
				+ ", available_quantity=" + available_quantity + "]";
	}
	
	
        
}
