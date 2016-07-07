$(document).ready(function() {
	$("#searchbtn").click(function() {
		var zipcode = $("#zipcode").val();
		if(zipcode.length != 5 || !$.isNumeric(zipcode)){
			$("#error").html("Zipcode should be number like 07029");
		} else {
			$("#error").html("");
			$("#weatherinfo").html("");
			var head = "<tr><th>Date</th><th>Description</th><th>Morning low temperature</th>" +
						"<th>Daytime high temperature</th></tr>";
			$.ajax({
				url : "rest/weather/" + zipcode
			}).then(function(data) {
				var i, wea;
				var loc = "<label>City:</label>&nbsp" + data.city + "&nbsp&nbsp&nbsp<label>State:</label>&nbsp" + data.state;
				$("#location").html(loc); 
				$("#weatherinfo").append(head);
				for(i = 0; i < data.weathers.length; i++) {
					wea = "<tr><td>" + data.weathers[i].date + "</td>" + 
					"<td>" + data.weathers[i].desc + "</td>" + 
					"<td>" + data.weathers[i].low + "°</td><td>" + data.weathers[i].high + "°</td></tr>";
					$("#weatherinfo").append(wea);
				}
				
			});
		}
		
		
	});
});