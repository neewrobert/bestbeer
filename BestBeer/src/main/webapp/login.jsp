<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
  <title>The BestBeer Administrator : Login</title>
  <!-- Bootstrap core CSS-->
  <link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/bootstrap/css/sb-admin.css" rel="stylesheet">
  <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
      
        <form action="login" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" name="login" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" name="password" id="exampleInputPassword1" type="password" placeholder="Password">
          </div>
          <input type="submit" class="btn btn-primary btn-block" value="Login">
        </form>
       
        <div class="text-center">
          <a class="d-block small mt-3" href="register.jsp">Register an Account</a>
        </div>
      </div>
        <div class = "alert alert-danger" style="display: ${empty erro ? 'none' : ''}" > 
			<a class="close" data-dismiss="alert"> × </a> 
			${erro}
		  </div> 
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
  <script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
