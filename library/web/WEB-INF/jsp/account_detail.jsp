<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page import="com.library.util.DateUtil"%>
<BR>
<BR>
<form:form method="post" commandName="account" action="/library/viewAccount.htm">
	<form:hidden path="id"/>
	<form:hidden path="accountNumber"/>
	<form:hidden path="accountType.id"/>
	<form:hidden path="contact.id"/>
	<form:hidden path="fee.id"/>	
	<form:hidden path="fee.amount"/>
	<form:hidden path="fee.feeType"/>	
		<spring:hasBindErrors name="account">
         <font color="red">
         <p>There were ${errors.errorCount} error(s) in total:</p>
         <ul>
            <c:forEach var="errMsgObj" items="${errors.allErrors}">
               <li>
                  <spring:message code="${errMsgObj.code}" text="${errMsgObj.defaultMessage}"/>
               </li>
            </c:forEach>
         </ul>
         </font>
      	</spring:hasBindErrors>
	<table border="0" cellpadding="5" cellspacing="0" align="center">
	<tr>
		<td> First Name*:</td><td><form:input path="contact.firstName"/></td>
		<td> Last Name*:</td><td><form:input path="contact.lastName"/></td>
	</tr>
	<tr>
		<td> Known As:</td><td><form:input path="contact.alias"/></td>
		<td> Street*: </td><td><form:input path="contact.streetAddress"/></td>
	</tr>
	<tr>
		<td> City*: </td><td><form:input path="contact.city"/></td>
		<td> State*: </td><td>
		<form:select path="contact.state">
		<form:option value="NJ"></form:option>
		<form:option value="NY"></form:option>
		<form:option value="CT"></form:option>
		<form:option value="PA"></form:option>
		<form:option value="DE"></form:option>
		<form:option value="VA"></form:option>
		<form:option value="MD"></form:option>
		</form:select>
		</td>
	</tr>
	<tr>
		<td> Country*: </td><td>
		<form:select path="contact.country">
		<form:option value="USA"></form:option>
		</form:select>
		</td>
		<td> Home Phone*: </td><td><form:input path="contact.contactHome"/></td>
	</tr>
	<tr>
		<td> Cell Phone: </td><td><form:input path="contact.contactCell"/></td>
		<td> Account Type*:</td><td>
		<form:select path="accountType.accountType">
		<form:option value="regular"></form:option>
		</form:select></td>
	</tr>
	<tr>
	  	<td> Start Date (<%=DateUtil.dateFormat %>):</td><td><form:input path="startDate"/></td>
	  	<td> End Date (<%=DateUtil.dateFormat %>):</td><td><form:input path="endDate"/></td>
	</tr>
	<tr>
		<td> Registration Fee: </td><td>$50.00<!-- <c:out value="${account.accountType.registrationFee}"/>--></td>
		<td> Paid:</td><td>
			<form:select path="fee.paid">
			<form:option value=""></form:option>
			<form:option value="n"></form:option>
			<form:option value="y"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="button.submit"/>"></td> 
		<td><input type="reset"/></td>
		<td><input type="button" onclick=window.location.href="<%=request.getContextPath() %>/viewCart.htm?accountId=${account.id}" value="<spring:message code='label.viewcart'/>"/></td>
	</tr>
	</table>
</form:form>