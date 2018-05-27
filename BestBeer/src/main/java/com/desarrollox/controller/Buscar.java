package com.desarrollox.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desarrollox.dao.BeerDao;
import com.desarrollox.model.Beer;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String busca = req.getParameter("busca");

		BeerDao dao = new BeerDao();

//		List<Beer> beers = dao.serachByNameCategoryAndNationality(busca);

//		req.setAttribute("beers", beers);

		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

	}

}
