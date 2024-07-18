package com.jsp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

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
@WebServlet("/checkbalanceurl")
public class CheckBalanceController extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int accno =Integer.parseInt(request.getParameter("accno"));
     int password =Integer.parseInt(request.getParameter("password"));
     PrintWriter writer =response.getWriter();
     response.setContentType("text/html");
     HttpSession session = request.getSession();
     BankUserInfo  user = (BankUserInfo) session.getAttribute("user");
     UserDAO userDAO = UserDAOHelperClass.userDAO();
     if(user.getUser_Account_No()==accno) {
    	 if(user.getUser_Password()==password) {
    		 ResultSet rs = userDAO.checkBalance(accno, password);
    		 if(rs!=null) {
    			 try {
					writer.println("<center><h1 style=color:white;>Account Holder Name : "+rs.getString("User_Name")+"</h1></center>");
					writer.println("<center><h1 style=color:white;>Account Balance : "+rs.getDouble("User_Account_Balance")+"</h1></center>");
					RequestDispatcher rd = request.getRequestDispatcher("Operation.jsp");
	    			rd.include(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
    		 } 
    	 }
    	 else {
    		 RequestDispatcher rd = request.getRequestDispatcher("CheckBalance.jsp");
 			rd.include(request, response);
    		 writer.println("<center><h1 style=color:white;>Incorrect Password</h1></center>");
    	 }
     }
     else {
    	 RequestDispatcher rd = request.getRequestDispatcher("CheckBalance.jsp");
			rd.include(request, response);
		 writer.println("<center><h1 style=color:white;>Invalid Account Number</h1></center>");
     }
     
    
   }
}
