package com.manthan.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.user.dao.UserDAO;
import com.manthan.user.dto.User;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private UserDAO userDao;

	@Override
	public void init() throws ServletException {
		userDao = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("path : "+action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
			break;
			case "/edit":
				showEditForm(request, response);
			break;
			case "/list":
				listUser(request, response);
			break;
			case "/insert":
				insertUser(request, response);
			break;
			case "/update":
				updateUser(request, response);
			break;
			case "/delete":
				deleteUser(request, response);
				break;
			
			
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List < User > listUser = userDao.selectAllUsers();
		request.setAttribute("users", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-list.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-form.jsp?action=new");
		dispatcher.forward(request, response);
	}
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user-form.jsp?action=edit");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int age=Integer.parseInt(request.getParameter("age"));
		String phoneno=request.getParameter("phoneno");
		
		User existingUser = userDao.selectUser(email);
		
		if(existingUser != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user-form.jsp?action=new");
			request.setAttribute("message", "Email Exists");
			requestDispatcher.include(request, response);
			
		}else {
			User newUser = new User();
			newUser.setName(name);
			newUser.setAge(age);
			newUser.setPassword(password);
			newUser.setEmail(email);
			newUser.setPhoneno(phoneno);
			
			userDao.insertUser(newUser);
			response.sendRedirect("list");
		}

		
	} 
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		String phoneno=request.getParameter("phoneno");
		String password=request.getParameter("password");
		
		User user = new User(id, name, age, password, email, phoneno);
			userDao.updateUser(user);
			response.sendRedirect("list");
		
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");

	}
}
