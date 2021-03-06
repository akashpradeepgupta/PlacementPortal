<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>EDIT COMPANY INFO</title>
		
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800italic,800,700italic,700,600italic,400italic,600,300italic,300|Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<!-- Bootstrap -->
		<link href="css1/bootstrap.min.css" rel="stylesheet">
		<link href="css1/font-awesome.min.css" rel="stylesheet">


		<link href="css1/owl.carousel.css" rel="stylesheet">
		<link href="css1/owl.theme.css" rel="stylesheet">
		<link href="css1/owl.transitions.css" rel="stylesheet">

		<link href="css1/style.css" rel="stylesheet">
		<style type="text/css">
			input[type=text], select 
			{
   				width: 40%;
    			padding: 12px 20px;
    			margin: 8px 0;
   				display: inline-block;
    			border: 1px solid #ccc;
    			border-radius: 4px;
    			box-sizing: border-box;
			}
			input[type=password], select 
			{
   				width: 40%;
    			padding: 12px 20px;
    			margin: 8px 0;
   				display: inline-block;
    			border: 1px solid #ccc;
    			border-radius: 4px;
    			box-sizing: border-box;
			}
		</style>



		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		<script src="js/html5shiv.min.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body data-spy="scroll" data-target=".main-nav">

		<header class="st-navbar">
			<nav class="navbar navbar-default navbar-fixed-top clearfix" role="navigation">
				<div class="container"><!-- Brand and toggle get grouped for better mobile display -->
					<img src="photos1/logo.png" alt="" class="img-responsive"  width="200" height="400"></a>
					</div>
				
				</div>
			</nav>
		</header>
		
		<section class="home" id="home" data-stellar-background-ratio="0.4">
			<div>
			<div class="container">
				<div class="row,col-md-12,st-home-unit,hero-txt">
					<!--<div class="col-md-12">
						<div class="st-home-unit">
							<div class="hero-txt">
																<p class="hero-sub-title">We Provide Hight Quality Bootstrap Template</p> 
								<a href="#" class="btn btn-default btn-lg left-btn">Purchase Now</a> -->
								<div class="s" align="center">
<h1 style="color: white"> EDIT DETAILS </h1>
<form method="get" action="TechCompanyServlet">
	
	<input type ="text" placeholder="CIN" name="cIN" required>
	<br/><br/>
	<h5 style="color: white">Select What You Want to Edit<h5><select name="edit">
		<option>cname</option>
		<option>cpiCriteria</option>
		<option>city</option>
		<option>visitDate</option>
		<option>salary</option>
		<option>cEmailId</option>
		<option>requirements</option>
		<option>branch</option>
	</select>
	<br/><br/><br><br>
	
	<input type ="text" placeholder="VALUE" name="value" class="e" required>
	<br/><br/>
	<input type="submit" class="btn btn-main btn-lg" value="Submit">
</form>
</div>
							</div>

				</div>		
			</div>
			<div class="mouse-icon"><div class="wheel"></div></div>
		</section>

		

		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.easing.min.js"></script>
		<script src="js/jquery.stellar.js"></script>
		<script src="js/jquery.appear.js"></script>
		<script src="js/jquery.nicescroll.min.js"></script>
		<script src="js/jquery.countTo.js"></script>
		<script src="js/jquery.shuffle.modernizr.js"></script>
		<script src="js/jquery.shuffle.js"></script>
		<script src="js/owl.carousel.js"></script>
		<script src="js/jquery.ajaxchimp.min.js"></script>
		<script src="js/script.js"></script>
	</body>
</html>