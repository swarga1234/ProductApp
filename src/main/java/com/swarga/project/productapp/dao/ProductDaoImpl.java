package com.swarga.project.productapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.swarga.project.productapp.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addProduct(Product product) {
		// Add Product
		this.hibernateTemplate.save(product);
	}

	public List<Product> getAllProducts() {
		List<Product> productList= this.hibernateTemplate.loadAll(Product.class);
		return productList;
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void deleteProduct(String productId) {
		Product product = this.hibernateTemplate.load(Product.class, productId);	
		this.hibernateTemplate.delete(product);
	}

}
