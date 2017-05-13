package com.practice.service;

import java.util.List;

import com.practice.data.Weight;

public interface WeightService {
	public List<Weight> findAll();
	public void saveUserWeight(Weight user);
}
