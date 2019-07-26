<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<title>Save Customers</title>

<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>

<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<!-- modelAttribute는 Controller의 Attribute name과 같아야 한다. -->
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		<!-- when form is loaded, Spring MVC will call customer.getFirstName(), getLastName()...etc -->
		<!-- when form is submitted, Spring MVC will call customer.setFirstName()...etc -->
		<!-- Form load: Call getters, Form submit: Call setters! -->
		
		<!-- need to associate this data with customer id -->
		<!-- when this form is loaded, they'll say customer.getId() place it here in this hidden form field -->
		<!-- then when they do a submit, they'll submit this data by saying customer.setId() with the appropriate data -->
		<!-- this line is very important. without this line, you'd lose context or the id of the original customer -->
		<!-- so you need to use this line to actually track the customer -->
		<!-- just so the back-end system know which customer to form the update operation on -->
		<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;">
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
		
		</div>
	</div>
</body>

</html>