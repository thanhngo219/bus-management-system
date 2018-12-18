<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/operator/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.operator.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.operator.operatorName" /></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${operators}" var="operator">
				<tr>
					<td>${operator.operatorName}</td>
					
					<td><a href="<spring:url value='/admin/operator/edit/${operator.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.operator.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>