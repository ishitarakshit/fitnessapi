package com.practice.service;

import com.practice.data.User;

public interface UserService {

	public User findOne(Long id);
	public User saveUser(User user);
}
