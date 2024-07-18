package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.UserDAO;
import com.jsp.DAO.UserDAOHelperClass;
import com.jsp.model.BankStatement;
import com.jsp.model.BankUserInfo;
@WebServlet("/crediturl")
public class CreditController extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int accno =Integer.parseInt(request.getParameter("acno"));
	Double amount = Double.parseDouble(request.getParameter("amount"));	
	HttpSession session = request.getSession();
	BankUserInfo user = (BankUserInfo) session.getAttribute("user");
	UserDAO dao = UserDAOHelperClass.userDAO();
	PrintWriter writer = response.getWriter();
	if(user.getUser_Account_No()==accno) {

			double balance = user.getUser_Account_Balance()+amount;
			BankStatement bankstatement = new BankStatement();
			bankstatement.setBalance_Amount(balance);
			bankstatement.setDate_Of_Transcation(Date.valueOf(LocalDate.now()));
			bankstatement.setTime_Of_Transction(Time.valueOf(LocalTime.now()));
			bankstatement.setTransaction_Amount(amount);
			bankstatement.setUser_Account_No(accno);
			bankstatement.setUser_Name(user.getUser_Name());
			int credited = dao.credit(bankstatement);
			if(credited==1) {
				RequestDispatcher rd = request.getRequestDispatcher("Operation.jsp");
				rd.include(request, response);
				writer.println("<center><h1 style=color:white;>Transaction Successfull</h1></center>");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Credit.jsp");
				rd.include(request, response);
				writer.println("<center><h1 style=color:white;>Transaction Fail</h1></center>");
		}
	
	
}
}
}
