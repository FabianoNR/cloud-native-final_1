package com.fabianorapkiewicz.cloudnative.tema6;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Optional;

import com.fabianorapkiewicz.cloudnative.tema6.math.MathOperation;

public class Calculator {

	private Map<String,MathOperation> supportedOperations;
	
	private List<String> operationsHistory;
	
	public Calculator(Map<String,MathOperation> supportedOperations) {
		this.supportedOperations = supportedOperations;
		operationsHistory = new ArrayList<String>();
	}
	
	public Double calculate(Double firstValue, String operation, Double secondValue) {
		
		 Optional<MathOperation> operationFinded = Optional.ofNullable(supportedOperations.get(operation));
		
		if( operationFinded.isPresent()) {
			double result = operationFinded.get().compute(firstValue, secondValue);
			addLog(firstValue, operation, secondValue, result);
			return result;
		} else {
			addLog("Operação '" + operation + "' não suportada");
			throw new IllegalArgumentException("Operador não suportado");
		}
	}
	
	private void addLog(Double firstValue, String operation, Double secondValue, Double result) {
		String log = firstValue.toString() + " " + operation + " " + secondValue.toString() + " = " + result;
		operationsHistory.add(log);
	}
	
	private void addLog(String message) {
		operationsHistory.add(message);
	}

	public List<String> getHistory() {
		return operationsHistory;
	}
	
	public void clearHistory() {
		operationsHistory.clear();
	}
	
}
