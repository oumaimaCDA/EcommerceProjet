package com.oumaima.projects.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.oumaima.projects.entity.Product;
import com.oumaima.projects.services.ProductServiceImp;
@Controller
@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductServiceImp productServiceImp;
	
	@PostMapping("/save")
	public Product saveproduct(@RequestBody Product p) {
		
		return productServiceImp.createProduct(p);
	}
	
	@GetMapping("/all")
	public List<Product> getallproduct(){
		return productServiceImp.getAllProduct();
	}
	
	@GetMapping("/getone/{id}")
	public Product getoneproduct(@PathVariable Long id) {
	
		return productServiceImp.getProductById(id);
	}
	
	@GetMapping("affichagebyid/{id}")
	public Product affichagebyid(@PathVariable Long id) {
		Product a=this.productServiceImp.getProductById(id);
		return a;
	}
	
	
	  @PutMapping("/update/{id}") 
	  public Product updateproduct(@PathVariable Long id, @RequestBody Product product) { 
		  Product p1=productServiceImp.getProductById(id);
	 
	 if(p1 !=null) { 
	 product.setId(id);
	  return productServiceImp.updateProduct(product); 
	  } 
	 else
	  {
		 throw new RuntimeException("FAIL");
	  }
	  
	  }
	 

	@DeleteMapping("/delete/{id}")
	public HashMap<String , String> deleteproduct(@PathVariable Long id){
		HashMap<String, String> message= new HashMap<>();
		if (productServiceImp.getProductById(id)== null) {
			message.put("etat", "product not found");
			return message;
		}
		try {
			productServiceImp.deleteProduct(id);
			message.put("etat", "product deleted");
			return message;
		} 
		catch (Exception e) {
			message.put("etat", "product not deleted");
			return message;
		}
	
}
}











