
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Forget Page</title>
<link rel="stylesheet" type="text/css" href="ForgetPassword.css">
</head>
<body>
    <form action="forgeturl" id="form" >
       <h2 id="h1">Forget Password</h2>
        <h6 class="label">Email</h6>
        <input class="input" placeholder="Enter the email" name="emailid"><br>
        <h6 class="label">Password</h6>
        <input class="input" placeholder="Enter the new password" type="password" name="pass"><br><br>
        <input class="input" id="btn" type="submit">   
    </form>

</body>
</html>