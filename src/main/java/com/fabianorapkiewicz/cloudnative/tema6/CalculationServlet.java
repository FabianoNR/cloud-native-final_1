package com.fabianorapkiewicz.cloudnative.tema6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculationServlet", urlPatterns = { "/", "/calculadora" }, loadOnStartup = 1)
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Calculator calculator;
	
	public CalculationServlet() {
		calculator = BeanServletProvider.INSTANCE.getCalculator();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		if( request.getParameterNames().hasMoreElements() ) {
			String n1 = request.getParameter("n1");
			String n2 = request.getParameter("n2");
			String op = request.getParameter("op");

			Double resultValue = calculator.calculate(Double.valueOf(n1), op, Double.valueOf(n2));
			writer.println("Resultado da sua operação");
			writer.println( n1 + " " + op + " " + n2 + " = " + resultValue);
		}else {
			writer.println("Bem vindo a calculadora ninja \n");
			writer.println("Os seguintes parâmetros são suportados: n1, n2 e op");
			writer.println("Onde,");
			writer.println("\t n1 é  primeiro número da operação;");
			writer.println("\t n2 é segundo número da operação;");
			writer.println("\t op é o nome da operação. \n");
			writer.println("*As operações suportadas são: sum, sub, mul, div, exp");
			writer.println("Exemplo de uma multiplicação entre 3 e 9: ");
			writer.print("http://localhost:8089/tema-06/calculadora?n1=3&n2=9&op=mul");
		}
		

	}
}