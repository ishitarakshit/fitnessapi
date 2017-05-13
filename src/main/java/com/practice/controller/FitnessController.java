package com.practice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.data.Weight;
import com.practice.service.WeightService;

@RestController
@RequestMapping("/api")
public class FitnessController {
	
	@Autowired
	private WeightService weightService;

	@RequestMapping(value = "/weight", method = RequestMethod.POST)
	public Weight addWeightData(@RequestBody Weight inputData) {
		Weight user = new Weight();
		user.setUserName(inputData.getUserName());
		user.setAmount(inputData.getAmount());
		user.setUnit(inputData.getUnit());
		user.setDateTime(new Date());
		weightService.saveUserWeight(user);
		return user;
	}
	
	@RequestMapping("/weights")
	public List<Weight> getAllUserWeightData() {
		return weightService.findAll();
	}
}
