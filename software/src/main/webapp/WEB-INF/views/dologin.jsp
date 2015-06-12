<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${error != null}">
		<div><a>Wrong user name or password</a></div>
		<c:url value="/login" var="url"/>
		<div><a href='${url}'>Back</a></div>
	</c:when>
	<c:otherwise>
		<c:if test="${rank == '0'}">
		<script>
			window.location = "registerclass";
		</script>
		</c:if>
		
		<c:if test="${rank == '1'}">  
		<script>
			window.location = "professor/createclass";
		</script>
		</c:if>
	</c:otherwise>
</c:choose>

</body>
</html>