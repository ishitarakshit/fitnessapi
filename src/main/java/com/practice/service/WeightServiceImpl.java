package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.data.Weight;
import com.practice.repository.WeightRepository;

@Service
public class WeightServiceImpl implements WeightService {

	@Autowired
	private WeightRepository weightRepository;
	
	@Override
	public List<Weight> findAll() {
		return (List<Weight>) weightRepository.findAll();
	}

	@Override
	public void saveUserWeight(Weight user) {
		weightRepository.save(user);
	}

}
