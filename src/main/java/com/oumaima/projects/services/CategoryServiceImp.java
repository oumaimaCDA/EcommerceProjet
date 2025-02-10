package com.oumaima.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.oumaima.projects.entity.Category;
import com.oumaima.projects.entity.Product;
import com.oumaima.projects.repository.CategoryRepository;
import com.oumaima.projects.repository.ProductRepository;

@SpringBootApplication
@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAndFlush(category);
	}

	@Override
	public void deleteCategory(Long id) {
		 categoryRepository.deleteById(id);
		
	}


	@Override
	public Category getCategoryByIdCategory(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAndFlush(null);
	}

}
