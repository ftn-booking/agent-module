$(function() {
	
    $('#login-submit').click(function(event){
        event.preventDefault();
        $("#loginMessage").empty();
        var email = $("#username").val();
        var password = $("#password").val();
        var port = (window.location.port ==="") ? "" : ":8080";
    	var tt = window.location.protocol + '//' + window.location.hostname+port;

        $.post({
            url: tt+"/login",
            contentType: "application/json",
            dataType: "text",
            data: JSON.stringify({
                "email": email,
                "password": password
            }), success: function(data){
            		localStorage.setItem('data', data);
            		localStorage.setItem('user', email);
					sync(email);
					setTimeout(function(){window.location.replace('/home.html');}, 350);
					//window.location.replace('/home.html');
            }, error: function(data){
					console.log(data);
				    $("#loginMessage").empty();
                    $("#loginMessage").append('<p>Authentication failed</p>');
                
			}
        });

    });

});

function sync(mail){
	$.post({
		url: "/lodging/synchronize/"+mail,
		success: function(data){
		}
	});	
	
}