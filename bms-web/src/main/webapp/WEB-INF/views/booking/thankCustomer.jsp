<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-info"><spring:message code='msg.booking.title.thankyou'/></h1>
				<p><spring:message code='msg.booking.title.niceTrip'/></p>
				<p><spring:message code='msg.booking.title.cCode'/>: <span class="text-success" style="font-size: 25px; font-weight: bold">${booking.confirmationCode}</span></p>
				<a href="<spring:url value="/trips" />" class="btn btn-primary"><spring:message code='msg.booking.title.trip'/></a>			
			</div>
		</div>
	</section>
</div>