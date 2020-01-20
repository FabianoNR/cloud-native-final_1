package com.fabianorapkiewicz.cloudnative.tema6.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fabianorapkiewicz.cloudnative.tema6.AppConfig;
import com.fabianorapkiewicz.cloudnative.tema6.math.Addition;
import com.fabianorapkiewicz.cloudnative.tema6.math.Division;
import com.fabianorapkiewicz.cloudnative.tema6.math.Exponantiation;
import com.fabianorapkiewicz.cloudnative.tema6.math.Multiplication;
import com.fabianorapkiewicz.cloudnative.tema6.math.Subtraction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class MathOperationTest {

	@Autowired
	private Addition addition;
	
	@Autowired
	private Subtraction subtraction;
	
	@Autowired
	private Multiplication multiplication;
	
	@Autowired
	private Division division;
	
	@Autowired
	private Exponantiation exponantiation;
	
	@Test(expected = NullPointerException.class)
	public void testAdditionWithNullValue() {		
		addition.compute(null, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSubtrationWithNullValue() {
		subtraction.compute(null, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testMultiplicationWithNullValue() {
		multiplication.compute(null, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDivisionWithNullValue() {
		division.compute(null, null);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivisionByZERO() {
		division.compute(10d, 0d);
	}
	
	@Test
	public void testDivisionByNegativeNumber() {
		double deltaError = 0d;
		assertEquals(-10d, division.compute(10d, -1d), deltaError);
	}
	
	@Test(expected = NullPointerException.class)
	public void testExponantiationWithNullValue() {
		exponantiation.compute(null, null);
	}
	
	@Test
	public void testExponantiationRaisedToZERO() {
		double deltaError = 0d;
		assertEquals(1d, exponantiation.compute(2d, 0d), deltaError);
	}
}
