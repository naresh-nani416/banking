<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Balance Page</title>
<link rel="stylesheet" type="text/css" href="CheckBalance.css">
</head>
<body>

   <form action="checkbalanceurl" id="form" method="post">
     <h1 id="h1">Check</h1>
     <h1 id="h2">Balance</h1>
     <h6 class="label">Account no</h6>
     <input class="input" placeholder="Enter the Account Number" name= "accno"><br><br>
     <h6 class="label">Password</h6>
     <input class="input" placeholder="Enter the Password" name="password" type="password"><br><br>
     <input class="input" id="btn" type="submit">
   </form>
</body>
</html>