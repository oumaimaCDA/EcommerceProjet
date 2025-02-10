package com.oumaima.projects.services;

import java.util.List;

import com.oumaima.projects.entity.Category;



public interface CategoryService {
	Category createCategory(Category category);
	 
	 List<Category> getAllCategory();
	 
	 Category updateCategory(Category category);
	 
	 void deleteCategory(Long id);

	 Category getCategoryByIdCategory(Long id);

	 Category getCategoryById(Long id);


}
