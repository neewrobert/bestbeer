package com.desarrollox.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desarrollox.dao.BeerDao;
import com.desarrollox.model.Beer;

/**
 * Servlet implementation class Excluir
 */
@WebServlet("/excluir")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id  = request.getParameter("id");
		
		BeerDao dao = new BeerDao();
	
		dao.removeById(Beer.class, Long.parseLong(id));
		
		
		response.sendRedirect("dashboard");
	}

}
