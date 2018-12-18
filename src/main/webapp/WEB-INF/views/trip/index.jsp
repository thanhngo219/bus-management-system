<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.trip.name" /></th>
				<th><spring:message code="msg.label.trip.departureCity" /></th>
				<th><spring:message code="msg.label.trip.departureDate" /></th>
				<th><spring:message code="msg.label.trip.departureTime" /></th>
				<th><spring:message code="msg.label.trip.arrivalCity" /></th>
				<th><spring:message code="msg.label.trip.arrivalDate" /></th>
				<th><spring:message code="msg.label.trip.arrivalTime" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trips}" var="trip">
				<tr>
					<td>${trip.tripnr}</td>
					<td>${trip.origin.airportCode} - ${trip.origin.city}</td>
					<td>${trip.departureDate}</td>
					<td>${trip.departureTime}</td>
					<td>${trip.destination.airportCode} - ${trip.destination.city}</td>
					<td>${trip.arrivalDate}</td>
					<td>${trip.arrivalTime}</td>
					<td><a href="<spring:url value='/booking?tripId=${trip.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.trip.book" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>