<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.serviceImpl.Stats"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!-- 
        Awesome Template
        http://www.templatemo.com/preview/templatemo_450_awesome
        -->
        <title>STATISTICS</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/templatemo-style.css">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.singlePageNav.min.js"></script>
        <script src="js/typed.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/custom.js"></script>
        <style type="text/css">
            .af123
            {
                align-items: right;
            }
            .a11
            {
            	font-color:black;
            }
        </style>
    </head>
    <body id="top">

        <!-- start preloader -->
        <div class="preloader">
            <div class="sk-spinner sk-spinner-wave">
                <div class="sk-rect1"></div>
                <div class="sk-rect2"></div>
                <div class="sk-rect3"></div>
                <div class="sk-rect4"></div>
                <div class="sk-rect5"></div>
            </div>
        </div>
        <!-- end preloader -->

        <!-- start header -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-4 col-xs-12">
                        <p><i class="fa fa-phone"></i><span> Contact</span>020-24364560</p>
                    </div>
                    <div class="col-md-3 col-sm-4 col-xs-12">
                        <p><i class="fa fa-envelope-o"></i><span> Email</span><a href="#">tpo@bvucoep.edu.in</a></p>
                    </div>
                    <div class="col-md-5 col-sm-4 col-xs-12">
                        <ul class="social-icon">
                            <li><span>Check Us On</span></li>
                            <li><a href="#" class="fa fa-facebook"></a></li>
                            <li><a href="#" class="fa fa-instagram"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <!-- end header -->

        <!-- start navigation -->
        <nav class="navbar navbar-default templatemo-nav" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<img src="logo.png" height="100">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <img src="BVUCOEP-LOGO.png" id="af123">
                </div>
            </div>
        </nav>
        <!-- end navigation -->

        <!-- start home -->
        <section id="home">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <h2 class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">Placement <span>Statistics:-</span></h2><center>
<%
try{
double a[]=new double[7];
Stats S=new Stats();
a=S.placementstats();%>
                        <h3 style="color:#33FFFC" class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">TOTAL STUDENTS:<%  out.println(a[0]+"<br><br>");%></h3>
                        <h3 style="color:#33FFFC" class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">PLACED STUDENTS:<%  out.println(a[1]+"<br><br>");%></h3>
                        <h3 style="color:#33FFFC" class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">UNPLACED STUDENS:<%  out.println(a[2]+"<br><br>");%></h3>
                        <h3 style="color:#33FFFC" class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">AVERAGE PACKAGE:<%  out.println(a[4]+"<br><br>");%></h3>
                        <h3 style="color:#33FFFC" class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">MINIMUM PACKAGE:<%  out.println(a[5]+"<br><br>");%></h3>
                        <h3 style="color:#33FFFC" class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">MAXIMUM PACKAGE:<%  out.println(a[6]+"<br><br>");}
catch(Exception e){
	
}
%></h3></center>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>