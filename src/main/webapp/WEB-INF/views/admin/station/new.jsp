<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<form:form action="new" method="post" modelAttribute="station">
	   <fieldset>
	       <legend><spring:message code="msg.label.station.addNew" /></legend>
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="stationnr"><spring:message code="msg.label.station.stationCode" /></label>          
	           <form:input path="stationCode" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="stationName"><spring:message code="msg.label.station.stationName" /></label>
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
	            <a href="${pageContext.request.contextPath}/admin/station" class="btn btn-outline-warning"><spring:message code="msg.label.trip.cancel" /></a>&nbsp;&nbsp;&nbsp;
	            <button id="btnNew" type="submit" name="edit" class="btn btn-outline-success"><spring:message code="msg.label.btnNew" /></button>
	        </div>
	    </fieldset>
	</form:form>
</div>
