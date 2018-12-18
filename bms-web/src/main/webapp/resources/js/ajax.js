// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 
var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function saveBus(){
   	var dataToSend = JSON.stringify({
   		id: '0',
   		serialNumber: $("#serialNumber").val(),
		model: $("#model").val(),
		capacity: $("#capacity").val(),
   	});
   	var csrfParam = $("#csrfParam").val();
   	var csrfValue = $("#csrfValue").val();
   	$.ajax({
		url: contextRoot + '/admin/bus/add?' + csrfParam + '=' + csrfValue,
		type: 'POST',
		dataType: "json",
 		data:dataToSend,
 		contentType: 'application/json',
		success: function(bus){
			console.log('result', bus);
			$('#errors').html("");
	 	    $('#result').show();
	 	    setTimeout(function() {
	 	    	$("#result").hide();
	 	    }, 2000);
		},
		error: function(errorObject) {
			console.log('errorObject', errorObject);
			$('#result').show();
			$('#success').hide();
			$('#errors').html("");
			if (errorObject.responseJSON.errorType == "ValidationError") {
				var errorList = errorObject.responseJSON.errors;
 	 	        $.each(errorList,  function(i, error) {			   
 		    		$("#errors").append( error.message + '<br>');
		    	});
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
			
			setTimeout(function() {
	 	    	$("#result").hide();
	 	    }, 2000);
 		}
	});
}


 