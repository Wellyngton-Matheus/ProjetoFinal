<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrando Remedio</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>


	<h3>Adicionar Rem�dio</h3>
	<form action="/Drogaria/Remedio/executarCadastro" method="post">
		<div>
			<label>Nome:</label>
			<input type="text" name="nome">
		</div>
		<div>
			<label>Funcionalidade:</label> 
			<input type="text" name="funcionalidade">
		</div>
		<div>
			<label>Pre�o:</label> 
			<input type="text" name="pre�o">
		</div>
			<button type="submit">Adicionar</button>
	</form>
</body>
</html>