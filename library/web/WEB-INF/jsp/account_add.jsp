<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page import="com.library.util.DateUtil"%>

<form:form method="post" commandName="account" action="/library/addAccount.htm">
	<table border="0" cellpadding="5" cellspacing="0" align="center">
	<tr>
		<td> First Name:</td><td><form:input path="contact.firstName"/></td>
		<td> Last Name:</td><td><form:input path="contact.lastName"/></td>
		<td> Known As:</td><td><form:input path="contact.alias"/></td>
	</tr>
	<tr>
		<td> Street: </td><td><form:input path="contact.streetAddress"/></td>
		<td> City: </td><td><form:input path="contact.city"/></td>
		<td> State: </td><td><form:input path="contact.state"/></td>
	</tr>
	<tr>
		<td> Country: </td><td><form:input path="contact.country"/></td>
		<td> Home Phone: </td><td><form:input path="contact.contactHome"/></td>
		<td> Cell Phone: </td><td><form:input path="contact.contactCell"/></td>
	</tr>
	<tr>
<!--  	<td> Start Date (<%=DateUtil.dateFormat %>):</td><td><form:input path="startDate"/></td>
		<td> End Date (<%=DateUtil.dateFormat %>):</td><td><form:input path="endDate"/></td>
-->
		<td> Account Type:</td><td><form:input path="accountType.accountType"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="button.submit"/>">
		</td> 
		<td><input type="reset"/></td>
	</tr>
	</table>
</form:form>