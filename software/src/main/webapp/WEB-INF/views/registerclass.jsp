<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registering for a class</title>
</head>
<body>
<jsp:include page="master.jsp"></jsp:include>
<form action="registerclassdone" method="post">
Classes:
<select name="class">
	${classlist}
</select>
<br/>
<input type="submit" value="Register!" />
</form>
${userclasslist}
</body>
</html>