package com.oumaima.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.oumaima.projects.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
