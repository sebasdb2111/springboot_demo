package com.sebastiandiez.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sebastiandiez.app.entity.User;
import com.sebastiandiez.app.entity.UserNotFounfException;
import com.sebastiandiez.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> list() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> listPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public Optional<User> findById(Long id) {
		return Optional.of(userRepository.findById(id).orElseThrow(() -> new UserNotFounfException()));
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(Long userId, User userDetails) {
		Optional<User> user = this.findById(userId);
		
		if (!user.isPresent()) {
			throw new UserNotFounfException();
		}
		
		user.get().setName(userDetails.getName());
		user.get().setSurname(userDetails.getSurname());
		user.get().setEmail(userDetails.getEmail());
		user.get().setPassword(userDetails.getPassword());
		
		this.save(user.get());
		
		return user.get();
	}
	
	@Override
	public void deleteById(Long id) {
		Optional<User> user = this.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFounfException();
		}
		
		userRepository.deleteById(id);
	}
	
	@Override
	public void logicalDeleteById(Long id) {
		Optional<User> user = this.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFounfException();
		}
		
		user.get().setEnabled(false);
		this.save(user.get());
	}

}
