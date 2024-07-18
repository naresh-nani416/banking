<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Statement Page</title>
<link rel="stylesheet" type="text/css" href="BankStatement.css">
</head>
<body>
   
   <form action="bankstatementurl" id="form" method="post">
   <h1 id="h1">Bank Statement</h1>
     <h6 class="label">Account No</h6>
     <input class="input" placeholder="Enter the Account Number" name="acno"><br>
     <h6 class="label" >From Date</h6>
     <input class="input"  name="from"><br>
     <h6 class="label" >To Date</h6>
     <input class="input"  name="to"><br><br><br>
     <input class="input" id="btn" type="submit">
   </form>
</body>
</html>