if(localStorage.getItem('data') == null){
	window.location.replace('/login.html');
} else {
	window.location.replace('/home.html');
}
