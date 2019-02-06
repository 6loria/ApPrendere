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
	var utente = JSON.parse(sessionStorage.getItem('utente'));
	$('#lblUtente').text(utente.cognome + ' ' + utente.nome);
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
			location.href = 'FogliettoIllustrativo.html';
		} else {
			$('#alertRicercaFailed').text('Spiacenti, questo farmaco non è presente ');
			$('#alertRicercaFailed').show('fast');
		}
	});
});
});

$('#lblUtentePiccolo').text(utente.cognome + ' ' + utente.nome);
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
			location.href = 'FogliettoIllustrativo.html';
		} else {
			$('#alertRicercaFailed').text('Spiacenti, questo farmaco non è presente ');
			$('#alertRicercaFailed').show('fast');
		}
	});
});

