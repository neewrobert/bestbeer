package com.desarrollox.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desarrollox.dao.BeerDao;
import com.desarrollox.model.Beer;

@WebServlet("/foto")
public class Foto extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		
		String strPath = req.getServletContext().getRealPath("foto");
		Path path = Paths.get(strPath, nome);
		byte[] imageBytes;
		
		if(nome != null && !nome.isEmpty() && Files.exists(path)) {
			imageBytes = Files.readAllBytes(path);
		}else {
			path = Paths.get(strPath, "garrafa.jpg");
			imageBytes = Files.readAllBytes(path);
		}
		
		resp.setContentType("image/jpg");
		resp.setContentLength(imageBytes.length);
		resp.getOutputStream().write(imageBytes);
		
	}

}
