<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>


<form:form method="get" commandName="accountLookupFormBean">
	<spring:hasBindErrors name="user">
	<font color="red">
	<p>There were ${errors.errorCount} error(s) in total:</p>
	<ul>
		<c:forEach var="errMsgObj" items="${errors.allErrors}">
			<li><spring:message code="${errMsgObj.code}"
				text="${errMsgObj.defaultMessage}" /></li>
		</c:forEach>
	</ul>
	</font>
	</spring:hasBindErrors>
	<table border="0" cellpadding="5" cellspacing="0" align="center">
	<tr>
		<td> Search Name:</td>
		<td><form:input path="searchString"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="button.submit"/>">
		</td> 
		<td><input type="reset"/></td>
	</tr>
	</table>
</form:form>

<table border="0" cellpadding="5" cellspacing="0" align="center" width="40%">
<thead>
<tr align="center">             
	<th>Account Number</th>             
	<th>First Name</th>             
	<th>Last Name</th>
	<th>Active</th>
	<th>Start Date</th>
	<th>End Date</th>
	<th>Home Phone</th>
	<th>Cell Phone</th>   
</tr>
</thead>
<tbody>
<c:forEach var="account" items="${accountLookupFormBean.accountList}">
	<tr align="center">
		<td>
			<a href=""><c:out value="${account.accountNumber}"/></a>
		</td>
		<td>
			<c:out value="${account.contact.firstName}"/>		
		</td>
		<td>
			<c:out value="${account.contact.lastName}"/>	
		</td>
		<td>
			<c:out value="${account.activeFlag}"/>
		</td>
		<td>
			<c:out value="${account.startDate}"/>
		</td>
		<td>
			<c:out value="${account.endDate}"/>
		</td>
		<td>
			<c:out value="${contact.contactHome}"/>
		</td>
		<td>
			<c:out value="${contact.contactCell}"/>
		</td>
		
	</tr>
</c:forEach>
</tbody>
</table>

