<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/bus/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.bus.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.bus.serialNumber" /></th>
				<th><spring:message code="msg.label.bus.model" /></th>
				<th><spring:message code="msg.label.bus.capacity" /></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${buss}" var="bus">
				<tr>
					<td>${bus.serialNumber}</td>
					<td>${bus.model}</td>
					<td>${bus.capacity}</td>
					
					<td><a href="<spring:url value='/admin/bus/edit/${bus.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.bus.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>