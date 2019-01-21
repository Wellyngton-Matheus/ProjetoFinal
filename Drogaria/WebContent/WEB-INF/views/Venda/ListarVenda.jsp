<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de Vendas:</h1>

	<table border="1">
		<tr>
			<th>Nome do Cliente</th>
			<th>Nome do Remedio</th>
			<th>Preço do Remedio</th>
			<th>Data da Venda</th>
		</tr>
		<c:forEach var="venda" items="${vendas }">
			<tr>
				<td>${venda.cliente.nome }</td>
				<td>${venda.remedio.nome }</td>
				<td>${venda.remedio.preco }</td>
				<td><fmt:formatDate value="${venda.dataVenda.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="/Drogaria/Venda/remover?id=${venda.id}">remover</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>