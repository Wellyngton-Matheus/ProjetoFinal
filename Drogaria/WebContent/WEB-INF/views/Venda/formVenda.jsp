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
	<h1>Efetuar Compras</h1>
	<form action="/Drogaria/Venda/formVenda" method="post">

		<h3>
			Cliente <select name="cliente.id">
				<c:forEach var="cliente" items="${clientes }">
					<option value="${cliente.id }">${cliente.nome }</option>
				</c:forEach>
			</select>
		</h3>

		<h3>
			Remedio <select name="remedio.id">
				<c:forEach var="remedio" items="${remedios }">
					<option value="${remedio.id }">${remedio.nome }</option>
				</c:forEach>
			</select>
		</h3>
		<input type="submit" value="Comprar">
	</form>
</body>
</html>