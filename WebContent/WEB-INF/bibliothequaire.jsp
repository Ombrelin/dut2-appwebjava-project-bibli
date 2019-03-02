<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ include file="header.jsp" %>
<body class="mdl-grid content-grid">
	<div class="mdl-layout-spacer"></div>
	<div class="mdl-cell mdl-cell--7 mdl-card mdl-shadow--2dp petite-carte">
		<div class="mdl-card__title">
			<h2>Ajout de document</h2>
		</div>
		<div class="mdl-card__supporting-text">
			Bonjour <j:out value="${ sessionScope.utilisateur }"></j:out>. Vous êtes bibliothécaire
		</div>
		<div class="mdl-card__actions mdl-card--border mdl-grid content-grid">		
			<a class="mdl-cell mdl-cell--12-col mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="<j:url value="${ '/AjoutDocument?typeAjout=1' }"></j:url>">Ajouter un Livre</a>
			<a class="mdl-cell mdl-cell--12-col mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="<j:url value="${ '/AjoutDocument?typeAjout=2' }"></j:url>">Ajouter un DVD</a>
			<a class="mdl-cell mdl-cell--12-col mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="<j:url value="${ '/AjoutDocument?typeAjout=3' }"></j:url>">Ajouter un CD</a>		
			<a class="mdl-cell mdl-cell--12-col mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="<j:url value="/Deconnexion"></j:url>" id="logout">Déconnexion</a>
		</div>
	</div>
	<div class="mdl-layout-spacer"></div>
</body>