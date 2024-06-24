package com.example.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.data.api.TodoService;

public class TodoBusinessImlpMockitoTest {
	// What is mocking?
	// mocking is creating objects that simulate the behavior of real objects.
	// Unlike stubs, mocks can be dynamically created from code - at runtime.
	// Mocks offer more functionality than stubbing.
	// You can verify method calls and a lot of other things.
	// You can mock a class or interface using mock() method of Mockito class
	//when(): methodCall method to be stubbed
	//thenReturn(): return stubbed value when method is called
	//ie, when(mock.someMethod()).thenReturn(1,2,3);

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		/*
		 * TodoService mockTodoService = mock(TodoService.class);
		 * stub(mockTodoService.retrieveTodos("Parameter")).return("value");
		 */

		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Annu")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Annu");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMockWithEmptyList() {
		/*
		 * TodoService mockTodoService = mock(TodoService.class);
		 * stub(mockTodoService.retrieveTodos("Parameter")).return("value");
		 */

		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Annu")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Annu");
		assertEquals(0, filteredTodos.size());
	}

}
