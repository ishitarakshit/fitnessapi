package com.practice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;

import com.practice.controller.FitnessController;
import com.practice.data.Goal;
import com.practice.data.Unit;
import com.practice.data.User;
import com.practice.data.Weight;
import com.practice.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest
@WithMockUser
public class FitnessapiApplicationTests {

	private static final long ID = 100;

	private static final String NAME = "Teeps";
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private static final double WEIGHT_156 = 156.00;
	
	private static final String DATE_15052017 = "15-05-2017";
	
	private static final double WEIGHT_160_50 = 160.50;
	
	private static final String DATE_21032017 = "21-03-2017";
	
	private static final double WEIGHT_150 = 150.00;
	
	private static final String DATE_01082017 = "01-08-2017";

	private static final Unit LB = Unit.LB;
	
	@Autowired
	FitnessController fitnessController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;

	@Test
	public void testGetUserById() throws Exception {
		User testUser = new User();
		testUser.setId(ID);
		testUser.setName(NAME);
		Weight currentWeight = new Weight();
		currentWeight.setAmount(WEIGHT_156);
		currentWeight.setDateTime(sdf.parse(DATE_15052017));
		currentWeight.setUnit(LB);
		testUser.setCurrentWeight(currentWeight);
		//set Goals
		Weight startWeight = new Weight();
		startWeight.setAmount(WEIGHT_160_50);
		startWeight.setDateTime(sdf.parse(DATE_21032017));
		startWeight.setUnit(LB);
		Weight targetWeight = new Weight();
		targetWeight.setAmount(WEIGHT_150);
		targetWeight.setDateTime(sdf.parse(DATE_01082017));
		targetWeight.setUnit(LB);
		Goal goal = new Goal();
		goal.setStartWeight(startWeight);
		goal.setTargetWeight(targetWeight);
		Set<Goal> goals = new HashSet<>();
		goals.add(goal);
		testUser.setGoals(goals);
		
		when(userService.findOne(ID)).thenReturn(testUser);
		
		this.mockMvc.perform((get("/api/users/"+ID)))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.name").value(NAME))
				.andExpect(jsonPath("$.goals", hasSize(1)))
				.andExpect(jsonPath("$.currentWeight.amount").value(WEIGHT_156))
				.andExpect(jsonPath("$.currentWeight.dateTime").value(DATE_15052017))
				.andExpect(jsonPath("$.currentWeight.unit").value(LB.toString()));
				
	}

}
