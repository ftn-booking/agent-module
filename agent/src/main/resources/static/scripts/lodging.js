var t1 = "";
$(document).ready(function(){
	
	var mail = Cookies.get('user');
	
	$.get({
		url: 'https://localhost:8080/api/authentication/'+mail,
		success: function(data){

			if(data.userType != "AGENT"){	//doesn't allow non agents to log in and access home
				Cookies.remove('token', {path: '/'});
				Cookies.remove('user', {path: '/'});
				Cookies.remove('agent', {path: '/'});
				window.location.replace('/login.html'); 
			} else {
				Cookies.set('agent', data, {expires: 10, path: '/', secure: true})
				//$('p').append(data.name);
				t1=data.id;
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
					+'<br><button id="priceRange">Set price for timeframe</button>'
			);
			data.imagePaths.forEach(function(path){
				$(".row").append('<div class="column"><br><a href="' + path + '" target="_blank"><img src="' + path + '" width="96" height="96"></a></div>')
			});
			
		}
		
	});
	
	$.get({
		url:"/price/"+tgt,
		success: function(d){
			for(var i = 0; i < d.length; i++){
				var sD = new Date(d[i].fromDate);
				var eD = new Date(d[i].toDate);
				$("#timeFrame").append('<tr><td>'+sD.toString().substring(4,15)+'</td><td>'+eD.toString().substring(4,15)+'</td><td align="right">'+d[i].pricePerDay+'</td></tr>');
			}
		}
	});
	
}

$(document).on('click','#priceRange',function(e){
	e.preventDefault();
	$('#addModal').modal();
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
			$("#timeFrame tbody tr").each(function(){
				this.parentNode.removeChild(this);
			})
			getLodging();
			console.log(dataP);
		}
	})
	
})