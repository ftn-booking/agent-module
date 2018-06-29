var t1 = "";
$(document).ready(function(){
	var mail = localStorage.getItem('user');
	var tt = window.location.protocol + '//' + window.location.hostname+':8080';
	$.get({
		url: tt+'/api/authentication',
		headers: {
			"Authorization":"Bearer " + localStorage.getItem('data')
		},
		success: function(data){

			if(data.userType != "AGENT"){
				localStorage.removeItem('data');
				localStorage.removeItem('user');
				window.location.replace('/login.html'); 
			} else {
				$('#firstName').append('&nbsp;&nbsp;&nbsp;<button onclick="logout()" >Logout</button>&nbsp;&nbsp;&nbsp;&nbsp;<button id="chpw">Change Password</button>&nbsp;&nbsp;&nbsp;&nbsp;' + data.name);
				
				home(data.id);
			}
		}, error: function(data){
			
			console.log('shouldn\'t show up except if back-end is down');
			
		}
			
	});
	
});

$(document).on("click", ".edit", function(e){
	e.preventDefault();
	highlightRow(this);
	var url = $(this).attr("href");
	t1 = url;
	editLodging(url);
});

function editLodging(url){
	$.get({
		url: url,
		success: function(lodging){
			
			
			$("#edit-modal-body").empty();
			
			$("#edit-modal-body").html(''
					//+'<div class="dropzone">'
			        //+'<div class="info"></div>'
			        //+'</div><br>'
			        //+'<script type="text/javascript" src="scripts/imgur.js"></script>'
			        //+'<script type="text/javascript" src="scripts/upload.js"></script>'
					+'<label>Name: </label><input type="text" class="form-control" id="lodgingNameEdit" onkeyup="this.value=this.value.replace(/[\\d]/,\'\')" placeholder="Name">'
					+'<label>Address: </label><input type="text" class="form-control" id="lodgingAddressEdit" placeholder="Address">'
					+'<label>Description: </label><input type="text" class="form-control" id="lodgingDescriptionEdit" placeholder="Description">'
					+'<label>Category: </label><br><input type="number" id="lodgingCategoryEdit" min="0" max="5" placeholder="Min: 0; Max: 5"><br>'
					+'<label>Number&nbsp;of&nbsp;beds: </label><br><input type="number" id="lodgingNumberOfBedsEdit" min="1" placeholder="Min: 1"><br>'
					+'<br><label style="width: 100px">Type: </label><select id="lodgingTypeEdit">'
					+'</select><br>'
					+'<label style="width: 100px">Meal: </label><select id="lodgingMealEdit">'
					+'</select><br>');

			$("#lodgingNameEdit").val(lodging.name);
			$("#lodgingAddressEdit").val(lodging.address);
			$("#lodgingDescriptionEdit").val(lodging.description);
			$("#lodgingNumberOfBedsEdit").val(lodging.numberOfBeds);
			$("#lodgingCategoryEdit").val(lodging.category);
			
			var lodgingTypes = "";
			$.get({
				url:"/lodging/getLodgingTypes",
				success: function(data){
					for(var i = 0; i < data.length; i++)
						lodgingTypes+='<option value="'+data[i].id+'">'+data[i].name+'</option>'

					$("#lodgingTypeEdit").html(lodgingTypes);	
					$("#lodgingTypeEdit").val(lodging.lodgingType.id.toString());
				}
			});
			

			
			
			var features = [];
			lodging.featureType.forEach(function(feature){
				features.push(feature.name);
			});
			var featureTypes = "";
			$.get({
				url:"/lodging/getFeatureTypes",
				success: function(data){
					for(var i = 0; i < data.length; i++){
						var checked = (features.indexOf(data[i].name) > -1 ) ?  "checked" : "";
						featureTypes+='<label style="width: 100px">'+data[i].name+': </label><input type="checkbox" name="'+data[i].id+'" value="'+data[i].name+'" '+checked+'><br>'
					}
					$("#edit-modal-body").append(featureTypes);
					

				}
			});
			
			var foodServiceTypes = "";
			$.get({
				url:"/lodging/getFoodServiceTypes",
				success: function(data){
					for(var i = 0; i < data.length; i++)
						foodServiceTypes+='<option value="'+data[i].id+'">'+data[i].name+'</option>'
						
						$("#lodgingMealEdit").html(foodServiceTypes);	
					$("#lodgingMealEdit").val(lodging.foodServiceType.id);
						
				}
			});

		}
	});
	$("#editModal").modal();
}

$(document).on("click", "#chpw", function(e){
	e.preventDefault();
	$("#change-modal-body").empty();
	$("#change-modal-body").append(''
			+'<label>Current&nbsp;password: </label><br><input id="cpw" type="password"><br>'
			+'<label>New&nbsp;password: </label><br><input id="npw" type="password"><br>'
			+'<label>Confirm&nbsp;new&nbsp;password: </label><br><input id="rpw" type="password"><br>'
	);
	$("#changeModal").modal();
});

$(document).on("click", "#changePassword", function(e){
	e.preventDefault();
	var cpw = $("#cpw").val();
	var npw = $("#npw").val();
	var rpw = $("#rpw").val();
	if(npw === cpw){
		alert('New password cannot be the same as current password');
		return;
	}
	if(npw !== rpw){
		alert('Confirmation failed');
		return;
	}
	
	$.post({
		url: "/agent/"+localStorage.getItem('user'),
	contentType: "application/json",
    dataType: "text",
	data: JSON.stringify({
		"oldPassword": cpw,
		"newPassword": npw
	}),
	success: function(){
		alert('Password successfully changed!');
		$("#changeModal").modal('toggle');
	}
	})
	
});

$(document).on("click", ".delete", function(e){
	e.preventDefault();	
	highlightRow(this);
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



function home(agentId){
	$("#middle").empty();
	$("#middle").append('<button type="button" id="addLgg" class="btn btn-secondary">'
			+'Add Lodging</button>'
			+'<br><div id="formContainer"><table id="LodgingTable" class="table"></table></div>');
			$("#LodgingTable").html('<tr class="header"><th>Name</th><th width="30px"></th><th width="30px"></th><th width="30px"></th></tr>');
			
			$.get({
				url:"/lodging/agent/" + agentId,

				success: function(data2){
					for(var i = 0; i < data2.length; i++){
						$("#LodgingTable").append('<tr id="'+data2[i].id+'">'
						+'<td style="min-width: 200px" class="name">'+data2[i].name+'</td>'
						+'<td><a class="view" href="/lodging.html?id='+data2[i].id+'"><img src="img/view.gif"/></a></td>'
						+'<td><a class="edit" href="/lodging/'+data2[i].id+'"><img src="img/edit.gif"/></a></td>'
						+'<td><a class="delete" href="/lodging/'+data2[i].id+'"><img src="img/remove.gif"/></a></td>'
						+'</tr>');
					}
				}
			});
}

$(document).on("click", "tr", function(event) {
	highlightRow(this);
});

function highlightRow(row){
	if(!$(row).hasClass("header")){
 		$(".highlighted").removeClass("highlighted");
   	$(row).addClass("highlighted");
   }
}


$(document).on('click', "#addLgg", function(e){
	e.preventDefault();
	$("#add-modal-body").empty();
	
	$("#add-modal-body").html('<div class="dropzone">'
	        +'<div class="info"></div>'
	        +'</div><br>'
	        +'<script type="text/javascript" src="scripts/imgur.js"></script>'
	        +'<script type="text/javascript" src="scripts/upload.js"></script>'
			+'<label>Name: </label><input type="text" class="form-control" id="lodgingName" onkeyup="this.value=this.value.replace(/[\\d]/,\'\')" placeholder="Name">'
			+'<label>Address: </label><input type="text" class="form-control" id="lodgingAddress" placeholder="Address">'
			+'<label>Description: </label><input type="text" class="form-control" id="lodgingDescription" placeholder="Description">'
			+'<label>Category: </label><br><input type="number" id="lodgingCategory" min="0" max="5" placeholder="Min: 0; Max: 5"><br>'
			+'<label>Number&nbsp;of&nbsp;beds: </label><br><input type="number" id="numberOfBeds" min="1" placeholder="Min: 1"><br>'
			+'<br><label style="width: 100px">Type: </label><select  id="lodgingType">'
			+'</select><br>'
			+'<label style="width: 100px">Meal: </label><select id="lodgingMeal">'
			+'</select><br>');
	
	
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
				featureTypes+='<label style="width: 100px">'+data[i].name+': </label><input type="checkbox" name="'+data[i].id+'" value="'+data[i].name+'"><br>'
			$("#add-modal-body").append(featureTypes);
			//$("#addForm").append('<input type="submit" value="Submit">'
			//		+'');

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
	
			
	$("#addModal").modal();
});


$(document).on('click',"#editLodging", function(e){
	e.preventDefault();
	var name = $('#lodgingNameEdit').val();
	var addr = $("#lodgingAddressEdit").val();
	var description = $("#lodgingDescriptionEdit").val();
	var numberOfBeds = $("#lodgingNumberOfBedsEdit").val();
	var tmp = document.getElementById("lodgingTypeEdit");
	var lodgingType = tmp.options[tmp.selectedIndex].value;
	var tmp = document.getElementById("lodgingMealEdit");
	var lodgingMeal = tmp.options[tmp.selectedIndex].value;
	var category = $("#lodgingCategoryEdit").val();
	var selected = [];
	$('input:checked').each(function() {
	    selected.push($(this).attr('name'));
	});

	var json = JSON.stringify({
		"name": name,
		"address": addr,
		"description": description,
		"numberOfBeds": numberOfBeds,
		"category": category,
		"lodgingType": lodgingType,
		"foodServiceType": lodgingMeal,
		"featureType": selected,
		//"imagePaths": imagePaths
	});

	
 	$.post({
		url: t1,
		contentType: "application/json",
        dataType: "text",
		data: json, 
		success: function(data){
			$("#editModal").modal('toggle');
			window.location.replace('/home.html');
			
		}
	})

});

$(document).on("click","#addLodging",function(e){
	e.preventDefault();
	var name = $('#lodgingName').val();
	var addr = $("#lodgingAddress").val();
	var description = $("#lodgingDescription").val();
	var numberOfBeds = $("#numberOfBeds").val();
	var tmp = document.getElementById("lodgingType");
	var lodgingType = tmp.options[tmp.selectedIndex].value;
	var tmp = document.getElementById("lodgingMeal");
	var lodgingMeal = tmp.options[tmp.selectedIndex].value;
	var category = $("#lodgingCategory").val();
	var selected = [];
	$('input:checked').each(function() {
	    selected.push($(this).attr('name'));
	});

	var imagePaths = [];
	var links = $('#imagelink').val().substring(1).split(';');
	links.forEach(function(link){
		imagePaths.push(link);
	});

	var rat = null;
	var json = JSON.stringify({
		"name": name,
		"address": addr,
		"description": description,
		"numberOfBeds": numberOfBeds,
		"category": category,
		"rating": rat ,
		"lodgingType": lodgingType,
		"foodServiceType": lodgingMeal,
		"featureType": selected,
		"imagePaths": imagePaths,
		"agent": localStorage.getItem('user')
	});
	$.post({
		url: "/lodging/add",
        contentType: "application/json",
        dataType: "text",
		data: json, 
		success: function(data){
			$("#addModal").modal('toggle');
			window.location.replace('/home.html');
		}
	});
    
});
