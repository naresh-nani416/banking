package com.jsp.model;

import java.sql.Date;

public class BankUserInfo {
	private int User_Id;
	private String User_Name;
	private String User_Mobile_No;
	private String User_Email_Id;
	private String User_Address;
	private String User_Gender;
	private Date User_DOB;
	private String User_Type_Account;
	private int User_Account_No;
	private String Bank_Ifsc_Code;
	private int User_Password;
	private double User_Account_Balance;
	public BankUserInfo() {
		
	}
	public BankUserInfo(int user_Id, String user_Name, String user_Mobile_No, String user_Email_Id, String user_Address,
			String user_Gender, Date user_DOB, String user_Type_Account, int user_Account_No, String bank_Ifsc_Code,
			int user_Password, double user_Account_Balance) {
		
		User_Id = user_Id;
		User_Name = user_Name;
		User_Mobile_No = user_Mobile_No;
		User_Email_Id = user_Email_Id;
		User_Address = user_Address;
		User_Gender = user_Gender;
		User_DOB = user_DOB;
		User_Type_Account = user_Type_Account;
		User_Account_No = user_Account_No;
		Bank_Ifsc_Code = bank_Ifsc_Code;
		User_Password = user_Password;
		User_Account_Balance = user_Account_Balance;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Mobile_No() {
		return User_Mobile_No;
	}
	public void setUser_Mobile_No(String user_Mobile_No) {
		User_Mobile_No = user_Mobile_No;
	}
	public String getUser_Email_Id() {
		return User_Email_Id;
	}
	public void setUser_Email_Id(String user_Email_Id) {
		User_Email_Id = user_Email_Id;
	}
	public String getUser_Address() {
		return User_Address;
	}
	public void setUser_Address(String user_Address) {
		User_Address = user_Address;
	}
	public String getUser_Gender() {
		return User_Gender;
	}
	public void setUser_Gender(String user_Gender) {
		User_Gender = user_Gender;
	}
	public Date getUser_DOB() {
		return User_DOB;
	}
	public void setUser_DOB(Date user_DOB) {
		User_DOB = user_DOB;
	}
	public String getUser_Type_Account() {
		return User_Type_Account;
	}
	public void setUser_Type_Account(String user_Type_Account) {
		User_Type_Account = user_Type_Account;
	}
	public int getUser_Account_No() {
		return User_Account_No;
	}
	public void setUser_Account_No(int user_Account_No) {
		User_Account_No = user_Account_No;
	}
	public String getBank_Ifsc_Code() {
		return Bank_Ifsc_Code;
	}
	public void setBank_Ifsc_Code(String bank_Ifsc_Code) {
		Bank_Ifsc_Code = bank_Ifsc_Code;
	}
	public int getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(int user_Password) {
		User_Password = user_Password;
	}
	public double getUser_Account_Balance() {
		return User_Account_Balance;
	}
	public void setUser_Account_Balance(double user_Account_Balance) {
		User_Account_Balance = user_Account_Balance;
	}
	@Override
	public String toString() {
		return "BankUserInfo [User_Id=" + User_Id + ", User_Name=" + User_Name + ", User_Mobile_No=" + User_Mobile_No
				+ ", User_Email_Id=" + User_Email_Id + ", User_Address=" + User_Address + ", User_Gender=" + User_Gender
				+ ", User_DOB=" + User_DOB + ", User_Type_Account=" + User_Type_Account + ", User_Account_No="
				+ User_Account_No + ", Bank_Ifsc_Code=" + Bank_Ifsc_Code + ", User_Password=" + User_Password
				+ ", User_Account_Balance=" + User_Account_Balance + "]";
	}
	
}
