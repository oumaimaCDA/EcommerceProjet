package com.oumaima.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oumaima.projects.entity.Category;


public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
