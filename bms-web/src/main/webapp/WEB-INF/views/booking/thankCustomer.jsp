<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-info"><spring:message code='msg.booking.title.thankyou'/></h1>
				<p><spring:message code='msg.booking.title.niceTrip'/></p>
				<p><spring:message code='msg.booking.title.cCode'/>: <span class="text-success" style="font-size: 25px; font-weight: bold">${booking.confirmationCode}</span></p>
				
				<h5 class="alert alert-info" role="alert"><spring:message code='msg.booking.title.pI'/></h5>
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
				
			<a href="<spring:url value="/trips" />" class="btn btn-primary"><spring:message code='msg.booking.title.trip'/></a>		
			</div>
		</div>
	</section>
</div>