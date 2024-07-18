package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.UserDAO;
import com.jsp.DAO.UserDAOHelperClass;
import com.jsp.model.BankUserInfo;
@WebServlet("/registrationurl")
public class RegistrationController extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String phno = request.getParameter("phno");
	String email = request.getParameter("email");
	String address = request.getParameter("add");
	String gender = request.getParameter("gen");
	String Dob =  request.getParameter("dobb");
    Date dateOfBirth = Date.valueOf(Dob);
	String typeOfAc = request.getParameter("typeofac");
	String minblc = request.getParameter("minblc");
	double minbalance = Double.parseDouble(minblc);
	
	BankUserInfo userInfo = new BankUserInfo();
	userInfo.setUser_Name(name);
	userInfo.setUser_Mobile_No(phno);
	userInfo.setUser_Email_Id(email);
	userInfo.setUser_Address(address);
	userInfo.setUser_Gender(gender);
	userInfo.setUser_DOB(dateOfBirth);
	userInfo.setUser_Type_Account(typeOfAc);
	userInfo.setUser_Account_Balance(minbalance);
	response.setContentType("text/html");
	UserDAO userDAO = UserDAOHelperClass.userDAO();
	PrintWriter pw=response.getWriter();
	int registration = userDAO.registration(userInfo);
	if (registration!=0) {
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		pw.println("<center><h1 style=color:white;>Registration Successfull......</h1></center>");

	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
		rd.include(request, response);
		pw.println("<center><h1 style=color:white;>Registration Fail......</h1></center>");
	}
	
}
}
