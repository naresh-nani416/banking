package com.jsp.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jsp.model.BankStatement;
import com.jsp.model.BankUserInfo;

public interface UserDAO {
   int registration(BankUserInfo bankuserinfo);
   BankUserInfo login(String emailorphn,int password);
   boolean forgetpassword(String emailorphn,int password);
   boolean debit(int password,BankStatement bankstatement);
   int credit(BankStatement bankStatement);
   ResultSet checkBalance(int accountNo,int password);
   boolean deleteAccount(int accountNo,int password);
   ArrayList<BankStatement> bankStatement(int acno,Date from,Date to);
}