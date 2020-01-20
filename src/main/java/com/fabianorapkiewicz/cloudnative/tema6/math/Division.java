package com.fabianorapkiewicz.cloudnative.tema6.math;

import javax.validation.constraints.NotNull;

public class Division implements MathOperation {

	@Override
	public double compute(@NotNull Double firstValue, @NotNull Double secondValue) {
		if( secondValue.compareTo(0d) == 0 )
			throw new ArithmeticException("Divisão por ZERO");
		else
			return firstValue / secondValue;
	}
}
