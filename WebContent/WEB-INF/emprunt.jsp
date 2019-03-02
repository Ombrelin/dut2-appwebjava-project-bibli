<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ include file="header.jsp" %>
<body class="mdl-grid content-grid">

<div class="mdl-layout-spacer"></div>
		<div class="mdl-cell mdl-cell--7 mdl-card mdl-shadow--2dp emprunt-retour">
			<div class="mdl-card__title">
				<h2>Emprunt</h2>
			</div>
			<form method="post">
			<div class="mdl-card__supporting-text">
				Veuillez donner le numéro du document que vous voulez emprunter :
					<div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label">    
						
						<input class="mdl-textfield__input" type="text" name="numero" id="numero"/>
						<label class="mdl-textfield__label" for="numero">Numéro... </label>
					</div>
					<j:if test="${ !empty erreur }">
						<j:out value="${ erreur }"></j:out>
					</j:if>
			</div>
			<div class="mdl-card__actions mdl-card--border mdl-grid content-grid">		
				<div class="mdl-layout-spacer"></div>
				<input type="submit" value="Valider" class="valider mdl-js-button mdl-button--raised mdl-button--colored mdl-button mdl-cell mdl-cell--6-col"/>
				<div class="mdl-layout-spacer"></div>
			</div>
			</form>
	</div>
<div class="mdl-layout-spacer"></div>
</body>
</html>