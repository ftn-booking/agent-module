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
				home();
			}
		}, error: function(data){
			
			console.log('shouldn\'t show up except if back-end is down');
			
		}
			
	});
	
});

function home(){
	$("#middle").append('<button type="button" class="btn btn-primary" onclick="addL()">'
			+'Add Lodging</button>'
			+'<br><table id="LodgingTable" class="table"></table>');
			$("#LodgingTable").html('<tr class="header"><th>Name</th><th>View</th><th>Edit</th></tr>');
			
			$.get({
				url:"/lodging/agent/" + t1,

				success: function(data2){
					for(var i = 0; i < data2.length; i++){
						$("#LodgingTable").append('<tr>'
						+'<td class="name first">'+data2[i].name+'</td>'
						+'<td><a class="delete" href="//'+data2[i].id+'"><img src="images/remove.gif"/></a>'
						+'<td><a class="delete" href="//'+data2[i].id+'"><img src="images/remove.gif"/></a>'
						+'</tr>');
					}
				}
			});
}


function addL(){
	$("#middle").empty();
	$("#middle").html('<form id="addForm"></form>');
	$("#addForm").html('<table><tr><div class="dropzone">'
	        +'<div class="info"></div>'
	        +'</div></tr><br>'
	        +'<script type="text/javascript" src="scripts/imgur.js"></script>'
	        +'<script type="text/javascript" src="scripts/upload.js"></script>'
			+'<tr><td><label>Name: </label></td><td><input type="text" class="form-control" id="lodgingName" placeholder="Name"></td></tr>'
			+'<tr><td><label>Address: </label></td><td><input type="text" class="form-control" id="lodgingAddress" placeholder="Address"></td></tr>'
			+'<tr><td><label>Description: </label></td><td><input type="text" class="form-control" id="lodgingDescription" placeholder="Description"></td></tr>'
			+'<tr><td><label>Number of beds: </label></td><td><input type="number" id="numberOfBeds" min="1" placeholder="Min: 1"></td></tr>'
			+'<tr><td><label>Type: </label></td><td><select id="lodgingType">'
			+'</select></td></tr>'
			+'<tr><td><label>Meal: </label></td><td><select id="lodgingMeal">'
			+'</select></td></tr>');

	var lodgingTypes = "";
	$.get({
		url:"/lodging/getLodgingTypes",
		success: function(data){
			for(var i = 0; i < data.length; i++)
				lodgingTypes+='<option value="'+data[i].id+'">'+data[i].name+'</option>'

			$("#lodgingType").html(lodgingTypes);	
		}
	});
	
	var featureTypes = "";
	$.get({
		url:"/lodging/getFeatureTypes",
		success: function(data){
			for(var i = 0; i < data.length; i++)
				featureTypes+='<tr><td><label>'+data[i].name+': </label></td><td><input type="checkbox" name="'+data[i].id+'" value="'+data[i].name+'"></rd></tr>'
			$("#addForm").append(featureTypes);
			$("#addForm").append('<tr><td><input type="submit" value="Submit"></td><td></td></tr>'
					+'</table>');

		}
	});
	
	var foodServiceTypes = "";
	$.get({
		url:"/lodging/getFoodServiceTypes",
		success: function(data){
			for(var i = 0; i < data.length; i++)
				foodServiceTypes+='<option value="'+data[i].id+'">'+data[i].name+'</option>'
				
				$("#lodgingMeal").html(foodServiceTypes);	
				
		}
	});
				
}


$(document).on("submit","#addForm",function(e){
	e.preventDefault();
	var name = $('#lodgingName').val();
	var addr = $("#lodgingAddress").val();
	var description = $("#lodgingDescription").val();
	var numberOfBeds = $("#numberOfBeds").val();
	var tmp = document.getElementById("lodgingType");
	var lodgingType = tmp.options[tmp.selectedIndex].value;
	var tmp = document.getElementById("lodgingMeal");
	var lodgingMeal = tmp.options[tmp.selectedIndex].value;
	var selected = [];
	$('input:checked').each(function() {
	    selected.push($(this).attr('name'));
	});
<<<<<<< Updated upstream
/*
	console.log(lodgingType);
	console.log(lodgingMeal); //id from the db
	console.log(selected);		//list of ^
*/	
=======

	var imagePaths = [];
	var links = $('#imagelink').val().substring(1).split(';');
	links.forEach(function(link){
		imagePaths.push(link);
	});
	
	//console.log(lodgingType);
	//console.log(lodgingMeal); //id from the db
	//console.log(selected);		//list of ^

>>>>>>> Stashed changes
	//first two work, third doesn't
/*	var lType = "";
	$.get({
		url: "/lodging/type/"+lodgingType,
		success: function(data4){
			lType = data4;
		}
	});
	
	var fType = "";
	$.get({
		url: "/lodging/food/"+lodgingMeal,
		success: function(data4){
			fType = data4;
		}
	});
	
	var sType = [];
	for(var i = 0; i < selected.length; i++){
		$.get({
			url: "/lodging/feature/"+selected[i],
			success: function(data4){
				sType[i] = data4;
			}
		});
	}*/
	

	var ff = 1; //temporary 
	var json = JSON.stringify({
		"name": name,
		"address": addr,
		"description": description,
		"numberOfBeds": numberOfBeds,
		"category": ff,
<<<<<<< Updated upstream
		"rating": ff /*,
		//"lodgingType": lType,
		//"foodServiceType": fType,
		//"featureType": sType,
		//"agent": .... */
=======
		"rating": ff ,
		"lodgingType": lodgingType,
		"foodServiceType": lodgingMeal,
		"featureType": selected,
		"imagePaths": imagePaths,
		"agent": Cookies.get('user')
>>>>>>> Stashed changes
	});
	$.post({
		url: "/lodging/add",
        contentType: "application/json",
        dataType: "text",
		data: json, 
		success: function(lodging){
			console.log(lodging);
		}
	});
    
});
