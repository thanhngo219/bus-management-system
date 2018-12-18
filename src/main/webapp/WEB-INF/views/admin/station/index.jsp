<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/station/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.station.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.station.code" /></th>
				<th><spring:message code="msg.label.station.stationName" /></th>
				<th><spring:message code="msg.label.station.city" /></th>
				<th><spring:message code="msg.label.station.country" /></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stations}" var="station">
				<tr>
					<td>${station.stationCode}</td>
					<td>${station.stationName}</td>
					<td>${station.city}</td>
					<td>${station.country}</td>
					
					<td><a href="<spring:url value='/admin/station/edit/${station.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.station.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>