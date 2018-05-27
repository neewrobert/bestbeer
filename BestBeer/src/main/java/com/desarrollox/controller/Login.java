package com.desarrollox.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desarrollox.dao.UserDao;
import com.desarrollox.model.User;
import com.desarrollox.util.Error;
import com.desarrollox.util.ValidationService;

@WebServlet("/login")
@MultipartConfig
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1249728872762399772L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ValidationService validator = ValidationService.getInstance();

		String login = req.getParameter("login");
		String pass = req.getParameter("password");

		if (!validator.isValidEmail(login)) {
			req.setAttribute("erro", Error.EMAIL_INVALID.getMessage());

			RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
			dis.forward(req, resp);
		}

		User user = new User();
		user.setEmail(login);
		user.setPassword(pass);

		UserDao dao = new UserDao();
		User userFound = dao.isUserExist(user);
		if (userFound != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", userFound.getId().toString());
			session.setMaxInactiveInterval(600);
			resp.sendRedirect("dashboard");
		} else {
			req.setAttribute("erro", Error.USER_NOT_FOUND.getMessage());
			RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
			dis.forward(req, resp);
		}

	}

}
