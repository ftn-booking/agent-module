var t1 = "";
$(document).ready(function(){
	var mail = Cookies.get('user');
	
	$.get({
		url: 'https://localhost:8080/api/authentication/'+mail,
		success: function(data){

			if(data.userType != "AGENT"){
				Cookies.remove('token', {path: '/'});
				Cookies.remove('user', {path: '/'});
				Cookies.remove('agent', {path: '/'});
				window.location.replace('/login.html');
			}
			Cookies.set('agent', data, {expires: 10, path: '/', secure: true})
			$('p').append(data.name);
			t1=data.id;
			home();
			
			
			
		}, error: function(data){
			
			console.log('what');
			
		}
		
		
		
	});
	
});

function home(){
	$("#middle").append('<button type="button" class="btn btn-primary" onclick="addL()">'
			+'Add Lodging</button>'
			+'<br><table id="LodgingTable" class="table"></table>');
			$("#LodgingTable").html('<tr class="header"><th>Name</th><th>View</th><th>Edit</th></tr>');
			
			$.get({
				url:"/lodging/" + t1,
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
	$("#addForm").html('<table>'
			+'<tr><td><label>Name: </label></td><td><input type="text" class="form-control" id="lodgingName" placeholder="Name"></td></tr><br>'
			+'<tr><td><label>Address: </label></td><td><input type="text" class="form-control" id="lodgingAddress" placeholder="Address"></td></tr><br>'
			+'<tr><td><label>Description: </label></td><td><input type="text" class="form-control" id="lodgingDescription" placeholder="Description"></td></tr><br>'
			+'<tr><td><label>Number of beds: </label></td><td><input type="number" id="numberOfBeds"></td></tr><br>'
			+'<tr><td><label>Type: </label></td><td><select id="lodgingType">'
			+'</select></td></tr><br>');

	var lodgingTypes = "";
	$.get({
		url:"/lodging/getLodgingTypes",
		success: function(data){
			for(var i = 0; i < data.length; i++)
				lodgingTypes+='<option value="'+data[i].name+'">'+data[i].name+'</option>'
			$("#lodgingType").html(lodgingTypes);	
		}
	});
	
	var featureTypes = "";
	$.get({
		url:"/lodging/getFeatureTypes",
		success: function(data){
			for(var i = 0; i < data.length; i++)
				featureTypes+='<tr><td><label>'+data[i].name+': </label></td><td><input type="checkbox" name="'+data[i].name+'" value="'+data[i].name+'"></rd></tr><br>'
			$("#addForm").append(featureTypes);
			$("#addForm").append('<tr><td><label>Meal: </label></td><td><select id="lodgingMeal">'
					+'<option value="Breakfast">Breakfast</option>'
					+'<option value="Half Board">Half Board</option>'
					+'<option value="Full Board">Full Board</option>'
					+'</select></td></tr><br>'
					+'<tr><td><input type="submit"></td><td></td></tr>'
					+'</table>');
		}
	});
	
				
			
			
			
			
			
			
			
			
			
}