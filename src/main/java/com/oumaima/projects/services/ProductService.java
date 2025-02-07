package com.oumaima.projects.services;

import java.util.List;

import com.oumaima.projects.entity.Product;

public interface ProductService {
	
	
 Product createProduct(Product product);
 
 List<Product> getAllProduct();
 
 Product updateProduct(Product product);
 
 void deleteProduct(Long id);

Product getProductByIdProduct(Long id);

Product getProductById(Long id);

}
