package com.jsp.model;

import java.sql.Date;
import java.sql.Time;

public class BankStatement {
	private String User_Name;
	private Date Date_Of_Transcation;
	private Time Time_Of_Transction;
	private int User_Account_No;
	private int Transcation_Id;
	private double Transaction_Amount;
	private double Balance_Amount;
	public BankStatement() {
		
	}
	public BankStatement(String user_Name, Date date_Of_Transcation, Time time_Of_Transction, int user_Account_No,
			int transcation_Id, double transaction_Amount, double balance_Amount) {
		super();
		User_Name = user_Name;
		Date_Of_Transcation = date_Of_Transcation;
		Time_Of_Transction = time_Of_Transction;
		User_Account_No = user_Account_No;
		Transcation_Id = transcation_Id;
		Transaction_Amount = transaction_Amount;
		Balance_Amount = balance_Amount;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public Date getDate_Of_Transcation() {
		return Date_Of_Transcation;
	}
	public void setDate_Of_Transcation(Date date_Of_Transcation) {
		Date_Of_Transcation = date_Of_Transcation;
	}
	public Time getTime_Of_Transction() {
		return Time_Of_Transction;
	}
	public void setTime_Of_Transction(Time time_Of_Transction) {
		Time_Of_Transction = time_Of_Transction;
	}
	public int getUser_Account_No() {
		return User_Account_No;
	}
	public void setUser_Account_No(int user_Account_No) {
		User_Account_No = user_Account_No;
	}
	public int getTranscation_Id() {
		return Transcation_Id;
	}
	public void setTranscation_Id(int transcation_Id) {
		Transcation_Id = transcation_Id;
	}
	public double getTransaction_Amount() {
		return Transaction_Amount;
	}
	public void setTransaction_Amount(double transaction_Amount) {
		Transaction_Amount = transaction_Amount;
	}
	public double getBalance_Amount() {
		return Balance_Amount;
	}
	public void setBalance_Amount(double balance_Amount) {
		Balance_Amount = balance_Amount;
	}
	@Override
	public String toString() {
		return "BankStatement [User_Name=" + User_Name + ", Date_Of_Transcation=" + Date_Of_Transcation
				+ ", Time_Of_Transction=" + Time_Of_Transction + ", User_Account_No=" + User_Account_No
				+ ", Transcation_Id=" + Transcation_Id + ", Transaction_Amount=" + Transaction_Amount
				+ ", Balance_Amount=" + Balance_Amount + "]";
	}
	
	
}
