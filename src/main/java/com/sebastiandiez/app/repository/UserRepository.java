package com.sebastiandiez.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebastiandiez.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
