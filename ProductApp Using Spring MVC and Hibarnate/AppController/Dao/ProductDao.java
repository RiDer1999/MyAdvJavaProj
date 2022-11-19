package com.AppController.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.AppController.Model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Create.....
	@Transactional
	public void createProduct(Product product) {

		this.hibernateTemplate.saveOrUpdate(product);
	}

	// Get all Product....
	public List<Product> getProducts() {

		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}

	// Delete the single Products...
	@Transactional
	public void deleteProduct(int pid) {

		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);

	}

	// Get The single Product.....
	public Product getProduct(int pid) {

		return this.hibernateTemplate.get(Product.class, pid);
	}

}