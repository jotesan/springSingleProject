<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Update incidence</title>

<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

	<a href="#"><s:message code="incidencesApp"></s:message></a>
	<ul>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-expanded="true"><s:message
					code="language"></s:message> <span class="caret"></span> </a>
			<ul class="dropdown-menu" role="menu">
				<li><a href="?locale=en"><img src="blank.gif"
						class="flag flag-gb" alt="<s:message code="english"></s:message>" />
						<s:message code="english"></s:message></a></li>
				<li><a href="?locale=es"><img src="blank.gif"
						class="flag flag-es" alt="<s:message code="spanish"></s:message>" />
						<s:message code="spanish"></s:message></a></li>
			</ul></li>
	</ul>
	<ul>
		<li><a href="<s:url value="/incidences/" />"
			title="<s:message code="incidences"></s:message>"><s:message
					code="incidences"></s:message></a></li>
		<li><a href="<s:url value="/incidences/new" />"
			title="<s:message code="newIncidence"></s:message>"><s:message
					code="newIncidence"></s:message></a></li>
	</ul>

	<h1>
		<s:message code="updateIncidence"></s:message>
	</h1>
	<s:url var="action" value="/incidences/saveupdate" />
	<sf:form id="updateIncidenceForm" method="post" action="${action}" modelAttribute="incidence">
		<sf:hidden path="id" />
		<div class="form-group">
			<label for="name"><s:message code="name"></s:message></label>
			<sf:input path="name" placeholder="Name" />
			<sf:errors path="name" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="description"><s:message code="description"></s:message></label>
			<sf:textarea path="description" placeholder="Description" />
			<sf:errors path="description" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="date"><s:message code="date"></s:message></label>
			<sf:input path="date" placeholder="Date" />
			<sf:errors path="date" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="type"><s:message code="type"></s:message></label>
			<sf:select path="type.id">
				<sf:options items="${incidenceTypes}" itemLabel="name"
					itemValue="id" />
			</sf:select>
		</div>
		<sf:button>
			<s:message code="update"></s:message>
		</sf:button>
	</sf:form>

	<p class="text-muted">&copy; 2017 Joseba Teré</p>

	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
	<script src="<c:url value="/resources/js/validateIncidenceUpdateForm.js" />"></script>
</body>
</html>
