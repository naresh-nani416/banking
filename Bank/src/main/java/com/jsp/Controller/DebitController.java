package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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

@WebServlet("/debiturl")
public class DebitController extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int accno =Integer.parseInt(request.getParameter("accno"));
	int password =Integer.parseInt(request.getParameter("password"));
	double amount = Double.parseDouble(request.getParameter("amount"));
	HttpSession session =request.getSession();
	PrintWriter writer = response.getWriter();
	response.setContentType("text/html");
	BankUserInfo user =(BankUserInfo) session.getAttribute("user");
	System.out.println(user);
	UserDAO dao = UserDAOHelperClass.userDAO();
	
	if(user.getUser_Account_No()==accno) {
		if(user.getUser_Password()==password) {
			if(amount>0) {
				if(user.getUser_Account_Balance()>amount) {
					double databasebal = user.getUser_Account_Balance()-amount;
					BankStatement bankstatement = new BankStatement();
					bankstatement.setBalance_Amount(databasebal);
					bankstatement.setDate_Of_Transcation(Date.valueOf(LocalDate.now()));
					bankstatement.setTime_Of_Transction(Time.valueOf(LocalTime.now()));
					bankstatement.setTransaction_Amount(amount);
					bankstatement.setUser_Account_No(accno);
					bankstatement.setUser_Name(user.getUser_Name());
					if(dao.debit(password, bankstatement)) {
						RequestDispatcher rd = request.getRequestDispatcher("Operation.jsp");
						rd.include(request, response);
						writer.println("<center><h1 style=color:white;>Transaction Successfull...</h1></center>");
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
						rd.include(request, response);
						writer.println("<center><h1 style=color:white;>Transaction Failed...</h1></center>");
					}
					
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
					rd.include(request, response);
					writer.println("<center><h1 style=color:white;>Insufficent Balance</h1></center>");
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
				rd.include(request, response);
				writer.println("<center><h1 style=color:white;>Invalid Amount Please Enter valid Amount</h1></center>");
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
			rd.include(request, response);
			writer.println("<center><h1 style=color:white;>Invalid Password Please Enter valid Password</h1></center>");
		}
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
		rd.include(request, response);
		writer.println("<center><h1 style=color:white;>Invalid Account no Please Enter valid Account no</h1></center>");
	}
}
}
