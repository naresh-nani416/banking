<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="Registration.css">
</head>
<body>
    
       <form action="registrationurl" id="form">
           <h1 id="h1">Registration</h1><br>
           <h5 class="label">Name</h5>
           <input class="input" placeholder="Enter the name" name="name"><br><br>
           <h5 class="label">Mobile No</h5>
           <input class="input"  placeholder="Enter the mobile number" name="phno"><br><br>
           <h5 class="label">Eamil Id</h5>
           <input class="input"  placeholder="Enter the email id" name="email"><br><br>
           <h5 class="label">Address</h5>
           <input class="input"  placeholder="Enter the address" name="add"><br><br>
           <h5 class="label">Gender</h5>
           <input class="input" placeholder="Enter the gender" name="gen"><br><br>
           <h5 class="label">Date of Birth</h5>
           <input class="input"  placeholder="Enter the date of birth" name="dobb" ><br><br>
           <h5 class="label">Type of Account</h5>
           <input class="input"  placeholder="Enter the type of account" name="typeofac"><br><br>
           <h5 class="label">Minimum Account Balance</h5>
           <input class="input"  placeholder="Enter the minimum balance acount" name="minblc"><br><br>
           <input class="input"  id="btn" type="submit"><br>
       </form>
        
</body>
</html>