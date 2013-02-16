$(document).ready(
		function() {
			// check name availability on focus lost
			$('#email').blur(function() {
				if ($('#email').val()) {
					checkAvailability();
				}
			});
			
		});

function checkAvailability() {
	$.getJSON("/user/availability", {
		email : $('#email').val()
	}, function(available) {
		if (available == false) {
			alert("Email already exists");
			$('#signup').attr("disabled", true);

		} else {
			$('#signup').attr("disabled", false);
		}

	});
}

function validatePass(p1, p2) {
	if (p1.value != p2.value || p1.value == '' || p2.value == '') {
		p2.setCustomValidity('Password does not match');
	} else {
		p2.setCustomValidity('');
	}
}

