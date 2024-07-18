package com.jsp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;

import com.jsp.model.BankStatement;
import com.jsp.model.BankUserInfo;
import com.mysql.cj.jdbc.Driver;

public class UserDaoImpl implements UserDAO {

	Random random = new Random();
	static String url = "jdbc:mysql://localhost:3306/teca57?user=root&password=12345";
	@Override
	public int registration(BankUserInfo bankuserinfo) {
		
		
		
		String insert = "insert into user_bank_information(User_Name, User_Mobile_No, User_Email_Id, User_Address, User_Gender, User_DOB, User_Type_Account, User_Account_No, Bank_Ifsc_Code, User_Password, User_Account_Balance) values (?,?,?,?,?,?,?,?,?,?,?)";
	     
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1, bankuserinfo.getUser_Name());
			ps.setString(2, bankuserinfo.getUser_Mobile_No());
			ps.setString(3, bankuserinfo.getUser_Email_Id());
			ps.setString(4, bankuserinfo.getUser_Address());
			ps.setString(5, bankuserinfo.getUser_Gender());
			ps.setDate(6, bankuserinfo.getUser_DOB());
			ps.setString(7, bankuserinfo.getUser_Type_Account());
			int accNo = random.nextInt(10000000);
			if(accNo<1000000) accNo+=1000000;
			ps.setInt(8, accNo);
			ps.setString(9, "SBI00001");
			int password = random.nextInt(10000);
			if(password<1000) password+=1000;
			ps.setInt(10, password);
			ps.setDouble(11, bankuserinfo.getUser_Account_Balance());
			int updated = ps.executeUpdate();
			return updated;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public BankUserInfo login(String emailorphn,int password) {
		
		String display = "select *  from user_bank_information where (User_Email_Id=? or User_Mobile_No=?) and User_Password=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(display);
			ps.setString(1, emailorphn);
			ps.setString(2, emailorphn);
			ps.setInt(3, password);
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					BankUserInfo user = new BankUserInfo();
					user.setUser_Id(rs.getInt("User_Id"));
					user.setUser_Name(rs.getString("User_Name"));
					user.setUser_Mobile_No("User_Mobile_No");
					user.setUser_Email_Id(rs.getString("User_Email_Id"));
					user.setUser_Address(rs.getString("User_Address"));
					user.setUser_Gender(rs.getString("User_Gender"));
					user.setUser_DOB(rs.getDate("User_DOB"));
					user.setUser_Type_Account(rs.getString("User_Type_Account"));
					user.setUser_Account_No(rs.getInt("User_Account_No"));
					user.setBank_Ifsc_Code(rs.getString("Bank_Ifsc_Code"));
					user.setUser_Password(rs.getInt("User_Password"));
					user.setUser_Account_Balance(rs.getDouble("User_Account_Balance"));
					return user;
				}
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean forgetpassword(String emailorphn,int password) {
		// TODO Auto-generated method stub
		String update = "update user_bank_information set User_Password=? where User_Email_Id=? or User_Mobile_No=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setInt(1, password);
			ps.setString(2,emailorphn);
			ps.setString(3, emailorphn);
			int updated = ps.executeUpdate();
			if(updated>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean debit(int password, BankStatement bankstatement) {
		String update = "update user_bank_information set User_Account_Balance=? where User_Account_No=? and User_Password=?";
		String insert = "insert into statement (User_Name, Date_Of_Transcation, Time_Of_Transction, User_Account_No, Transcation_If, Transaction_Amount, Balance_Amount) values (?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps1 = connection.prepareStatement(update);
			ps1.setDouble(1, bankstatement.getBalance_Amount());
			ps1.setInt(2, bankstatement.getUser_Account_No());
			ps1.setInt(3, password);
			int updatedRows = ps1.executeUpdate();
			if(updatedRows>0) {
				PreparedStatement ps2 = connection.prepareStatement(insert);
				ps2.setString(1, bankstatement.getUser_Name());
				ps2.setDate(2, bankstatement.getDate_Of_Transcation());
				ps2.setTime(3, bankstatement.getTime_Of_Transction());
				ps2.setInt(4, bankstatement.getUser_Account_No());
				int transaction_id = random.nextInt(10000);
				if(transaction_id<1000) transaction_id+=1000;
				ps2.setInt(5, transaction_id);
				ps2.setDouble(6, bankstatement.getTransaction_Amount());
				ps2.setDouble(7, bankstatement.getBalance_Amount());
				int updated2 = ps2.executeUpdate();
				if(updated2!=0) {
					return true;
				}
				else {
					return false;
				}
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int credit(BankStatement bankStatement) {
		String update = "update user_bank_information set User_Account_Balance=? where User_Account_No=?";
		String insert = "insert into statement (User_Name, Date_Of_Transcation, Time_Of_Transction, User_Account_No, Transcation_If, Transaction_Amount, Balance_Amount) values (?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps2 = connection.prepareStatement(update);
			ps2.setDouble(1, bankStatement.getBalance_Amount());
			ps2.setInt(2, bankStatement.getUser_Account_No());
		    int updated = ps2.executeUpdate();
		    if(updated!=0) {
		    	PreparedStatement ps1 = connection.prepareStatement(insert);
		    	ps1.setString(1, bankStatement.getUser_Name());
				ps1.setDate(2, bankStatement.getDate_Of_Transcation());
				ps1.setTime(3, bankStatement.getTime_Of_Transction());
				ps1.setInt(4, bankStatement.getUser_Account_No());
				int transactionid = random.nextInt(10000);
				if(transactionid<1000) transactionid+=1000;
				ps1.setInt(5, transactionid);
				ps1.setDouble(6, bankStatement.getTransaction_Amount());
				ps1.setDouble(7, bankStatement.getBalance_Amount());
			    int updated1 = ps1.executeUpdate();
			    if(updated1!=0) {
			    	return 1;
			    }
			    else {
			    	return 0;
			    }
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public ResultSet checkBalance(int accountNo, int password) {
		String select = "select * from user_bank_information where User_Account_No=? and User_Password=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setInt(1, accountNo);
			ps.setInt(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					return rs;
				}
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteAccount(int accountNo, int password) {
		
		String delete = "delete from user_bank_information where User_Account_No=? and User_Password=?";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setInt(1, accountNo);
			ps.setInt(2, password);
			int result = ps.executeUpdate();
			if(result!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<BankStatement> bankStatement(int acno, Date from, Date to) {
		
		String select = "SELECT * FROM statement WHERE User_Account_No=? AND Date_Of_Transcation BETWEEN ? AND ?";
		ArrayList<BankStatement> bank = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setInt(1, acno);
			ps.setDate(2, from);
			ps.setDate(3, to);
			ResultSet rs = ps.executeQuery();
			BankStatement statement=new BankStatement();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					statement.setUser_Name(rs.getString(1));
					statement.setDate_Of_Transcation(rs.getDate(2));
					statement.setTime_Of_Transction(rs.getTime(3));
					statement.setUser_Account_No(rs.getInt(4));
					statement.setTranscation_Id(rs.getInt(5));
					statement.setTransaction_Amount(rs.getDouble(6));
					statement.setBalance_Amount(rs.getDouble(7));
					bank.add(statement);
				}
				return bank ;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
