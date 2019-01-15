<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrando Remedio</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>


	<h3>Adicionar Remédio</h3>
	<form action="/Drogaria/Remedio/executarCadastro" method="post">
		<div>
			<label>Nome:</label> <input type="text" name="nome">
		</div>
		<div>
			<label>Funcionalidade:</label> <input type="text"
				name="funcionalidade">
		</div>
		<div>
			<label>preco:</label> <input type="text" name="preco">
		</div>
		<button type="submit">Adicionar</button>
	</form>
</body>
</html>