<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2><fmt:message key="pagina.login"/></h2>
	<form action="efetuaLogin" method="post">
		Login:<input type="text" name="login"/>
		Senha:<input type="password" name="senha"/>
		<input type="submit" value="Entrar nas tarefas"/>
	</form>
</body>
</html>