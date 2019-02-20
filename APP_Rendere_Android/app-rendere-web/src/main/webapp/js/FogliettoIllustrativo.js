		$(() => {
			var farmaco = JSON.parse(sessionStorage.getItem('farmaco'));
			$("#nomeFrmc").text(farmaco[0].nome);
		
			var foglietto = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#indicazioni").text(farmaco[0].fogliettoIllustrativo.indicazioni);
			
			var foglietto1 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#controIndicazioni").text(farmaco[0].fogliettoIllustrativo.controindicazioni);
			
			var foglietto2 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#avvertenze").text(farmaco[0].fogliettoIllustrativo.avvertenze);
			
			var foglietto3 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#composizione").text(farmaco[0].fogliettoIllustrativo.composizione);
			
			var foglietto4 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#effettiIndesiderati").text(farmaco[0].fogliettoIllustrativo.effettiIndesiderati);
			
			var foglietto5 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#interazioni").text(farmaco[0].fogliettoIllustrativo.interazioni);
			
			var foglietto6 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#modiDuso").text(farmaco[0].fogliettoIllustrativo.modiDuso);
			
			var foglietto7 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#precauzioni").text(farmaco[0].fogliettoIllustrativo.precauzioni);
			
			var foglietto8 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#principioAttivo").text(farmaco[0].fogliettoIllustrativo.principioAttivo);
			
			var foglietto9 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#scadenzaConservazione").text(farmaco[0].fogliettoIllustrativo.scadenzaConservazione);
			
			var foglietto10 = JSON.parse(sessionStorage.getItem('farmaco'))
			$("#sovradosaggio").text(farmaco[0].fogliettoIllustrativo.sovradosaggio);
			
			
			
			
			
		});
	
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
		