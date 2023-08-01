package com.swarga.project.productapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(generator = "prod-generator")
	@GenericGenerator(name ="prod-generator",parameters = @Parameter(name="prefix", value="product"), strategy = "com.swarga.project.productapp.util.CustomProductIDGenerator" )
	@Column(name = "product_id", nullable = false )
	private String productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_desc")
	private String productDesc;
	@Column(name = "product_price")
	private double productPrice;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [" + (productId != null ? "productId=" + productId + ", " : "")
				+ (productName != null ? "productName=" + productName + ", " : "")
				+ (productDesc != null ? "productDesc=" + productDesc + ", " : "") + "productPrice=" + productPrice
				+ "]";
	}


}
