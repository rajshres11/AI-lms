package com.org.ailms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.ailms.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    
} 
