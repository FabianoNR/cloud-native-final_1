package com.fabianorapkiewicz.cloudnative.tema6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HistorynServlet", urlPatterns = { "/historico" }, loadOnStartup = 1)
public class HistoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Calculator calculator;

	public HistoryServlet() {
		calculator = BeanServletProvider.INSTANCE.getCalculator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		writer.println("Histórico");
		calculator.getHistory().forEach(item -> writer.println(item));
	}
}
