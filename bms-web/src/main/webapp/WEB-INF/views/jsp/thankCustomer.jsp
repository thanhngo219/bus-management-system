<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="author" content="Aha">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<spring:url value='/resource/css/masterlayout.css' />"/>

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<spring:url value='/' />">3T Bus Management System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">            
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='/' />">|&nbsp; <spring:message code='msg.label.home'/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='/mybooking' />">|&nbsp; <spring:message code='msg.label.mybooking'/></a>
            </li>
        </ul>      
    </div>
</nav>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div class="container">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-info"><spring:message code='msg.flow.title.thankyou'/></h1>
				<p><spring:message code='msg.flow.title.niceTrip'/></p>
				<p><spring:message code='msg.flow.title.cCode'/>: <span class="text-success" style="font-size: 25px; font-weight: bold">${booking.confirmationCode}</span></p>
				<a href="<spring:url value="/trips" />" class="btn btn-primary"><spring:message code='msg.flow.title.trip'/></a>			
			</div>
		</div>
	</section>
</div>
<!-- /.container -->
<footer id="footerContainer" class="footer">
	<div class="container">
		<span class="text-muted">Prof. Joe Bruen ::: 3T Group
			(CS544)</span><span style="float: right;" class="text-muted">&copy
			December 2018</span>
	</div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

</body>
</html>
