$(document).ready(
		function() {
			// check name availability on focus lost
			$('#username').blur(function() {
				if ($('#username').val()) {
					checkAvailability();
				}
			});
			
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

