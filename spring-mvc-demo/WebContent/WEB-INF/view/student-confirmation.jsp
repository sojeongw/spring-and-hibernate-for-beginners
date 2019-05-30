<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- array를 출력하기 위한 JSTL tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<title>Student confirmation</title>
</head>

<body>

<!-- this calls student.getFirstName() & student.getLastName -->
The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

<!-- Spring will call student.getCountry() -->
Country: ${student.country}

<br><br>

<!-- Spring will call student.getFavoriteLanguage -->
Favorite Language: ${student.favoriteLanguage}

<br><br>

<!-- Spring will call student.getOperatingSystems -->
Operating Systems: 

<ul>
	<!-- items will call student.getOperatingSystems -->
	<c:forEach var="temp" items="${student.operatingSystems}">
	<li>${temp}</li>
	</c:forEach>
</ul>

</body>

</html>