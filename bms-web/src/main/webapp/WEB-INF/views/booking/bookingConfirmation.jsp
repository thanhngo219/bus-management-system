<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container" style="width: 60%">	
	<div class="jumbotron" style="padding-top: 15px">				
		<h2 class="alert alert-primary text-center"><spring:message code='msg.booking.title.bC'/></h2>		
		<h5 class="alert alert-info" role="alert"><spring:message code='msg.booking.title.pI'/></h5>
		
		<form:form modelAttribute="order" class="form-horizontal">
			<table class="table table-borderless">			  
			  <tbody>
			    <tr>
			      <th scope="row" class="w-50"><spring:message code='msg.booking.lbl.fN'/></th>
			      <td>${booking.passenger.firstName}</td>			      
			    </tr>
			    <tr>
			      <th scope="row"><spring:message code='msg.booking.lbl.lN'/></th>
			      <td>${booking.passenger.lastName}</td>		      
			    </tr>
			    <tr>
			      <th scope="row"><spring:message code='msg.booking.lbl.email'/></th>
			      <td colspan="2">${booking.passenger.email}</td>		     
			    </tr>
			  </tbody>
			</table>
		
			<h5 class="alert alert-info" role="alert"><spring:message code='msg.booking.title.fI'/></h5>
			<table class="table table-borderless">			  
			  <tbody>
			    <tr>
			      <th scope="row"><spring:message code="msg.label.trip.tripnr" /></th>
			      <td>${booking.trip.tripnr}</td>			      
			    </tr>	
			    	
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.trip.departureDate" /></th>
			      <td>${booking.trip.departureDate}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.trip.departureTime" /></th>
			      <td>${booking.trip.departureTime}</td>			      
			    </tr>	  
			    
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.trip.arrivalDate" /></th>
			      <td>${booking.trip.arrivalDate}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row" class="w-50"><spring:message code="msg.label.trip.arrivalTime" /></th>
			      <td>${booking.trip.arrivalTime}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row" class="w-50"><spring:message code="msg.label.trip.operator" /></th>
			      <td>${booking.trip.operator.operatorName}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.trip.departure" /></th>
			      <td>${booking.trip.origin.stationDetail}</td>			      
			    </tr>
			    
		     	<tr>
	      		  <th scope="row"><spring:message code="msg.label.trip.destination" /></th>
			      <td>${booking.trip.destination.stationDetail}</td>			      
			    </tr>			    
			     
			  </tbody>
			</table>
			
			<p>&nbsp;</p>
			
			<button id="btnCancel" class="btn btn-default" name="_eventId_cancel"><spring:message code='msg.booking.btn.cancel'/></button>
			
			<button id="back" class="btn btn-warning" name="_eventId_backToPassengerInfo"><spring:message code='msg.booking.btn.back'/></button>
	
			<button type="submit" class="btn btn-success float-right" name="_eventId_bookingConfirmed"><spring:message code='msg.booking.btn.confirm'/></button>
			
		</form:form>		
	</div>	
</div>