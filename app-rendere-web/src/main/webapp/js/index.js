// Modal Image Gallery
function onClick(element) {
	document.getElementById("img01").src = element.src;
	document.getElementById("modal01").style.display = "block";
	var captionText = document.getElementById("caption");
	captionText.innerHTML = element.alt;
}

// Change style of navbar on scroll
window.onscroll = function() {
	myFunction()
};
function myFunction() {
	var navbar = document.getElementById("myNavbar");
	if (document.body.scrollTop > 100
			|| document.documentElement.scrollTop > 100) {
		navbar.className = "w3-bar" + " w3-card" + " w3-animate-top"
				+ " w3-white";
	} else {
		navbar.className = navbar.className.replace(
				" w3-card w3-animate-top w3-white", "");
	}
}

// Used to toggle the menu on small screens when clicking on the menu button
function toggleFunction() {
	var x = document.getElementById("navDemo");
	if (x.className.indexOf("w3-show") == -1) {
		x.className += " w3-show";
	} else {
		x.className = x.className.replace(" w3-show", "");
	}
}

$(() => {
	$('#btnAccedi').click((e) => {
		e.preventDefault();
		$.ajax({
			url: 'mvc/login',
			method: 'post',
			data: $('#frmLogin').serialize()
		})
		.done((utente) => {
			if(utente) {
				sessionStorage.setItem('utente', JSON.stringify(utente));
				location.href = 'home.html';
			} else {
				sessionStorage.removeItem('utente');
				$('#alertLoginFailed').text('Accesso fallito');
				$('#alertLoginFailed').show('fast');
				$('#txtEmail').val('');
				$('#txtPassword').val('');
			}
		});
	});
	$('#btnRegistra').click((e) => {
		e.preventDefault();
		$.ajax({
			url: 'mvc/registra',
			method: 'post',
			data: $('#frmRegistra').serialize()
		})
		.done((utente) => {
			if(utente) {
				sessionStorage.setItem('utente', JSON.stringify(utente));
				location.href = 'home.html';
			} else {
				$('#alertRegistraFailed').text('Registrazione fallita');
				$('#alertRegistraFailed').show('fast');
			}
		});
	});
	$('#btnRicerca').click((e) => {
		e.preventDefault();
		$.ajax({
			url: 'mvc/ricercaFarmaco',
		    method: 'get',
		    data: $('#ResearchForm').serialize()
		})
		.done((farmaco) => {
			if(farmaco) {
				sessionStorage.setItem('farmaco', JSON.stringify(farmaco));
				location.href = 'ListaFarmaci.html';
			} else {
				$('#alertRicercaFailed').text('Spiacenti, questo farmaco non è presente ');
				$('#alertRicercaFailed').show('fast');
			}
		});
	});
});