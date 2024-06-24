package com.example.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		//add type arguments to 'List' -> List<?>
		List<?> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		//assertEquals(expected, actual)
		assertEquals(2,listMock.size());
		assertEquals(2,listMock.size());
		assertEquals(2,listMock.size());
	}

	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List<?> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		//assertEquals(expected, actual)
		assertEquals(2,listMock.size()); //first call
		assertEquals(3,listMock.size()); //second call
	}
	
	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
//		when(listMock.get(0)).thenReturn("Annu");
		
		//when u don't tell Mockito mocks what to do, they return defaults
//		assertEquals("Annu", listMock.get(0));
//		assertEquals(null, listMock.get(1));
		
		//Argument Matchers: anyInt() method of Mockito class will return given same string for all integers passed to get() method
		when(listMock.get(anyInt())).thenReturn("Annu");
		
		assertEquals("Annu", listMock.get(0)); //first call
		assertEquals("Annu", listMock.get(1)); //second call
	}
	
	@Test(expected = RuntimeException.class)
	public void letsMockList_throwAnException() {
		List listMock = mock(List.class);
		//Argument Matchers
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		listMock.get(0);
	}
}
