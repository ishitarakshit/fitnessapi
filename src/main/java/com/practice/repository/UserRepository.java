package com.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.data.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
