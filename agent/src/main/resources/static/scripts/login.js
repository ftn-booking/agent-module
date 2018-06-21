$(function() {
	
    $('#login-submit').click(function(event){
        event.preventDefault();
        $("#loginMessage").empty();
        var email = $("#username").val();
        var password = $("#password").val();
        $.post({
            url: "https://localhost:8080/login",
            contentType: "application/json",
            dataType: "text",
            data: JSON.stringify({
                "email": email,
                "password": password
            }), success: function(data){
            		$.post({
            			url: "/lodging/synchronize/"+email,
            		})
            		Cookies.set('token', data, {expires: 10, path: '/', secure: true});
					Cookies.set('user', email, {expires: 10, path: '/', secure: true});
					
					
					setTimeout(function(){window.location.replace('/home.html');}, 350);
				
            }, error: function(data){
					console.log(data);
				    $("#loginMessage").empty();
                    $("#loginMessage").append('<p>Authentication failed</p>');
                
			}
        });

    });

});
