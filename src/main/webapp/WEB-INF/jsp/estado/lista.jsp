<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appendereco</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Lista de estados</h2>
		<h3>Total dos Estados: ${lista.size()}</h3>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>nome</th>
					<th>UF</th>

					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="es" items="${lista}">
					<tr>
						<td>${es.id}</td>
						<td>${es.nome}</td>
						<td>${es.sigla}</td>
						<td><a href="/municipios/${es.id}">Municipios</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>