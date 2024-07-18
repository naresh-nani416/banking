<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operation Page</title>
<link rel="stylesheet" type="text/css" href="Operation.css">
</head>
<body>
<h1 id="h1">Login Successfully</h1>
    <form action="operationurl" id="form">
    
       <button class="btn"><a class="a" href="Credit.jsp">Credit</a></button>
       <button class="btn"><a class="a" href="Debit.jsp">Debit</a></button><br>
       <button class="btn"><a class="a" href="BankStatement.jsp">Bank Statement</a></button>
       <button class="btn"><a class="a" href="CheckBalance.jsp">Check Balance</a></button><br>
       <button id="btn" class="btn"><a class="a" href="DeleteAccount.jsp">Delete Account</a></button>
    </form>
</body>
</html>