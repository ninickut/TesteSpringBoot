package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	public UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public User findByID(@PathVariable Long id) {

		User result = repository.findById(id).get();
		return result;

	}

	@PostMapping
	public User insert(@RequestBody User user) {

		User result = repository.save(user);
		return result;
	}

}