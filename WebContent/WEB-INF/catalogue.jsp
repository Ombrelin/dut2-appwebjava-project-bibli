<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ include file="header.jsp" %>
<body class="mdl-grid content-grid">
	<div class="mdl-layout-spacer"></div>
	<div class="mdl-cell mdl-cell--6-col mdl-card mdl-shadow--2dp">
		<div class="mdl-card__title">
			<h2>Catalogue</h2>
		</div>
		<div class="mdl-card__supporting-text mdl-grid content-grid">
			<div class=" mdl-cell mdl-cell--12-col">
				Voici l'ensemble des documents possédés par la médiathèque.
			</div>
			<div class="mdl-layout-spacer"></div>
			<div class=" mdl-cell mdl-cell--12-col">
				<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
					<thead>
						<tr>
							<th class="mdl-data-table__cell--non-numeric">Documents</th>
						</tr>
					</thead>
					<tbody>
						<j:forEach items="${ documents }" var="document">
							<tr><td><j:out value="${ document }"></j:out><br></td></tr>
						</j:forEach>
					</tbody>
				</table>
			</div>
			<div class="mdl-layout-spacer"></div>
		</div>
	</div>
	<div class="mdl-layout-spacer"></div>
</body>