<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body bgcolor="F78181">
	<c:import url="../menu.jsp"></c:import>
	<h1>Cadastrando cliente</h1>
	<form action="executarCadastro" method="post">
	
	<form>
	
		<div>
			<label>Nome:</label> <input type="text" name="nome">
		</div>
		<div>
			<label>Senha:</label> <input type="text" name="senha">
		</div>
		<div>
			<label>Cpf:</label> <input type="text" name="cpf">
		</div>
		<div>
			<label>Email:</label> <input type="text" name="email">
		</div>
		<div>
			<label>Numero:</label> <input type="text" name="numero">
		</div>
		<button type="submit">Adicionar</button>
	</form>
</body>
</html>