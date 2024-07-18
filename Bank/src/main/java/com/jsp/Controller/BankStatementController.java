package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
@WebServlet("/bankstatementurl")
public class BankStatementController extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int acno =Integer.parseInt(request.getParameter("acno"));
	Date from_Date = Date.valueOf(request.getParameter("from"));
	Date to_Date = Date.valueOf(request.getParameter("to"));
	response.setContentType("text/html");
	PrintWriter writer = response.getWriter();
	HttpSession session = request.getSession();
    BankUserInfo  info = (BankUserInfo) session.getAttribute("user");
    UserDAO user = UserDAOHelperClass.userDAO();
    if(info.getUser_Account_No()==acno) {
         ArrayList<BankStatement> bankStatement = user.bankStatement(acno, from_Date, to_Date);
          if(bankStatement!=null) {
        	  RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
        	  rd.include(request, response);
        	  writer.println("<table><tr><th style=border:2px solid black;>User_Name  Date_Of_Transcation  Time_Of_Transction  User_Account_No  Transcation_If  Transaction_Amount  Balance_Amount</th></tr>");
				for (BankStatement bankStatement2 : bankStatement) {
					writer.println("<tr><td style=border:2px solid black;>");
					
					writer.println(bankStatement2.getUser_Name()+"      ");
					writer.println(bankStatement2.getDate_Of_Transcation()+"      ");
					writer.println(bankStatement2.getTime_Of_Transction()+"      ");
					writer.println(bankStatement2.getUser_Account_No()+"      ");
					writer.println(+bankStatement2.getTranscation_Id()+"      ");
					writer.println(+bankStatement2.getTransaction_Amount()+"      ");
					writer.println(bankStatement2.getBalance_Amount()+"      ");
					writer.println("</td></tr>");
          }
		   writer.println("</table>");
        }
    else {
    	RequestDispatcher rd = request.getRequestDispatcher("BankStatement.jsp");
  	  rd.include(request, response);
		writer.println("<center><h1>Invalid Account Number</h1></center>");

    }
}
   }
}
