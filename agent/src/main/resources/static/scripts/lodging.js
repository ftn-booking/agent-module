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
				$('p').append(data.name);
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
			console.log(data);
			data.featureType.forEach(function(feature){
				features+=", "+feature.name;
			});
			
			$("#lodgingData").html('<label>Owner: </label>' + data.agent.name + " " + data.agent.lastName
					+'<br><label>Name: </label>' + data.name 
					+'<br><label>Address: </label>' + data.address 
					+'<br><label>Description: </label>' + data.description 
					+'<br><label>Category: </label>' + data.category 
					+'<br><label>Rating: </label>' + data.rating 
					+'<br><label>Number of beds: </label>' + data.numberOfBeds 
					+'<br><label>Type: </label>' + data.lodgingType.name 
					+'<br><label>Food Service: </label>' + data.foodServiceType.name 
					+'<br><label>Features: </label>' + features.substring(2)
					+'<br><div class="row"></div>'
			);
			data.imagePaths.forEach(function(path){
				$(".row").append('<div class="column"><br><a href="' + path + '" target="_blank"><img src="' + path + '" width="96" height="96"></a></div>')
			});
			
		}
		
	});
}