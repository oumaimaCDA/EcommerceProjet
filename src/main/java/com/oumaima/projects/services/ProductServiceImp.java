package com.oumaima.projects.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.oumaima.projects.entity.Product;
import com.oumaima.projects.repository.ProductRepository;

@SpringBootApplication

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	

	
	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		
		return productRepository.findById(id).get();
	}
	
	@Override
	public Product updateProduct(Product product) {
		
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void deleteProduct(Long id) {
		
		 productRepository.deleteById(id);
	}

	@Override
	public Product getProductByIdProduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.saveAndFlush(null);
	}

	

}
