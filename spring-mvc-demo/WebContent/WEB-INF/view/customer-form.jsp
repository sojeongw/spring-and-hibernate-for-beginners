<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<title>Customer Registration Form</title>

<style>
/* form:errors에 사용된 cssClass */
	.error{color:red}
</style>
</head>

<body>

<i>Fill out the form. Asterisk (*) means required.</i>

	<form:form action="processForm" modelAttribute="customer">
		
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name (*): <form:input path="lastName"/>
		
		<!-- display error message(if set) -->
		<!-- cssClass는 head에서 css style을 설정하는 class에 사용됨. -->
		<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		
		<input type="submit" value="Submit"/>
		
	</form:form>

</body>

</html>