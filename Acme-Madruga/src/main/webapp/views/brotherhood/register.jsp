<%--
 * register.jsp
 *
 * Copyright (C) 2019 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
		

	<form:form action="brotherhood/register.do" modelAttribute="brotherhoodForm">
		
		<form:hidden path="id" />
		
		<fieldset>
    	<legend><spring:message code="brotherhood.fieldset.personalInformation"/></legend>
		<acme:textbox code="brotherhood.name" path="name" placeholder="Homer"/>
		<acme:textbox code="brotherhood.middleName" path="middleName" placeholder="Jay"/>
		<acme:textbox code="brotherhood.surname" path="surname" placeholder="Simpson"/>
		<acme:textbox code="brotherhood.photo" path="photo" placeholder="https://www.jazzguitar.be/images/bio/homer-simpson.jpg"/>
		<acme:textbox code="brotherhood.email" path="email" placeholder="homerjsimpson@email.com"/>
		<acme:textbox code="brotherhood.phone" path="phone" placeholder="+34 600 1234"/>
		<acme:textbox code="brotherhood.address" path="address" placeholder="123 Main St Anytown, Australia"/>
		<acme:textbox code="brotherhood.title" path="title" placeholder="La Pasion"/>
		</fieldset>
		<br/>
		
		<fieldset>
    	<legend><spring:message code="brotherhood.fieldset.userAccount"/></legend>
		<acme:textbox code="brotherhood.username" path="username" placeholder="HomerS"/>
		
		<acme:password code="brotherhood.password" path="password"/>
		<acme:password code="brotherhood.passwordChecker" path="passwordChecker"/>
		
		</fieldset>
		<br/>
		
		<%-- <acme:submit name="register" code="brotherhood.save"/> --%>

		<input type="submit" name="register" id="register"
		value="<spring:message code="brotherhood.save" />" >&nbsp; 
		
		<acme:cancel url="welcome/index.do" code="brotherhood.cancel"/>
	</form:form>
	
	<script type="text/javascript">
$("#register").on("click",function(){validatePhone("<spring:message code='brotherhood.confirmationPhone'/>","${countryCode}");});


	 
</script>