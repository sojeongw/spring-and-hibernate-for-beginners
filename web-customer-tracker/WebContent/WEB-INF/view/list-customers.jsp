<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->
<!-- pageContext.request.contextPath give us the proper name of the app location. -->
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>


<div id="container">
	<div id="content">
		<!-- put new button: Add Customer -->
		<!-- it's gonna call Spring Controller URL mapping 'showFormForAdd' -->
		<!-- and add CSS style "add-button" -->
		<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
				
	<!--  add a search box -->
    <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
        <input type="submit" value="Search" class="add-button" />
  	</form:form>
				
		<!-- add our html table here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<!-- loop over and print our customers -->
			<!-- items의 값이 CustomerController에서 attribute name으로 지정한 값이다. -->
			<c:forEach var="tempCustomer" items="${customers}">
			
			<!-- construct an "update" link with customer id -->
			<!-- we make use of the jstl custom tag for c:url -->
			<!-- updateLink is variable name and value is the url mapping -->
			<c:url var="updateLink" value="/customer/showFormForUpdate">
			
			<!-- customerId에 tempCustomer id를 담는다. -->
			<!-- we're gonna create this variable called update link and add a parameter on it called customer id -->
			<!-- and we'll plug in that actual customer's id that we're currently at in the loop -->
			<!-- each customer has their own unique id and we're gonna use that -->
			<!-- to retrieve the customer from the database and prepoluate a form -->
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
			<!-- construct an "delete" link with customer id -->
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					
					<td>
						<!-- display the update link -->
						<!-- href 값은 위에서 url var로 설정해준 이름과 동일하게 한다. -->
						<a href="${ updateLink }">Update</a>
						| 
						<a href="${ deleteLink }"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>

</html>