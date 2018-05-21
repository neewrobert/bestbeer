package com.desarrollox.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.desarrollox.dao.BeerDao;
import com.desarrollox.model.Beer;

@WebServlet("/cadastro")
@MultipartConfig
public class Cadastro extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104831457555878437L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String categoria = req.getParameter("categoria");
		String preco = req.getParameter("preco");
		String nacionalidade = req.getParameter("nacionalidade");
		String foto;

		Beer beer = new Beer();

		beer.setName(nome);
		beer.setCategory(categoria);
		beer.setPrice(Double.parseDouble(preco));
		beer.setNationality(nacionalidade);

		Part arquivo = req.getPart("imagem");

		if (arquivo.getSize() != 0) {
			
			// estrai os bytes para salvar a foto no banco
			byte[] b = extractFileToDatabase(arquivo);
			//salva a foto tbm em uma pasta local
			String path = savePhotoInPath(req, nome, arquivo);

			beer.setImage(b);
			beer.setPath(path);
			
		} else {
			beer.setPath("garrafa.jpg");
		}
		
		BeerDao dao = new BeerDao();
		
		dao.saveOrUpdate(beer);
		
		resp.sendRedirect("cadastro.jsp");

	}

	private String savePhotoInPath(HttpServletRequest req, String nome, Part arquivo) throws IOException {
		String nomeArq = arquivo.getSubmittedFileName();
		String ext = nomeArq.split("\\.")[1];
		String path = req.getServletContext().getRealPath("foto");
		
		nomeArq = nome.replace(" ", "") + System.currentTimeMillis() + "." + ext;
		
		arquivo.write(path + "/" + nomeArq);
		
		return nomeArq;
	}

	private byte[] extractFileToDatabase(Part arquivo) throws IOException {
		InputStream input = arquivo.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] rb = new byte[1024];
		int ch = 0;
		while ((ch = input.read(rb)) != -1) {
			output.write(rb, 0, ch);
		}
		byte[] b = output.toByteArray();
		input.close();
		output.close();
		return b;
	}

}
