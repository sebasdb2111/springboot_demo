package com.sebastiandiez.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sebastiandiez.app.entity.User;

public interface UserService {

	public Iterable<User> list();
	
	public Page<User> listPageable(Pageable pageable);
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public User update(Long userId, User userDetails);
	
	public void deleteById(Long id);
	
	public void logicalDeleteById(Long id);
}
