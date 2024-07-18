package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/logins")
public class LoginController extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String emailorphno = request.getParameter("emailorphn");
    	int password =Integer.parseInt(request.getParameter("password"));
    	BankUserInfo info = new BankUserInfo();
    	info.setUser_Email_Id(emailorphno);
    	info.setUser_Password(password);
    	
    	PrintWriter pw=response.getWriter();
    	response.setContentType("text/html");
    	HttpSession session = request.getSession();	
    	
    	UserDAO userDAO = UserDAOHelperClass.userDAO();
    	BankUserInfo userInfo = userDAO.login(emailorphno, password);
    	session.setAttribute("acno", userInfo.getUser_Account_No());
    	session.setAttribute("bal", userInfo.getUser_Account_Balance());
    	session.setAttribute("user", userInfo);
    	String name = (String) session.getAttribute("name");
    	Integer accno = (Integer) session.getAttribute("acno");
    	Double balance = (Double) session.getAttribute("bal");
    	System.out.println(name);
    	System.out.println(balance);
    	if(userInfo.getUser_Email_Id().equalsIgnoreCase(emailorphno)||userInfo.getUser_Mobile_No().equalsIgnoreCase(emailorphno)) {
    	if(userInfo.getUser_Password()==password) {
    	if(userInfo!=null) {
    		RequestDispatcher rd = request.getRequestDispatcher("Operation.jsp");
    		rd.include(request, response);
    		pw.println("<center><h1 style=color:white;>Account Holder Name : "+name+"</h1></center>");
    		pw.println("<center><h1 style=color:white;>Account No : "+accno+"</h1></center>");
    		pw.println("<center><h1 style=color:white;>Account Balance : "+balance+"</h1></center>");
    		
    	}
    	else{
    		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
    		rd.include(request, response);
    		pw.println("<center><h1 style=color:white;>Login Fail</h1></center>");
    	}
    	}
    	else {
    		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
    		rd.include(request, response);
    		pw.println("<center><h1 style=color:white;>Invalid Password</h1></center>");
    	}
    	}
    	else {
    		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
    		rd.include(request, response);
    		pw.println("<center><h1 style=color:white;>Invalid Email or Phno</h1></center>");
    	}
    }
     
}
