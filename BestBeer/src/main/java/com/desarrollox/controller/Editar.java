package com.desarrollox.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.desarrollox.controller.util.ServletUtil;
import com.desarrollox.dao.BeerDao;
import com.desarrollox.model.Beer;

/**
 * Servlet implementation class Editar
 */
@WebServlet("/editar")
@MultipartConfig
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletUtil servletUtil = ServletUtil.getInstance();
		servletUtil.validadeSession(req, resp);
		
		
		BeerDao dao = new BeerDao();

		String id = req.getParameter("id");

		Beer beer = dao.findById(Beer.class, Long.parseLong(id));

		req.setAttribute("beer", beer);
		req.getRequestDispatcher("editar.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BeerDao dao = new BeerDao();
		ServletUtil util = ServletUtil.getInstance();
		Beer beer;

		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String categoria = req.getParameter("categoria");
		String preco = req.getParameter("preco");
		String nacionalidade = req.getParameter("nacionalidade");

		beer = new Beer();

		beer.setId(Long.parseLong(id));
		beer.setName(nome);
		beer.setCategory(categoria);
		beer.setPrice(Double.parseDouble(preco));
		beer.setNationality(nacionalidade);

		Part arquivo = req.getPart("imagem");

		if (arquivo.getSize() != 0) {

			// estrai os bytes para salvar a foto no banco
			byte[] b = util.extractFileToDatabase(arquivo);
			// salva a foto tbm em uma pasta local
			String path = util.savePhotoInPath(req, nome, arquivo);

			beer.setImage(b);
			beer.setPath(path);

		}

		dao.saveOrUpdate(beer);

		resp.sendRedirect("dashboard");

	}

}
