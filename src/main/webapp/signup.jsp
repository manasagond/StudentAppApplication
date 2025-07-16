<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #dfe9f3, #ffffff);
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            background-color: #f9f9f9;
            margin: 60px auto;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #0a3d62;
        }

        h2 {
            color: #1e90ff;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            text-align: left;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #1e90ff;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            width: 100%;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0a75c2;
        }

        p {
            margin-top: 20px;
        }

        a {
            color: #1e90ff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
        .error{
        color:red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Pentagon Space</h1>
        <h2>Application Form</h2>
        <% String error=(String)request.getAttribute("error"); %>
        <%if(error!=null) {%>
        <h3 class="error"><%= error %></h3>
        <%} %>
        <form action="signup" method="post">
            <label for="name">Enter your Name:</label>   
            <input type="text" name="name" id="name" required>

            <label for="phone">Enter the Phone Number:</label>
            <input type="text" name="phone" id="phone" required>

            <label for="mail">Enter the Mail ID:</label>
            <input type="email" name="mail" id="mail" required>

            <label for="branch">Enter the Branch:</label>
            <input type="text" name="branch" id="branch" required>

            <label for="location">Enter the Location:</label>
            <input type="text" name="location" id="location" required>

            <label for="pass">Enter the Password:</label>
            <input type="password" name="pass" id="pass" required>

            <label for="conf">Confirm the Password:</label>
            <input type="password" name="conf" id="conf" required>

            <input type="submit" value="Create Account">
            <p>Already have an account? <a href="login.jsp">Login</a></p>
        </form>
    </div>
</body>
</html>
