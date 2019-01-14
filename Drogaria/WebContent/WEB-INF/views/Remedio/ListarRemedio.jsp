<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remedios Cadastrados</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>
	<h1>Lista de Remedios</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Funcionalidade</th>
				<th>Preço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="remedio" items="${remedio }">
				<tr>
					<td>${remedio.nome }</td>
					<td>${remedio.funcionalidade }</td>
					<td>${remedio.preço }</td>
					<td><a href="/Drogaria/Remedio/remover?id=${remedio.id }">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>