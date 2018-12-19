<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<form:form modelAttribute="booking.passenger" class="form-horizontal">
				<fieldset>
					<legend>
						<spring:message code='msg.booking.title.pDetail' />
					</legend>
					
					<form:errors path="*" cssStyle="color:red;" />

					<div class="form-group">
						<label for="firstName"><spring:message
								code='msg.booking.lbl.fN' /></label>
<%-- 						<form:errors path="passenger.firstName" --%>
<%-- 							cssClass="alert alert-danger" /> --%>
						<form:input path="firstName" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="lastName"><spring:message
								code='msg.booking.lbl.lN' /></label>
<%-- 						<form:errors path="passenger.lastName" --%>
<%-- 							cssClass="alert alert-danger" /> --%>
						<form:input path="lastName" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="email"><spring:message
								code='msg.booking.lbl.email' /></label>
<%-- 						<form:errors path="passenger.email" cssClass="alert alert-danger" /> --%>
						<form:input path="email" cssClass="form-control" />
					</div>

					<div class="form-group">
						<button id="btnCancel" class="btn btn-default"
							name="cancelABooking">
							<spring:message code='msg.booking.btn.cancel' />
						</button>
						<input type="submit" id="btnAdd"
							class="btn btn-primary float-right"
							value="<spring:message code='msg.booking.btn.next'/>"
							name="bookATrip" />
					</div>

				</fieldset>
			</form:form>
		</div>
	</div>
	<!-- /.row -->
</div>