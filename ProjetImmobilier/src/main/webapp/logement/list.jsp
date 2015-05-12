<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
	
		<header>
			<nav>
				<ul>
					<li><a href="/ProjetImmobilier/index.do">Home</a></li>
					<li><a href="#">Admin</a></li>
				</ul>
			</nav>
		</header>

		<h1>Liste de Logement</h1>
		
		<section>
		<table>

			<tr>
				<!-- 		<td>ID</td> -->
				<td>QUARTIER</td>
				<td>NUMERO DE RUE</td>
				<td>NOM DE RUE</td>
				<td>VILLE</td>
				<td>LOYER</td>
				<td>CHARGE</td>
				<td>PARUTION</td>
			</tr>

			<c:forEach items="${logements}" var="l">
				<tr>
					<td>${l.quartier.libelleQuartier}</td>
					<td>${l.numeroRue}</td>
					<td>${l.nomRue}</td>
					<td>${l.quartier.commune.nomCommune}</td>
					<td>${l.loyer} euros</td>
					<td>${l.typeLogement.charges} euros</td>
<!-- 					Créer une session pour les collections -->
<%-- 					<td><fmt:formatDate value="${l.datesAnnonce}" pattern="dd/MM/yyyy"/></td> --%>
				</tr>

			</c:forEach>
			
		</table>
		</section>
		
		<footer>
		
		</footer>
		
	</div>

</body>
</html>