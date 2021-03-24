package edu.hhc.calculator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.hhc.calculator.service.CalculatorService;

@RestController
public class CalculatorResource {

	@Autowired
	CalculatorService calculatorService;

	@RequestMapping("/sum")
	public String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		return String.valueOf(calculatorService.sum(a, b));
	}
}
