<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios Cadastrados</title>
</head>
<body bgcolor="F78181">

	<c:import url="../menu.jsp"></c:import>


	<h1>Lista de clientes</h1>

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
			<c:forEach var="cliente" items="${clientes }">
				<tr>
					<td>${cliente.nome }</td>
					<td>${cliente.senha }</td>
					<td>${cliente.cpf }</td>
					<td>${cliente.email }</td>
					<td>${cliente.numero }</td>
					<td><a href="/Drogaria/Cliente/remover?id=${cliente.id }">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>