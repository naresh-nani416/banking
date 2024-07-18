<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account Page</title>
<link rel="stylesheet" type="text/css" href="DeleteAccount.css">
</head>
<body>
   <form action="deleteaccounturl" id="form" method="post">
     <h1 id="h1">Delete Bank Account</h1><br>
     <h6 class="label">Account No</h6>
     <input class="input" placeholder="Enter the Account Number" name="accno"><br><br>
     <h6 class="label"class="label">Password</h6>
     <input class="input" placeholder="Enter the Password" name="password" type="password"><br><br>
     <input class="input" id="btn" type="submit">
   </form>
</body>
</html>