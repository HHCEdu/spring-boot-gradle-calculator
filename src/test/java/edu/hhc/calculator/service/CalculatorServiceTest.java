package edu.hhc.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

	private CalculatorService calculatorService = new CalculatorService();

	@Test
	void shouldSumTwoNumbers() {
		assertEquals(10, calculatorService.sum(8, 2));
	}
}
