<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<form method = "get" action = "Login">
  				<div class="form-group row">
    				<label for="id" class="col-sm-2 col-form-label col-form-label-lg"><b>user ID</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "id" class="form-control form-control-lg" placeholder="user">
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="author" class="col-sm-2 col-form-label col-form-label-lg"><b>password</b></label>
    				<div class="col-sm-10">
      					<input type="text" class="form-control form-control-lg" name="author" placeholder="pass">
    				</div>
  				</div>
  				<div class = "row">
  					 	<!--Insert button should put new file in the Database-->
        			 <div class="btn-group col-sm-4">
            			<input type="submit" value="Submit" class="btn btn-primary col-sm-12" name = "insert"/>
        			 </div>
				</div>
			</form>
</body>
</html>