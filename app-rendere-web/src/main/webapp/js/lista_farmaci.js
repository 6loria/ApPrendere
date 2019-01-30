$(() => {
	var farmaco = JSON.parse(sessionStorage.getItem('farmaco'));
	$('#lblUtente').text(farmaco.nome + ' ' +
						 farmaco.aic + ' ' +
						 farmaco.produttore + ' '+
						 farmaco.concentrazione + ' '+
						 farmaco.unita + ' '+
						 farmaco.utilizzo + ' '+
						 farmaco.prezzo + ' '+
						 farmaco.principioAttivo);
});