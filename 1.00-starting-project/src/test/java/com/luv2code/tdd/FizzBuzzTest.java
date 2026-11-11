package com.luv2code.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
	
	//If number is divisible by 3 , print Fizz
	//If number is divisible by 5 , print Buzz
	//If number is divisible by 3 and 5 , print FizzBuzz
	//If number not divisible by 3 or 5, then print the number
	
	
	@Test
	@DisplayName("Divisible by Three")
	@Order(1)
	void testForDivisibleByThree() {
		
//		fail("fail"); //just doing an initial fail
		
		String expected = "Fizz";
		
		assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
	}

	//If number is divisible by 5 , print Buzz
	
	@Test
	@DisplayName("Divisible by Five")
	@Order(2)
	void testForDivisibleByFive() {
		
		String expected = "Buzz";
		assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
	}
	
	//If number is divisible by 3 and 5 , print FizzBuzz
	@Test
	@DisplayName("Divisible by Three and Five")
	@Order(3)
	void testForDivisibleByThreeAndFive() {
		String expected = "FizzBuzz";
		assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
	}
	
	//If number not divisible by 3 or 5, then print the number
	@Test
	@DisplayName("Not Divisible")
	@Order(4)
	void testNotDivisible() {
		
		assertEquals("2", FizzBuzz.compute(2), "Should return the 2");
	}
	
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources = "/small-test-data.csv")
	@DisplayName("Testing with small data file")
	@Order(5)
	void testForSmallDataFile(int value, String expected) {
		
		assertEquals(expected, FizzBuzz.compute(value));
	}
	
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources = "/medium-test-data.csv")
	@DisplayName("Testing with medium data file")
	@Order(6)
	void testForMediumDataFile(int value, String expected) {
		assertEquals(expected, FizzBuzz.compute(value));
	}
	
	
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources = "/large-test-data.csv")
	@DisplayName("Testing with large data file")
	@Order(7)
	void testForLargeDataFile(int value, String expected) {
		assertEquals(expected, FizzBuzz.compute(value));
	}
	
	
}
