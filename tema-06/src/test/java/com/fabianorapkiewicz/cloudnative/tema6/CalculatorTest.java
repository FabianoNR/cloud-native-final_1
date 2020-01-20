package com.fabianorapkiewicz.cloudnative.tema6;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fabianorapkiewicz.cloudnative.tema6.AppConfig;
import com.fabianorapkiewicz.cloudnative.tema6.Calculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class} )
public class CalculatorTest {

	@Autowired
	private Calculator calculator;
	
	@After
	public void tearDown() {
		calculator.clearHistory();
	}
	
	@Test
	public void testAddition() {
		Double result = calculator.calculate(1d, "sum", 1d);
		
		float deltaError = 0;
		assertEquals(2d, result, deltaError);
	}
	
	@Test
	public void testSubtraction() {
		 Double result = calculator.calculate(3.5d, "sub", 9.4d);
		
		double deltaError = 0.1d;
		assertEquals(-5.9d, result, deltaError);
	}
	
	@Test
	public void testMultiplication() {
		 Double result = calculator.calculate(3d, "mul", 3d);
		
		double deltaError = 0.0d;
		assertEquals(9d, result, deltaError);
	}
	
	@Test
	public void testDivision() {
		 Double result = calculator.calculate(10d, "div", 5d);
		
		double deltaError = 0.0d;
		assertEquals(2d, result, deltaError);
	}
	
	@Test
	public void testDivisionByNegativeNumber() {
		 Double result = calculator.calculate(10d, "div", -1d);
		
		double deltaError = 0.0d;
		assertEquals(-10d, result, deltaError);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivisionByZERO() {
		 calculator.calculate(10d, "div", 0d);
	}
	
	@Test
	public void testExponantation() {
		 Double result = calculator.calculate(5d, "exp", 3d);
		
		double deltaError = 0.0d;
		assertEquals(125d, result, deltaError);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidOperatorSymbol() {
		calculator.calculate(1d, "?", 1d);		
	}
	
	@Test
	public void testHistory() {
		Double sum = calculator.calculate(5d, "sum", 5d);
		
		Double sub = calculator.calculate(100d, "sub", 10d);
		
		Double mul = calculator.calculate(10d, "mul", 10d);
		
		Double div = calculator.calculate(9d, "div", 3d);
		
		Double exp = calculator.calculate(2d, "exp", 8d);
		
		 List<String> history = new ArrayList<String>();
		 history.add("5.0 sum 5.0 = " + sum);
		 history.add("100.0 sub 10.0 = " + sub);
		 history.add("10.0 mul 10.0 = " + mul);
		 history.add("9.0 div 3.0 = " + div);
		 history.add("2.0 exp 8.0 = " + exp);
		
		assertEquals(history, calculator.getHistory());
	}
}
