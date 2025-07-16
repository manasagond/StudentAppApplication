<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #74ebd5, #acb6e5);
            height: 100vh;
        }

        .login-box {
            background-color: #fff;
            width: 350px;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            margin: 100px auto;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #00796b;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #004d40;
        }

        .links {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }

        .links a {
            text-decoration: none;
            color: #00796b;
            font-size: 14px;
        }

        .links a:hover {
            text-decoration: underline;
        }

        .signup {
            text-align: center;
            margin-top: 20px;
        }

        .signup a {
            color: #00796b;
            text-decoration: none;
        }

        .signup a:hover {
            text-decoration: underline;
        }
        .success{
        color:green;
        }
        .error{
        color:red;}
    </style>
</head>
<body>

    <form action="login" method="post">
        <div class="login-box">
        <% String success=(String)request.getAttribute("success"); %>
<%if(success!=null){ %>
<h3 class="success"><%= success %></h3>
<%} %>
<% String error=(String)request.getAttribute("error"); %>
<% if(error!=null){ %>
 <center><h3 class="error"><%=error %></h3></center>
<%} %>
            <h2>Login</h2>
            <label for="mail">Enter User Mail:</label>
            <input type="email" name="mail" id="mail" required>

            <label for="pass">Enter Password:</label>
            <input type="password" name="pass" id="pass" required>

           <input type="submit" value="Login">

            <div class="links">
                <a href="forgetpassword.jsp">Forgot password?</a>
            </div>

            <div class="signup">
                <p>Don't have an account? <a href="signup.jsp">Signup</a></p>
            </div>
        </div>
    </form>
</body>
</html>
