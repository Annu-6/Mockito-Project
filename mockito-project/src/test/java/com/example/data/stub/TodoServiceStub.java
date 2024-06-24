package com.example.data.stub;

import java.util.Arrays;
import java.util.List;

import com.example.data.api.TodoService;

public class TodoServiceStub implements TodoService{
	// Dynamic Condition - stub is constant
	// Service Definition

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC","Learn Spring",
				"Learn to Dance");
	}

}
