<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<form:form method="post" action="/library/mediaLookup.htm">
<spring:hasBindErrors name="cartBean">
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
	<table border="0" cellpadding="5" cellspacing="0" align="center" width="40%">
		<tr align="center">  
			<td><spring:message code="label.account.number"/></td>
			<td><c:out value="${cartBean.account.accountNumber}"/></td>
		</tr>
		<tr align="center">  
			<td><spring:message code="label.contact.name"/></td>
			<td><c:out value="${cartBean.account.contact.firstName} "/><c:out value="${cartBean.account.contact.lastName}"/></td>
		</tr>
		<tr align="center">  
			<td><spring:message code="label.account.enddate"/></td>
			<td><c:out value="${cartBean.account.endDate}"/></td>
		</tr>
		<tr align="center">  
			<td><spring:message code="label.medialending.feepaid"/></td>
			<td><c:out value="${cartBean.account.fee.paid}"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="<spring:message code="button.additem"/>"></td>
		</tr>
	</table>
</form:form>

<table border="0" cellpadding="5" cellspacing="0" align="center" width="40%">
<thead>
<tr align="center">             
	<th><spring:message code="label.media.title"/></th>
	<th><spring:message code="label.media.author"/></th>
	<th><spring:message code="label.media.type"/></th>
	<th><spring:message code="label.media.category"/></th>
	<th><spring:message code="label.medialending.lendingdate"/></th>
	<th><spring:message code="label.medialending.returndate"/></th>
	<th><spring:message code="label.medialending.latefee"/></th>
	<th><spring:message code="label.medialending.feepaid"/></th>
</tr>
</thead>
<tbody>
<c:forEach var="issuedItem" items="${cartBean.issuedItems}">
	<tr align="center">
		<td>
			<c:out value="${issuedItem.media.title}"/>	
			<c:if test="${issuedItem.media.totalVolume > 1}">
				- <c:out value="${issuedItem.media.volumeNumber}"/>
			</c:if>	
		</td>
		<td>
			<c:out value="${issuedItem.media.author}"/>	
		</td>
		<td>
			<c:out value="${issuedItem.media.mediaType.mediaType}"/>	
		</td>
		<td>
			<c:out value="${issuedItem.media.category.category}"/>	
		</td>
		<td>
			<c:out value="${issuedItem.lendingDate}"/>	
		</td>
		<td>
			<c:out value="${issuedItem.returnDate}"/>	
		</td>
		<td>
			$<c:out value="${issuedItem.fee.amount}"/>	
		</td>
		<td>
			<select>
			  <option value="n">No</option>
			  <option value="y">Yes</option>
			</select>
		</td>
		<td>
			<a href="<%= request.getContextPath() %>/cart.htm?action=returnItem&mediaLendingId=${issuedItem.id}&paid=${issuedItem.fee.paid}"><spring:message code="label.returnitem"/></a>	
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<center> ------------------------------- </center>
<table border="0" cellpadding="5" cellspacing="0" align="center" width="40%">
<tbody>
<thead>
<tr align="center">             
	<th><spring:message code="label.media.title"/></th>
	<th><spring:message code="label.media.author"/></th>
	<th><spring:message code="label.media.type"/></th>
	<th><spring:message code="label.media.category"/></th>
	<th><spring:message code="label.medialending.returndate"/></th>
</tr>
</thead>
<tbody>
<c:forEach var="checkoutItem" items="${cartBean.checkoutItems}">
	<tr align="center">
		<td>
			<c:out value="${checkoutItem.media.title}"/>	
			<c:if test="${checkoutItem.media.totalVolume > 1}">
				- <c:out value="${checkoutItem.media.volumeNumber}"/>
			</c:if>		
		</td>
		<td>
			<c:out value="${checkoutItem.media.author}"/>	
		</td>
		<td>
			<c:out value="${checkoutItem.media.mediaType.mediaType}"/>	
		</td>
		<td>
			<c:out value="${checkoutItem.media.category.category}"/>	
		</td>
		<td>
			<c:out value="${checkoutItem.returnDate}"/>	
		</td>
		<td>
			<a href="<%= request.getContextPath() %>/cart.htm?action=removeFromCart&mediaId=${checkoutItem.media.id}"><spring:message code="label.removefromcart"/></a>	
		</td>
	</tr>
</c:forEach>
</tbody>
</table>

<form:form method="post" action="/library/cart.htm?action=checkout">
	<table border="0" cellpadding="5" cellspacing="0" align="center" width="40%">
		<tr>
			<td><input type="submit" value="<spring:message code="button.checkout"/>"></td>
		</tr>
	</table>
</form:form>


