package com.oumaima.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oumaima.projects.entity.User;


public interface UserRepository extends JpaRepository<User, Long>
{

}
