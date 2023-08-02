package com.swarga.project.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swarga.project.productapp.dao.ProductDao;
import com.swarga.project.productapp.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void addProduct(Product product)
	{
		this.productDao.addProduct(product);
	}

	public List<Product> getAllProducts()
	{
		return this.productDao.getAllProducts();
	}

	public void deleteProduct(String productId)
	{
		this.productDao.deleteProduct(productId);
	}
	public Product getProduct(String productId)
	{
		return this.productDao.getProductById(productId);
	}

}
