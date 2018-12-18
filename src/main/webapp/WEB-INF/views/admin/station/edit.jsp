<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value='/admin/station/edit/${station.id}' var='actionURL'/>
<div class="container" style="width: 70%">
	<form:form action="${actionURL}" method="post" modelAttribute="station">
	   <fieldset>
	       <legend><spring:message code="msg.label.station.edit" /></legend>
	       <form:errors path="*" cssStyle="color:red;" />
	       <input type="hidden" name="Id" value="${station.id}" />
	
	       <div class="form-group" >           
	           <label for="stationnr"><spring:message code="msg.label.station.code" /></label>          
	           <form:input path="stationCode" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="airtportName"><spring:message code="msg.label.station.name" /></label>
	           <form:input path="stationName" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="city"><spring:message code="msg.label.station.city" /></label>
	           <form:input path="city" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="country"><spring:message code="msg.label.station.country" /></label>
	           <form:input path="country" cssClass="form-control"/>
	       </div>
	      
	       <div style="float:right;">
	            <a href="${pageContext.request.contextPath}/admin/station" class="btn btn-outline-warning"><spring:message code="msg.label.cancel" /></a>&nbsp;&nbsp;&nbsp;
	            <button id="btnEdit" type="submit" name="edit" class="btn btn-outline-success"><spring:message code="msg.label.edit" /></button>
	        </div>
	    </fieldset>
	</form:form>
</div>
