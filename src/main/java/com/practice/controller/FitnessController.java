package com.practice.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.data.Goal;
import com.practice.data.User;
import com.practice.service.UserService;

@RestController
@RequestMapping("/api")
public class FitnessController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/users")
	public User addUser(@RequestBody User inputUser) {
		return userService.saveUser(inputUser);
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if(user != null) {
			return user;
		}
		return null;
	}
	
	@PostMapping(value = "/users/{id}/goals")
	public User addGoal(@PathVariable Long id, @RequestBody Goal newGoal) {
		User user = userService.findOne(id);
		if(user != null) {
			Set<Goal> currentGoals = user.getGoals() == null ? new HashSet<>() : user.getGoals();
			currentGoals.add(newGoal);
			return userService.saveUser(user);
		}
		return null;
	}
	
	@GetMapping("/users/{id}/goals")
	public Set<Goal> getUserGoals(@PathVariable Long id) {
		User user = userService.findOne(id);
		if(user != null) {
			return user.getGoals();
		}
		return null;
	}
	
}
