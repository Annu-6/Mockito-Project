package com.example.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.data.api.TodoService;
import com.example.data.stub.TodoServiceStub;

public class TodoBusinessImlpStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Annu");
		assertEquals(2, filteredTodos.size());
	}

}
