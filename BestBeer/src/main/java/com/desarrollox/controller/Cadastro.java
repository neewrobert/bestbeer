package com.desarrollox.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.desarrollox.controller.util.ServletUtil;
import com.desarrollox.dao.BeerDao;
import com.desarrollox.model.Beer;
import com.desarrollox.model.Categoria;

@WebServlet("/cadastro")
@MultipartConfig
public class Cadastro extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104831457555878437L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			
			Categoria[] categoriasArray = Categoria.values();
			
			List<Categoria> categorias = Arrays.asList(categoriasArray);
			
			req.setAttribute("categorias", categorias);
			req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		Categoria[] categoriasArray = Categoria.values();
		
		List<Categoria> categorias = Arrays.asList(categoriasArray);

		BeerDao dao = new BeerDao();
		ServletUtil util = ServletUtil.getInstance();
		Beer beer;

		String nome = req.getParameter("nome");
		String categoria = req.getParameter("categoria");
		String preco = req.getParameter("preco");
		String nacionalidade = req.getParameter("nacionalidade");

		beer = new Beer();

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

		resp.sendRedirect("cadastro");

	}


}
