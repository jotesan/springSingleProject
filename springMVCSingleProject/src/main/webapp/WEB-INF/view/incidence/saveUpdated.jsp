<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<html>
<head>
<title>SaveUpdate.jsp</title>

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

	<h1>Ok, incidence ${incidence.id} called ${incidence.name} was
		UPDATED</h1>

	<p>&copy; 2017 Joseba Teré</p>

	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>
