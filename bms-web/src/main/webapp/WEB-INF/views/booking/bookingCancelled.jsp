<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger"><spring:message code='msg.booking.title.cancel'/></h1>
				<p><spring:message code='msg.booking.ann.cancel'/></p>
				<a href="<spring:url value="/trips" />" class="btn btn-primary"><spring:message code='msg.booking.title.trip'/></a>
			</div>
		</div>
	</section>
</div>