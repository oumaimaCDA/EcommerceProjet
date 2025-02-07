package com.oumaima.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oumaima.projects.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
