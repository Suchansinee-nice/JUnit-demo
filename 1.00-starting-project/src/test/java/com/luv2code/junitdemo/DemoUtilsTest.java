package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {
	
	DemoUtils demoUtils = null;
	
	@BeforeEach
	void setUpBeforeEach() {
		demoUtils = new DemoUtils();
	}
	
	@Test
	@DisplayName("Equal and Not Equal")
	@Order(1)
	void testEqualAndNotEqual() {
				
		assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
		assertNotEquals(6, demoUtils.add(1, 9), "1+9 must no be 6");
	}
	
	@Test
	@DisplayName("Null and Not Null")
	@Order(0)
	void testNullAndNotNull() {
				
		String str1 = null;
		String str2 = "luv2code";
		
		assertNull(demoUtils.checkNull(str1), "Object should be null");
		assertNotNull(demoUtils.checkNull(str2), "Object should be not null");
	}
	
	@Test
	@DisplayName("Same and Not Same")
	void sameAndNotSame() {
		
		String str1 = "luv2code";
		
		assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "object should refer to the same object");
		assertNotSame(str1, demoUtils.getAcademyDuplicate(), "object should be not same");
	}
	
	@Test
	@DisplayName("True and Not True")
	@Order(30)
	void trueAndNotTrue() {
		
		int x = 10;
		int y = 5;
		
		assertTrue(demoUtils.isGreater(x, y), "This should return true");
		assertFalse(demoUtils.isGreater(y, x), "This should return false");
	}
	
	@Test
	@DisplayName("Array Equal")
	void testArrayEqual() {
		
		String[] array = {"A","B","C"};
		assertArrayEquals(array, demoUtils.getFirstThreeLettersOfAlphabet(),"Array should be same");
	}
	
	@Test
	@DisplayName("Iterable Equal")
	void testIterableEqual() {
		
		List<String> list = List.of("luv","2","code");
		
		assertIterableEquals(list, demoUtils.getAcademyInList(), "Iterable should be same");
	}
	
	@Test
	@DisplayName("Line Match")
	@Order(50)
	void testLineMatch() {
		
		List<String> list = List.of("luv","2","code");
		assertLinesMatch(list, demoUtils.getAcademyInList(),"line should match");
	}
	
	@Test
	@DisplayName("throw and not throw exception")
	void testThrowandNotThrow() {
		
		assertThrows(Exception.class, () -> {demoUtils.throwException(-1);}, "shoud throw exception");
		assertDoesNotThrow(() -> {demoUtils.throwException(9);}, "shoud not throw exception");
	}
	
	@Test
	@DisplayName("timeout exception")
	void testTimeout() {
		
		assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout();} , "Method should execute in 3 sec." );
	}
	
	
	@Test
	@DisplayName("multiply")
	void testMultiply() {
		
		assertEquals(12, demoUtils.multiply(4, 3),"4*3 must be 12");
	}
	
	/*
	@AfterEach
	void tearDownAfterEach() {
		System.out.println("Running @AfterEach.");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Running @BeforeAll execute only once before all test.");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Running @AfterAll execute only once after all test.");
	}
	*/
}
