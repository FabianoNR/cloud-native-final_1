package com.fabianorapkiewicz.cloudnative.tema6;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fabianorapkiewicz.cloudnative.tema6.math.Addition;
import com.fabianorapkiewicz.cloudnative.tema6.math.Division;
import com.fabianorapkiewicz.cloudnative.tema6.math.Exponantiation;
import com.fabianorapkiewicz.cloudnative.tema6.math.MathOperation;
import com.fabianorapkiewicz.cloudnative.tema6.math.Multiplication;
import com.fabianorapkiewicz.cloudnative.tema6.math.Subtraction;

@Configuration
@ComponentScan(basePackages = "com.fabianorapkiewicz.cloudnative.tema4")
public class AppConfig{
	
	@Bean
	public Calculator calculator() {
		HashMap<String, MathOperation> supportedOperations = new HashMap<String, MathOperation>();
		supportedOperations.put("sum", addition());
		supportedOperations.put("sub", subtraction());
		supportedOperations.put("mul", multiplication());
		supportedOperations.put("div", division());
		supportedOperations.put("exp", exponantiation());
		
		return new Calculator(supportedOperations);
	}
	
	@Bean
	public MathOperation addition() {
		return new Addition();
	}
	
	@Bean
	public MathOperation subtraction() {
		return new Subtraction();
	}
	
	@Bean
	public MathOperation multiplication() {
		return new Multiplication();
	}
	
	@Bean
	public MathOperation division() {
		return new Division();
	}
	
	@Bean
	public MathOperation exponantiation() {
		return new Exponantiation();
	}
}
