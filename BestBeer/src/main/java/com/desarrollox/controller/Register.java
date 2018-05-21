package com.desarrollox.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.desarrollox.dao.UserDao;
import com.desarrollox.model.User;
import com.desarrollox.util.Error;
import com.desarrollox.util.ValidationService;

@WebServlet("/register")
@MultipartConfig
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4978237698936143434L;
	private static final Logger logger = Logger.getLogger(Register.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("register.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ValidationService validator = ValidationService.getInstance();
		logger.info("Entrando na Servlet de cadastro");

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String lastName = req.getParameter("lastname");
		String password = req.getParameter("password");
		String confirmPass = req.getParameter("confirmpassword");

		logger.info("Inciciar Validação de E-Mail...");
		if (!validator.isValidEmail(email)) {
			
			req.setAttribute("email", email);
			req.setAttribute("name", name);
			req.setAttribute("lastname", lastName);
			req.setAttribute("erro", Error.EMAIL_INVALID.getMessage());
			RequestDispatcher dis = req.getRequestDispatcher("register.jsp");
			dis.forward(req, resp);
			return;
		}
		
		logger.info("Fim da Validação de E-Mail...");

		logger.info("Inciciar Validação de senha...");
		if (!password.equals(confirmPass)) {

			logger.info("as senhas não conferem");
			
			req.setAttribute("email", email);
			req.setAttribute("name", name);
			req.setAttribute("lastname", lastName);
			req.setAttribute("erro", Error.PASSWORD_NOT_MATCH.getMessage());

			RequestDispatcher dis = req.getRequestDispatcher("register.jsp");
			dis.forward(req, resp);
			return;
		}

		User user = new User();
		user.setName(name + " " + lastName);
		user.setPassword(password);
		user.setEmail(email);
		UserDao dao = new UserDao();
		dao.saveOrUpdate(user);

		resp.sendRedirect("login.jsp");

	}

}
