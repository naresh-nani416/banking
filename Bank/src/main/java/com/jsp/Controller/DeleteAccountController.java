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
@WebServlet("/deleteaccounturl")
public class DeleteAccountController extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int accountno =Integer.parseInt(request.getParameter("accno"));
	int password = Integer.parseInt(request.getParameter("password"));
	
	UserDAO user = UserDAOHelperClass.userDAO();
	HttpSession session = request.getSession();
	PrintWriter writer = response.getWriter();
	response.setContentType("text/html");
	BankUserInfo info = (BankUserInfo) session.getAttribute("user");
	System.out.println(info.getUser_Account_No());
	System.out.println(info.getUser_Password());
	if(info.getUser_Account_No()==accountno) {
		if(info.getUser_Password()==password) {
	if(user.deleteAccount(accountno, password)) {
		RequestDispatcher rd = request.getRequestDispatcher("Operation.jsp");
		rd.include(request, response);
		writer.println("<center><h1 style=color:white;>Account Deleted Successfully</h1></center>");
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
		rd.include(request, response);
		writer.println("<center><h1 style=color:white;>Invalid Details</h1></center>");
	   }
     }
		else {
			RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
			rd.include(request, response);
			writer.println("<center><h1 style=color:white;>Invalid Password</h1></center>");
		}
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("DeleteAccount.jsp");
		rd.include(request, response);
		writer.println("<center><h1 style=color:white;>Invalid Account Number</h1></center>");
	}
   }
}
