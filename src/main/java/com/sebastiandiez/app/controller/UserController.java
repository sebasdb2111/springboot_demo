package com.sebastiandiez.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebastiandiez.app.entity.User;
import com.sebastiandiez.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody User user)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id)
	{
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<?> list()
	{
		Iterable<User> userList = userService.list();
		return ResponseEntity.ok(userList);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long userId)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.update(userId, userDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> logicalDelete(@PathVariable Long id)
	{
		userService.logicalDeleteById(id);
		return ResponseEntity.ok().build();
	}

}
