package com.swarga.project.productapp.dao;

import java.util.List;

import com.swarga.project.productapp.model.Product;

public interface ProductDao {

	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public void updateProduct(Product product);
	public void deleteProduct(String productId);
}
