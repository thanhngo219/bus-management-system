<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value='/admin/trip/edit/${trip.id}' var='actionURL'/>
<div class="container" style="width: 70%">

	<spring:url value='/trip' var='actionURL' />

	<form:form action="${actionURL}" method="post" modelAttribute="trip">
	   <fieldset>
	       <legend><spring:message code="msg.label.trip.edit" /></legend>
	       <input type="hidden" name="Id" value="${trip.id}" />
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="tripnr"><spring:message code="msg.label.trip.tripnr" /></label>          
	           <form:errors path="tripnr" cssClass="alert alert-danger" />
	           <form:input path="tripnr" cssClass="form-control"/>
	       </div>
	       <div class="form-group">
	           <label for="departureDate"><spring:message code="msg.label.trip.departureDate" /></label>
	           <form:input path="departureDate" type="date" cssClass="form-control"/>
	       </div>
	       
	       <div class="form-group" >           
	           <label for="departureTime"><spring:message code="msg.label.trip.departureTime" /></label>          
	           <form:input path="departureTime" type="time" cssClass="form-control"/>
	          
	       </div>
	       
	       <div class="form-group" >           
	           <label for="arrivalDate"><spring:message code="msg.label.trip.arrivalDate" /></label>          
	           <form:input path="arrivalDate" type="date" cssClass="form-control"/>
	       </div>
	       
	       <div class="form-group" >           
	           <label for="arrivalTime"><spring:message code="msg.label.trip.arrivalTime" /></label>          
	           <form:input path="arrivalTime" type="time" cssClass="form-control"/>
	       </div>
	       
	       <div class="form-group" >
	       		<label for="operator"><spring:message code="msg.label.trip.operator" /></label>
	       		<form:select path="operator.id">
	       			<form:option value="-1" label="Please select Operator"/>
	       			<form:options items="${operators}" itemValue="id" itemLabel="operatorName"/>
	       		</form:select>
	       		
	       </div>
	       
	       <div class="form-group" >
	       		<label for="bus"><spring:message code="msg.label.trip.bus" /></label>
	       		<form:select path="bus.id">
	       			<form:option value="-1" label="Please select Bus"/>
	       			<form:options items="${buss}" itemValue="id" itemLabel="serialModel" />
	       		</form:select>
	       </div>
	       
	       <div class="form-group" >
	       		<label for="departure"><spring:message code="msg.label.trip.departure" /></label>
	       		<form:select path="origin.id">
	       			<form:option value="-1" label="Please select Origin"/>
	       			<form:options items="${stations}" itemValue="id" itemLabel="stationDetail" />
	       		</form:select>
	       </div>
	       
	       <div class="form-group" >
	       		<label for="departure"><spring:message code="msg.label.trip.destination" /></label>
	       		<form:select path="destination.id">
	       			<form:option value="-1" label="Please select Origin"/>
	       			<form:options items="${stations}" itemValue="id" itemLabel="stationDetail" />
	       		</form:select>
	       </div>
	      
	       <div style="float:right;">
	            <a href="${pageContext.request.contextPath}/admin/trip" class="btn btn-outline-warning"><spring:message code="msg.label.trip.cancel" /></a>&nbsp;&nbsp;&nbsp;
	            <button id="btnEdit" type="submit" name="edit" class="btn btn-outline-success"><spring:message code="msg.label.trip.btnUpdate" /></button>
	        </div>
	    </fieldset>
	</form:form>
</div>
