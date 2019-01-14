<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes Cadastrados</title>
</head>
<body>

	<c:import url="../menu.jsp"></c:import>


	<h1>Lista de Clientes</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Senha</th>
				<th>Cpf</th>
				<th>Email</th>
				<th>Numero</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuario }">
				<tr>
					<td>${usuario.nome }</td>
					<td>${usuario.senha }</td>
					<td>${usuario.cpf }</td>
					<td>${usuario.Email }</td>
					<td>${usuario.Numero }</td>
					<td><a href="/Drogaria/Cliente/remover?id=${usuario.id }">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>