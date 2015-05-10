<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">

		<header>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="#">Admin</a></li>
				</ul>
			</nav>
		</header>

		<aside>
			<form:form action="" commandName="searchModel"
				method="POST">
				<label>Ville</label>
				<form:select id="communes" path="commune">
					<form:option value="" label="--- Selectionner Communes ---" />
					<form:options class="communeItem" items="${allCommunes}"
 						itemValue="nomCommune" itemLabel="nomCommune" />
				</form:select>

				<label>Quartier</label>
				<form:select id="quartiers" path="quartier">
					<form:option value="" label="--- Selectionner Quartiers ---" />
<%-- 					<form:options items="${allQuartiers}" --%>
<%-- 						itemValue="libelleQuartier" itemLabel="libelleQuartier" /> --%>
				</form:select>

				<input type="submit">
			</form:form>

		</aside>

		<section></section>

		<footer> </footer>

	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
	<script src="./js/ajax.js"></script>

</body>
</html>