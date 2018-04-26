<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
	<c:param name='title' value='Pizza Luigi' />
</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />
	<h1>Pizza Luigi</h1>
	<img src='<c:url value="/images/pizza.jpg"/>' alt='pizza' class='fullwidth'>
	<h2>${boodschap}</h2>
	<h2>${lievelingsgetal}</h2>
	<h2>de zaakvoerder</h2>
	<dl>
		<dt>Naam</dt>
		<dd>${zaakvoerder.voornaam}</dd>
		<dt>Aantal Kinderen</dt>
		<dd>${zaakvoerder.aantalKinderen}</dd>
		<dt>Gehuwd</dt>
		<dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee'}</dd>
		<dt>Adres</dt>
		<dd>${zaakvoerder.adres.straat}</dd>
		<dd>${zaakvoerder.adres.huisNr}</dd>
		<dd>${zaakvoerder.adres.postcode}</dd>
		<dd>${zaakvoerder.adres.gemeente}</dd>
	</dl>

</body>
</html>