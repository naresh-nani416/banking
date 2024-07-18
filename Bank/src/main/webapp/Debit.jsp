<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Page</title>
<link rel="stylesheet" type="text/css" href="Debitt.css">
</head>
<body>
     <form action="debiturl" method="post" id="form">
     <h1 id="h1">Debit</h1><br>
        <h6 class="label">Account No</h6>
        <input class="input" placeholder="Enter the accoun number" name="accno"><br><br>
        <h6 class="label">Password</h6>
        <input class="input" placeholder="Enter the password" type="password" name="password"><br><br>
        <h6 class="label">Amount</h6>
        <input class="input" placeholder="Enter the ammount" name="amount"><br><br>
        <input class="input" id="btn" type="submit">
     </form>
</body>
</html>