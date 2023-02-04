<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Веб клиент</title>
</head>
<body>
<h1>Добавить задачу</h1>

<form method="get">
Left: <input type="text" name="left"> <br/>
Right: <input type="text" name="right"> <br/>
Step: <input type="text" name="step"> <br/>
<input type="submit">
</form>

<p><b>Задачи на сервере:</b></p>

<c:if test="${ not empty tasks }">
<ol>
	<c:forEach var="task" items="${ tasks }">
		<li> <c:out value="${ task }"/> </li>
		
	</c:forEach>
</ol>
</c:if>
<c:if test="${ empty tasks }">
<p> Задач нет </p>
</c:if>


</body>
</html>