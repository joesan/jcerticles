jQuery( function() {
	$('#occupation').change(function() {
	    var selected = $(this).val();
	    if(selected == 'Other'){
	      $('#otherOccupation').show();
	    }
	    else{
	      $('#otherOccupation').hide();
	    }
	}); 
})

$(document).ready(function() {
	$("#registerUserForm").validate({
		rules: {
			"userDetails.firstName": {
				required: true,
				minlength: 3
			},
			"userDetails.lastName": {
				required: true
			},
			"userDetails.email": {
				required: true,
				email: true
			},
			emailConfirm: {
				required: true,
				email: true,
				equalTo: "#email"
			},
			jCaptchaResponse: {
				required: true
			},			
                },
		messages: {
			"userDetails.firstName": {
				required: "Firstname is required",
				minlength: "Atleast 3 characters required"
			},
			"userDetails.lastName": "Lastname is required",
			"userDetails.email": "Valid email is required",
			emailConfirm: { 
				required: "Valid email is required",
				equalTo: "Email confirmation not correct"
			},
			jCaptchaResponse: "Please enter the text as above!"			
		}
	});
 })