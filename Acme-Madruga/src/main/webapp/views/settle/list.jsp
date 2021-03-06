<%--
 * 
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
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<jstl:choose>
<jstl:when test="${(selected == true)}">
	<h3><spring:message code="settle.mysettle" /></h3>
</jstl:when>
<jstl:otherwise>
	<h3><spring:message code="settle.available" /></h3>
</jstl:otherwise>
</jstl:choose>
<display:table name="settles" id="row" pagesize="5" requestURI="${requestURI}" 
class="displaytag" >

	<!-- Display -->
	<display:column>
		<a href="settle/display.do?settleId=${row.id}"><spring:message code="settle.display"/></a>
	</display:column>
	
	<!-- Title -->
	<spring:message code="settle.area" var="areaHeader" />
	<display:column  property="area" title="${areaHeader}" />
	
	
</display:table>
