package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.DAO.UserDAO;
import com.jsp.DAO.UserDAOHelperClass;
import com.jsp.model.BankUserInfo;
@WebServlet("/forgeturl")
public class ForgetPasswordController extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String email = request.getParameter("emailid");
	int password =Integer.parseInt(request.getParameter("pass"));
	
	response.setContentType("text/html");
	PrintWriter writer =response.getWriter();
	BankUserInfo userInfo = new BankUserInfo();
	userInfo.setUser_Email_Id(email);
	userInfo.setUser_Password(password);
	
	UserDAO userDAO = UserDAOHelperClass.userDAO();
	if(userDAO.forgetpassword(email, password)) {
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
		writer.println("<center><h1 style=color:white;>Set Password Successfully</h1></center>");
		
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
		writer.println("<center><h1 style=color:white;>Set Password Successfully</h1></center>");

	}
}
}
