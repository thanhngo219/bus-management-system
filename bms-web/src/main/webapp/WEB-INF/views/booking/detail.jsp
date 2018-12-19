<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 60%">	
	<div class="jumbotron" style="padding-top: 15px">				
		<h2 class="alert alert-primary text-center"><spring:message code="msg.mbking.title.bookingInfo" /></h2>		
		<h5 class="alert alert-info" role="alert"><spring:message code="msg.mbking.title.passenger" /></h5>		

		<table class="table table-borderless">			  
		  <tbody>
		    <tr>
		      <th scope="row" class="w-50"><spring:message code="msg.booking.lbl.fN" /></th>
		      <td>${booking.passenger.firstName}</td>			      
		    </tr>
		    <tr>
		      <th scope="row"><spring:message code="msg.booking.lbl.lN" /></th>
		      <td>${booking.passenger.lastName}</td>		      
		    </tr>
		    <tr>
		      <th scope="row"><spring:message code="msg.booking.lbl.email" /></th>
		      <td colspan="2">${booking.passenger.email}</td>		     
		    </tr>
		  </tbody>
		</table>
	
		<h5 class="alert alert-info" role="alert"><spring:message code="msg.mbking.title.trip" /></h5>
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
		
	</div>	
</div>