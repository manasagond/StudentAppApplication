<%@page import="java.util.ArrayList"%>
<%@page import="in.pentagon.studentapp.dto.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Management</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #fff;
      margin: 0;
      padding: 0;
    }

    .navbar {
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    }

    .navbar-brand {
      font-weight: bold;
      font-size: 1.2rem;
      padding-left: 10px;
    }

    .navbar-nav .nav-link {
      color: #f1f1f1;
      margin-right: 10px;
    }

    .navbar-nav .nav-link:hover {
      color: #0dcaf0;
    }

    .btn-danger {
      margin-left: 10px;
      font-weight: bold;
      padding: 6px 12px;
      border-radius: 5px;
    }

    h1 {
      font-size: 2.5rem;
      font-weight: 600;
      margin-top: 20px;
      margin-bottom: 30px;
      text-align: center;
    }

    h3 {
      margin: 20px 0;
      font-weight: 500;
    }

    .table {
      background-color: white;
      box-shadow: 0 4px 8px rgba(0,0,0,0.05);
      border-radius: 8px;
      overflow: hidden;
    }

    .table th {
      background-color: #f8f9fa;
      font-weight: 600;
    }

    .table-hover tbody tr:hover {
      background-color: #f1f1f1;
    }

    .container {
      max-width: 95%;
    }
    .success{
    color:green;}
  </style>
</head>
<body>
<% Student s=(Student)session.getAttribute("student"); %>


  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand navbar-primary" href="#">Welcome <%= s.getName() %></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link" href="reset.jsp">Reset Password</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="update.jsp">Update Data</a>
          </li>
          <li class="nav-item">
            <form action="logout" method="post" class="d-inline">
              <input class="btn btn-danger" type="button" name="logout" value="Logout">
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container mt-4">
    <h1 class="text-center mb-4">Dashboard</h1>
    <% String success=(String)request.getAttribute("success"); %>
    <%if(success!=null){ %>
    
  <center> <h3 class="success"> <%=success%></h3></center>
  <%} %>
 

    <div class="row">
      <div class="col-md-12">
        <h3>View Your Data</h3>
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Mail ID</th>
              <th>Branch</th>
              <th>Location</th>
            </tr>
          </thead>
          <tbody>
            <!-- Data rows will be inserted here -->
            <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
           <td><%= s.getPhone() %></td>
           <td><%= s.getMail() %></td>
           <td><%= s.getBranch() %></td>
           <td><%= s.getLoc()%></td>
            </tr>
           
           
          </tbody>
        </table>
      </div>
      <div>
      <h3>Search for User:</h3>
      <form action="search" method="post" >
       <input type="text" name="search">
       <input type="submit" value="search">
       
       </form>
       <br>
       <% ArrayList<Student> users=(ArrayList<Student>)request.getAttribute("users"); %>
       <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Branch</th>
              <th>Location</th>
            </tr>
          </thead>
          <tbody>
          <%if(users!=null && !users.isEmpty()) {%>
          <%for(Student s1:users) {%>
          <tr>
            <td><%= s1.getId() %></td>
            <td><%= s1.getName() %></td>
           <td><%= s1.getBranch() %></td>
           <td><%= s1.getLoc()%></td>
            </tr>
            <%} %>
           
            <%}else{%>
            <tr>
            <td colspan="4"><h4>Search again</h4> </td>
            </tr>
            <%} %>
          </tbody>
          </table>
     
      </div>
    </div>
  </div>

</body>
</html>
