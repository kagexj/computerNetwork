<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Введите числа</title>
</head>
<body>
<h1>Greetings at <%= (( request.getAttribute("place") == null ) ? request.getServerName() : request.getAttribute("place")) %> </h1>
${l }
${r }

<form method="get">
Left: <input type="text" name="left"> <br/>
Right: <input type="text" name="right"> <br/>
<input type="submit">
</form>

<c:if test="${ not empty primes }">
	<ol>
	<c:forEach var="x" items="${ primes }">
	<li> <c:out value="${x}"/>
	</c:forEach>
	</ol>
</c:if>

</body>
</html>
