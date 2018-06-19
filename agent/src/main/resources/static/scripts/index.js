if((typeof Cookies.get('token')) == "undefined"){
	window.location.replace('/login.html');
} else {
	window.location.replace('/home.html');
}
