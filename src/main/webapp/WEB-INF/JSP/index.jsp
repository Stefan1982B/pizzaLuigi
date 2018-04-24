<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>Pizza Luigi</title>
<link rel='icon' href='images/pizza.ico' type='image/x-icon'>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='css/pizzaluigi.css'>
</head>
<body>
	<h1>Pizza Luigi</h1>
	<img src='images/pizza.jpg' alt='pizza' class='fullwidth'>
	<h2>${boodschap}</h2>
	<h2>${lievelingsgetal}</h2>
	<h2>de zaakvoerder</h2>
	<dl>
	<dt>Naam</dt> <dd>${zaakvoerder.voornaam}</dd>
	<dt>Aantal Kinderen</dt> <dd>${zaakvoerder.aantalKinderen}</dd>
	  <dt>Gehuwd</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee'}</dd> 
	  <dt>Adres</dt>
	  <dd>${zaakvoerder.adres.straat}</dd><dd>${zaakvoerder.adres.huisNr}</dd>
	  <dd>${zaakvoerder.adres.postcode}</dd><dd>${zaakvoerder.adres.gemeente}</dd>
	</dl>

</body>
</html>