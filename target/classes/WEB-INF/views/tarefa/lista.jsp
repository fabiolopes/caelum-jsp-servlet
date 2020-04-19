<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="resources/js/jquery-1.12.3.js"></script>
<script type="text/javascript">
		/*function finalizarAgora(id){
			console.log("Entrei na function ajax");
			$.get("finalizaTarefa?id="+id, function(dadosDaResposta){
				alert("Tarefa finalizada");
				$("#tarefa_"+id).html("Finalizado");
				$("#data_"+id).html(new Date().toLocaleDateString());
			});
		}*/
		function finalizarAgora(id){
			console.log("Entrei na function ajax");
			$.post("finalizaTarefa", {'id' : id}, function(resposta){
				$("#tarefa_"+id).html("Finalizado");
				alert("Tarefa finalizada");
				$("#data_"+id).html(resposta);
			});
		}
		
	</script>
</head>
<body>
	<a href="novaTarefa">Criar nova tarefa</a>
	<br>
	<br>
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>data da finalização</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id }</td>
				<td>${tarefa.descricao }</td>
				<c:if test="${tarefa.finalizado eq false }">
					<td id="tarefa_${tarefa.id }"><a href="#"
						onclick="finalizarAgora(${tarefa.id })">Finalizar agora</a></td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true }">
					<td id="tarefa_${tarefa.id }">Finalizado</td>
				</c:if>
				<td id="data_${tarefa.id}"><fmt:formatDate value="${tarefa.dataFinalizacao.time }"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="removeTarefa?id=${tarefa.id }">Excluir</a></td>
				<td><a href="mostraTarefa?id=${tarefa.id }">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>