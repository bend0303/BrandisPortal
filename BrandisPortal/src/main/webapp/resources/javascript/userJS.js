$(document).ready(
		function() {
			// check name availability on focus lost
			$('#username').blur(function() {
				if ($('#username').val()) {
					checkAvailability();
				}
			});
//			// ###########################Add form validation###########################
//			$('#registerform').submit(
//					function() {
//						var i, validate_fields = [ 'username', 'password' ], // fields
//																				// to
//																				// validate
//						invalid_fields = []; // store of empty fields
//						for (i in validate_fields) {
//							// check if field is empty
//							if ($('#' + validate_fields[i]).val().replace(
//									/(^\s+|\s+$)/g, '') === '') {
//								invalid_fields.push(validate_fields[i]);
//							}
//						}
//						if (invalid_fields.length) {
//							alert('The following fields were empty: '
//									+ invalid_fields.join(', '));
//							return false; // cancel the form submit
//						}
//						return true;
//		   // ################################### End of form validation ##################
//					});
		});

function checkAvailability() {
	$.getJSON("/user/availability", {
		username : $('#username').val()
	}, function(available) {
		if (available == false) {
			alert("Username already exists aaaaa");
			$('#submit').attr("disabled", true);

		} else {
			$('#submit').attr("disabled", false);
		}

	});
}

// #########################Form ################################
// text fields
// make form display yellow color when mouse is focused on item

// password fileds
$('input[type="password"]').focus(function() {
	$(this).addClass("focus");
});// end of adding color
// remove after focus is gone
$('input[type="password"]').blur(function() {
	$(this).removeClass("focus");
});// end of removing color
