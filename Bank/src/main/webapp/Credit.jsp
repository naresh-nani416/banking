<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Page</title>
<link rel="stylesheet" type="text/css" href="Credit.css">
</head>
<body>
<h1 id="h1">Login Successfully</h1>
   <form action="crediturl" method="post" id="form">
      <h6 class="label">Account No</h6>
      <input class="input" placeholder="Enter the account number" name="acno"><br>
      <h6 class="label">Amount</h6>
      <input class="input" placeholder="Enter the amount" name="amount"><br><br>
      <input class="input" id="btn" type="submit">
   </form>
</body>
</html>