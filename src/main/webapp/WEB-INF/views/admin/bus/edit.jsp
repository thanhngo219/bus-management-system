<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value='/admin/bus/edit/${bus.id}' var='actionURL'/>
<div class="container" style="width: 70%">
	<form:form action="${actionURL}" method="post" modelAttribute="bus">
	   <fieldset>
	       <legend><spring:message code="msg.label.bus.edit" /></legend>
	       <form:errors path="*" cssStyle="color:red;" />
	       <input type="hidden" name="Id" value="${bus.id}" />
	
	       <div class="form-group" >           
	           <label for="stationnr"><spring:message code="msg.label.bus.serialNumber" /></label>          
	           <form:input path="serialNumber" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="model"><spring:message code="msg.label.bus.model" /></label>
	           <form:input path="model" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="capacity"><spring:message code="msg.label.bus.capacity" /></label>
	           <form:input path="capacity" cssClass="form-control"/>
	       </div>
	      
	       <div style="float:right;">
	            <a href="${pageContext.request.contextPath}/admin/bus" class="btn btn-outline-warning">Cancel</a>&nbsp;&nbsp;&nbsp;
	            <button id="btnEdit" type="submit" name="edit" class="btn btn-outline-success">Update</button>
	        </div>
	    </fieldset>
	</form:form>
</div>
