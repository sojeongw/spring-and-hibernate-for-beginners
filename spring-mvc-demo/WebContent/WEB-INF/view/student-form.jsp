<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<title>Student Registration Form</title>
</head>

<body>

<!-- 컨트롤러에 있는 attribute 이름과 반드시 일치해야 한다. -->
<form:form action="processForm" modelAttribute="student">

<!-- path의 내용은 Student 클래스의 property이다. -->
<!-- when form is loaded, Spring MVC call getFirstName() -->
<!-- when form is submitted, Spring MVC call setFirstName() -->
First name: <form:input path="firstName"/>
<br><br>

Last name: <form:input path="lastName"/>
<br><br>

Country:

<!-- on submit, Spring will call student.setCountry() -->
<form:select path="country">
	<%--
	<form:option value="brazil" label="Brazil"/>
	<form:option value="France" label="France"/>
	<form:option value="Germany" label="Germany"/>
	<form:option value="India" label="India"/> 
	--%>
	
	<!-- hashmap으로 바꾼 후 -->
	<!-- spring will call student.getCountryOptions -->
	<!-- items refer to the collection of data -->
	<form:options items="${student.countryOptions}"/>
	
	
</form:select>
<br><br>

Favorite Language:

<!-- On submit, Spring will call student.setFavoriteLanguage() -->
<%-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/> --%>

<!-- hashmap -->
<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>

<br><br>

Operating Systems:

<!-- On submit, Spring will call student.setOperatingSystems() -->
Linux <form:checkbox path="operatingSystems" value="Linux"/>
Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>

<br><br>
<input type="submit" value="Submit"/>

</form:form>

</body>

</html>