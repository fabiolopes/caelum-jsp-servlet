<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar tarefa - ${tarefa.id }</title>
</head>
<body>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id }" /> Descri��o<br>
		<textarea name="descricao" rows="5" cols="100">
			${tarefa.descricao }
		</textarea>
		<br> Finalizado? <input type="checkbox" name="finalizado"
			value="true" ${tarefa.finalizado? 'checked': ''} /><br> Data de
		finaliza��o: <br> <input type="text" name="dataFinalizacao"
			value="<fmt:formatDate value='${tarefa.dataFinalizacao.time }' pattern="dd/MM/yyyy" />" />
		<br> <input type="submit" value="Alterar" />
	</form>
</body>
</html>