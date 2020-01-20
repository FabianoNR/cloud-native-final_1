package com.fabianorapkiewicz.cloudnative.tema6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public enum BeanServletProvider {
	INSTANCE;
	
	private AnnotationConfigApplicationContext factory;
	
	BeanServletProvider() {
		factory = new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
	public Calculator getCalculator() {
		return factory.getBean("calculator", Calculator.class);
	}
}
