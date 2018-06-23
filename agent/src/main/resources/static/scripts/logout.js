function logout(){
	localStorage.removeItem('data');
	localStorage.removeItem('user');	
	window.location.replace('/login.html');
}