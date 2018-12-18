<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		
<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/trip/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.trip.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
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
					<td>${trip.origin.stationCode} - ${trip.origin.city}</td>
					<td>${trip.departureDate}</td>
					<td>${trip.departureTime}</td>
					<td>${trip.destination.stationCode} - ${trip.destination.city}</td>
					<td>${trip.arrivalDate}</td>
					<td>${trip.arrivalTime}</td>
					<td><a href="<spring:url value='/admin/trip/edit/${trip.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.trip.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>