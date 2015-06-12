<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${error != null}">
		<div><a>Error</a></div>
		<c:url value="registerclass" var="url"/>
		<div><a href='${url}'>Back</a></div>
	</c:when>
	<c:otherwise>
		<script>
			window.location = "registerclass";
		</script>
	</c:otherwise>
</c:choose>

</body>
</html>