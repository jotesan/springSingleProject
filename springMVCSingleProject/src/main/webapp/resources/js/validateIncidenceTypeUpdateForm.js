var validator = $("#updateIncidenceTypeForm").validate({
	// Define the rules of the form
	rules : {
		name : {
			required : true,
			maxlength : 50, 
		},
		description : {
			required : true,
			maxlength : 100
		}
	},
	// Define the messages for the rules
	messages : {
		name : {
			required : "Enter a name",
			maxlength : $.validator.format("Enter less than {0} characters"),
		},
		description : {
			required : "Provide a description",
			maxlength : $.validator.format("Enter less than {0} characters"),
		}
	},
	errorPlacement : function(error, element) {
		error.insertAfter(element);
	},
	submitHandler : function(form) {
		form.submit();
	}
});