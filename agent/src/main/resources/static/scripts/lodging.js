var t1 = "";
$(document).ready(function(){
	
	var mail = localStorage.getItem('user');
	var tt = window.location.protocol + '//' + window.location.hostname+':8080';

	$.get({
		url: tt + '/api/authentication/' + mail,
		success: function(data){

			if(data.userType != "AGENT"){	//doesn't allow non agents to log in and access home
				localStorage.removeItem('user');
				localStorage.removeItem('token');
				
				window.location.replace('/login.html'); 
			} else {
				getLodging();
			}
		}, error: function(data){
			
			console.log('shouldn\'t show up except if back-end is down');
			
		}
			
	});

	
});

function getLodging(){
	var tgt = window.location.href.split("id=")[1];
	$.get({
		url: "/lodging/"+tgt,
		success: function(data){
			var features = "";
			data.featureType.forEach(function(feature){
				features+=", "+feature.name;
			});
			
			$("#top").html('&nbsp;&nbsp;&nbsp;<button onclick="logout()" >Logout</button>&nbsp;&nbsp;&nbsp;&nbsp;');
			
			$("#lodgingData").html('<label>Owner:&nbsp;</label>' + data.agent.name + " " + data.agent.lastName
					+'<br><label>Name:&nbsp;</label>' + data.name 
					+'<br><label>Address:&nbsp;</label>' + data.address 
					+'<br><label>Description:&nbsp;</label>' + data.description 
					+'<br><label>Category:&nbsp;</label>' + data.category 
					+'<br><label>Rating:&nbsp;</label>' + data.rating 
					+'<br><label>Number of beds:&nbsp;</label>' + data.numberOfBeds 
					+'<br><label>Type:&nbsp;</label>' + data.lodgingType.name 
					+'<br><label>Food Service:&nbsp;</label>' + data.foodServiceType.name 
					+'<br><label>Features:&nbsp;</label>' + features.substring(2)
					+'<br>Images:<div class="row"><br></div>'
					+'<br>'
			);
			$("#leftButton").html('<button id="priceRange">Set price for timeframe</button>');
			$("#rightButton").html('<button id="addReservation">Add reservation</button>');
			data.imagePaths.forEach(function(path){
				$(".row").append('<div class="column"><br><a href="' + path + '" target="_blank"><img src="' + path + '" onerror="this.src=\"' + path + '\"" width="224" height="96"></a></div>')
			});
			
		}
		
	});
	
	$.get({
		url:"/price/"+tgt,
		success: function(d){
			for(var i = 0; i < d.length; i++){
				var sD = new Date(d[i].fromDate);
				var eD = new Date(d[i].toDate);
				$("#timeFrame").append('<tr><td>'+sD.toString().substring(4,15)+'</td><td>'+eD.toString().substring(4,15)+'</td><td align="right">'+d[i].pricePerDay+'</td>'
						+'<td><a href="/price/'+d[i].id+'" class="delete"><img src="img/remove.gif"/></a></td></tr>');
			}
		}
	});
	
	$.get({
		url: "/reservation/"+tgt,
		success: function(x){
			for(var i = 0; i < x.length; i++){
				var sD = new Date(x[i].fromDate);
				var eD = new Date(x[i].toDate);
				var status = (x[i].approved) ? '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/checkmark.png" width="16" height="16">' : '<a class="approve" href="/reservation/'+x[i].id+'">Approve</a>';
				$("#reservationsTable").append('<tr><td>'+x[i].user.email+'</td><td>'+sD.toString().substring(4,15)	
						+'</td><td>'+eD.toString().substring(4,15)+'</td><td><a class="msg" href="/messages/'+x[i].id+'">check</a></td><td>'+status+'</td>'
						+'<td><a class="delete" href="/reservation/'+x[i].id+'"><img src="img/remove.gif"></a></td></tr>');
			}
		}
	});
	
	
	
}

$(document).on('click','.approve',function(e){
	e.preventDefault();
	var url = $(this).attr('href');
	
	var obj = $(this).closest('td');
	
	$.post({
		url: url,
		success: function(data){
			console.log('yes');
			$(obj).html('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/checkmark.png" width="16" height="16">');
		}
	});
	
});

var resID = null;
$(document).on("click", ".msg", function(e){
	e.preventDefault();
	var url = $(this).attr("href");
	resID = url.substring(10);
	$("#messagesHere").empty();
	
	$.get({
		url: url,
		success: function(data){
			for(var i = 0; i < data.length; i++){
				var ft = (data[i].userSent == true) ? "From" : "To";
				$("#messagesHere").append('<div><p>'+ft+' '+data[i].user.name+' ['+data[i].user.email+']: '+data[i].content+'<p><div><hr>');
			}
		}
	})
	$("#responseBox").html('<div><textarea id="msgResponse" rows="4" cols="56"></textarea></div>');
	
	$("#messageModal").modal();
})

$(document).on("click", ".delete", function(e){
	e.preventDefault();
	var confirmed = confirm("Are you sure?");
	if (confirmed){
		var url = $(this).attr("href");
		tr_parent = $(this).closest("tr");
		$.ajax({
			type: "DELETE",
			url: url,
			success: function(){
				tr_parent.remove();
			}
		});

	}
});



var lodging = '';
$(document).on('click','#priceRange',function(e){
	e.preventDefault();
	$('#addModal').modal();
});


$(document).on('click','#addReservation',function(e){
	e.preventDefault();
	$('#addReservationModal').modal();
});

$(document).on('click',"#sendMessage", function(e){
	e.preventDefault();
	var content = $("#msgResponse").val();
	var reservation = resID;
	
	if(content === ""){
		$("#messageModal").modal("toggle");
		return;
	}
	
	$.post({
		url: "/messages",
		contentType: "application/json",
        dataType: "text",
		data: JSON.stringify({
			"content": content,
			"reservation": reservation
		}),
		success: function(data){
			$("#messageModal").modal("toggle");
			
		}
	});
	
})

$(document).on('click',"#addRes", function(e){
	e.preventDefault();
	var email = $("#reservationEmail").val();
	var dateFrom = $("#dateReservationFrom").val();
	var dateTo = $("#dateReservationTo").val();
	var lodging = window.location.href.split("id=")[1];
	
	if(new Date(dateFrom) > new Date(dateTo)){
		alert('start date can\'t be behind end date');
		return;
	}
	
	$.post({
		url:"/reservation",
		contentType: "application/json",
        dataType: "text",
		data: JSON.stringify({
			"user": email,
			"fromDate": dateFrom,
			"toDate": dateTo,
			"lodging": lodging,
			"approved": false
		}),
		success: function(data){
			$("#addReservationModal").modal('toggle');
			$("#timeFrame").find("tr:gt(0)").remove();
			$("#reservationsTable").find("tr:gt(0)").remove();
			getLodging();
			
		}
	})
	
});

$(document).on('click',"#addData", function(e){
	e.preventDefault();
	var price = $("#priceP").val();
	var fromDate = $('#dateFromP').val();
	var toDate = $('#dateToP').val();
	var lodging = window.location.href.split("id=")[1];
	
	if(new Date(fromDate) > new Date(toDate)){
		alert('start date can\'t be behind end date');
		return;
	}
	
	$.post({
		url:"/price",
		contentType: "application/json",
        dataType: "text",
		data: JSON.stringify({
			"pricePerDay": price,
			"fromDate": fromDate,
			"toDate": toDate,
			"lodging": lodging
		}),
		success: function(dataP){
			$("#addModal").modal('toggle');
			$("#timeFrame").find("tr:gt(0)").remove();
			$("#reservationsTable").find("tr:gt(0)").remove();
			getLodging();
		}
	})
	
})