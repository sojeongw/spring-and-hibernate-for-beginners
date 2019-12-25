<!-- spring form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- add JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

<title>Custom Login Page</title>

<style>
.failed {
	color: red;
}
</style>

</head>

<body>
	<h3>My Custom Login Page</h3>

	<!-- security config에 있는 loginProcessingUrl을 그대로 적용 -->
	<form:form
		action="${ pageContext.request.contextPath }/authenticateTheUser"
		method="POST">

		<!-- Check for login error -->
		<c:if test="${ param.error != null }">
			<i class="failed">Sorry! You entered invalid username/password</i>
		</c:if>
		<p>
			<!-- Spring Security Filters will read form data(name="username") and authenticate the user. 따라서 정확히 name을 써줘야 함. -->
			User name: <input type="text" name="username" />
		</p>
		<p>
			<!-- Spring Security Filters will read form data(name="password") and authenticate the user. 따라서 정확히 name을 써줘야 함.-->
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />
	</form:form>
</body>
</html>