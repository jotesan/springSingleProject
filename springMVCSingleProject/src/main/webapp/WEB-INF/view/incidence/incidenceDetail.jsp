<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Incidences</title>

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
		<s:message code="incidencesDetail"></s:message>
	</h1>
	<p>
		<s:message code="incidenceInfo"></s:message>
	</p>

	<c:choose>
		<c:when test="${not empty incidence}">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th><s:message code="name"></s:message></th>
						<th><s:message code="description"></s:message></th>
						<th><s:message code="date"></s:message></th>
						<th><s:message code="type"></s:message></th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${incidence.id}</td>
						<td>${incidence.name}</td>
						<td>${incidence.description}</td>
						<td>${incidence.date}</td>
						<td>${incidence.type.name}</td>
					</tr>
				</tbody>
			</table>


			<c:choose>
				<c:when test="${not empty incidence}">
					<p>These is the incidenceType for this incidence.</p>
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th><s:message code="name"></s:message></th>
								<th>Description</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${incidence.type.id}</td>
								<td>${incidence.type.name}</td>
								<td><a
									href="<s:url value="/incidenceTypes/${incidence.type.id}" />"
									title="Detailed info"> See detail</a> || <a
									href="<c:url value="/incidenceTypes/update/${incidence.type.id}" />">Update</a>
									|| <a
									href="<c:url value="/incidenceTypes/delete/${incidence.type.id}" />">Delete</a></td>
							</tr>
						</tbody>
					</table>
				</c:when>
			</c:choose>
		</c:when>
		<c:otherwise>
			<div>A incidence with the id specified has not been found.
				Please, try again</div>
		</c:otherwise>
	</c:choose>

	<p class="text-muted">&copy; 2017 Joseba Teré</p>

	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>