package com.desarrollox.controller;

import java.io.IOException;
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
		
		String id = req.getParameter("nome");
		BeerDao dao = new BeerDao();
		
		Beer beer = dao.findById(Beer.class, Long.parseLong(id));
		
		byte[] imageBytes = beer.getImage();
		
		resp.setContentType("image/jpg");
		resp.setContentLength(imageBytes.length);
		resp.getOutputStream().write(imageBytes);
		
	}

}
