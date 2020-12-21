package com.manthan.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.user.dao.UserDAO;
import com.manthan.user.dto.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserDAO userDao = null;

	public LoginServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		userDao = new UserDAO();
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher loginPageRd = request.getRequestDispatcher("/login-page");
		RequestDispatcher userListRd = request.getRequestDispatcher("user/list");

		try {
			System.out.println("In Side Login...");

			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("UserName : " + userName + " Password : " + password);

			boolean authenticated = userDao.validate(userName, password);

			if (authenticated) {
				HttpSession session = request.getSession();
				User user = userDao.selectUser(userName);
				session.setAttribute("user", user);
				userListRd.forward(request, response);

			} else {
				System.out.println("Invalid username and password");
				request.setAttribute("message", "Invalid Username or Password.");
				loginPageRd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Please try after some time.");
			loginPageRd.include(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}