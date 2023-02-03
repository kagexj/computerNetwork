<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат</title>
</head>
<body>
<h1>Интервал от <c:out value="${l}"/> до <c:out value="${r}"/>:</h1>

<c:if test="${ not empty primes }">
	<ol>
	<c:forEach var="x" items="${ primes }">
	<li> <c:out value="${x}"/>
	</c:forEach>
	</ol>
</c:if>

</body>
</html>
