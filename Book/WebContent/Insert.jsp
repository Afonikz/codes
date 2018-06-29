<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href = "css/bootstrap.min.css" rel = "stylesheet" type = "text/css"/>
    
	<title>Add New Book</title>
</head>
<body>
	<br />
	<!-- Links -->
	<div class="container-fluid">
	<div class = "row">
		<div class = "col"><h2>Book Details</h2></div>
		<div class = "col text-right"><a href = "ViewBooks.jsp" class="btn btn-outline-secondary">View All Books</a></div>
	</div>

	<!-- Search Box -->
        <div class="container">
            <div class="row">
                <div class="col-sm-10 offset-sm-1 text-center">
                    <h1 class="display-3">Afolorunsho on point</h1>
                    <div class="info-form">
                    
                        <form action="ProcessData" class="form-inline justify-content-center">
        				<!--Edit button should link a page that Edit file-->
        			 		<div class="btn-group col-sm-2">
            					<input type="submit" name = "oper" class="btn btn-primary col-sm-12" value="Edit"/>
        					</div>
                            <div class="form-group">
                                <input type="text" class="form-control" name = "id" placeholder="Enter Book ID">
                            </div>
                                <!--Search button should fin a book using it book id.-->
        					<div class="btn-group col-sm-2">
            					<input type="submit" name = "oper" class="btn btn-primary col-sm-12" value="Search" />
        					</div>
        					
                        </form>
                        
                    </div>
                    <br />
                </div>
            </div>
        </div>
        
       

	<!-- Add book form -->
	<div class="justify-content-center align-items-center container ">
		<div class="">
			<form method = "" action = "ProcessData" >
  				<div class="form-group row">
    				<label for="id" class="col-sm-2 col-form-label col-form-label-lg"><b>Book ID</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "id" class="form-control form-control-lg" placeholder="ISDN">
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="author" class="col-sm-2 col-form-label col-form-label-lg"><b>Book Author</b></label>
    				<div class="col-sm-10">
      					<input type="text" class="form-control form-control-lg" name="author" placeholder="Book Author">
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg"><b>Book Title</b></label>
    				<div class="col-sm-10">
      					<input type = "text" class="form-control form-control-lg" placeholder="Book Title" name = "title">
    				</div>
  				</div>
  				<div class = "row">
  					 	<!--Insert button should put new file in the Database-->
        			<!--  <div class="col-sm-6 center-block">
            			<input type="submit" name = "oper" class="btn btn-primary center-block" value="Insert"/>
        			 </div>-->
    
        			 
        				<!--Edit button should link a page that Edit file-->
        			 <!-- <div class="btn-group col-sm-3">
            			<input type="submit" name = "oper" class="btn btn-primary col-sm-12" value="Edit"/>
        			</div> -->
        				<!--Delete button should link a page that deletes file-->
        			<!-- <div class="btn-group col-sm-3">
            			<input type="submit" name = "oper" class="btn btn-primary col-sm-12" value="Delete" />
        			</div> -->
        			
				</div>
				
				
			
				
				
				<div class="text-center">
				<div class = "btn-group-justified">
				<div class = "btn-group">
					<div class=" "> 
   						<input type="submit" name = "oper" class="btn btn-lg btn-primary" value="Insert"/>
       				</div>
				 </div>
				 </div>
				 </div>
						 
			</form>
		</div>
		<br />
		<br />
		
	</div>
	
	</div>
</body>
</html>