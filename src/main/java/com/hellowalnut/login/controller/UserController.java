package com.hellowalnut.login.controller;

import java.util.List;

import com.hellowalnut.login.exception.ResourceNotFoundException;
import com.hellowalnut.login.exception.UserAlreadyMadeException;
import com.hellowalnut.login.model.User;
import com.hellowalnut.login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();	
	}

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		User user = userService.findUserById(id);

        return ResponseEntity.ok().body(user);
    }

	@PostMapping("/users")
	public User createUser(@Validated @RequestBody User user) throws UserAlreadyMadeException {
		return userService.save(user);
	}

	@PostMapping("/validate")
	public User validateUser(@Validated @RequestBody User user) throws ResourceNotFoundException {
		return userService.validateUser(user);
	}
}
