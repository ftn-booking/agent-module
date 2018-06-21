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
            			url: "https://localhost:8081/lodging/synchronize/"+email
            		})
            		//alert(email);
					Cookies.set('token', data, {expires: 10, path: '/', secure: true});
					Cookies.set('user', email, {expires: 10, path: '/', secure: true});
					window.location.replace('/home.html');
					//maybe more stuff here

            }, error: function(data){
					console.log(data);
				    $("#loginMessage").empty();
                    $("#loginMessage").append('<p>Authentication failed</p>');
                
			}
        });

    });

});
