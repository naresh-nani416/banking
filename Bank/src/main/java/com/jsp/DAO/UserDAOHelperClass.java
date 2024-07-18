package com.jsp.DAO;

public class UserDAOHelperClass {
  public static UserDAO userDAO() {
	 UserDAO userDao = (UserDAO) new UserDaoImpl();
	 return userDao;
  }
}
