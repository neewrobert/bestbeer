package com.desarrollox.controller.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.desarrollox.util.ValidationService;

/**
 * Desing Patter SINGLETON
 * @author nrdossantos
 *
 */
public class ServletUtil {
	
	private static ServletUtil instance;
	
	
	//construtor privado
	private ServletUtil() {
		
	}
	
	public static synchronized ServletUtil getInstance() {
		if(instance == null) {
			instance = new ServletUtil();
		}
		return instance;
	}
	
	
	public byte[] extractFileToDatabase(Part arquivo) throws IOException {
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
	
	public String savePhotoInPath(HttpServletRequest req, String nome, Part arquivo) throws IOException {
		String nomeArq = arquivo.getSubmittedFileName();
		String ext = nomeArq.split("\\.")[1];
		String path = req.getServletContext().getRealPath("foto");
		
		nomeArq = nome.replace(" ", "") + System.currentTimeMillis() + "." + ext;
		
		arquivo.write(path + "/" + nomeArq);
		
		return nomeArq;
	}

}
