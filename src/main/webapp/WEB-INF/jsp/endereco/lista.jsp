<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppMIT</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de endereco</h2>
		
		<form action="/endereco" method="get">
			<label>Endereco:</label>
		  	<button type="submit" class="btn btn-primary">Novo</button>
	  </form>



	<c:if test="${not empty lista}">		
		<h2>Total de endereco: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>cep</th>
		        <th>logadouro</th>
		        <th>complemento</th>
		        <th>bairro</th>
		        <th>localidade</th>
		        <th>uf</th>
        		<th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="e" items="${lista}">
			      <tr>
			        <td>${e.id}</td>
			        <td>${e.cep}</td>
			        <td>${e.logradouro}</td>
			        <td>${e.complemento}</td>
			        <td>${e.bairro}</td>
			        <td>${e.localidade}</td>
			        <td>${e.uf}</td>
			        <td><a href="/endereco/${e.id}/excluir">excluir</a> </td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem enderecos cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>