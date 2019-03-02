<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ include file="header.jsp" %>
<body class="mdl-grid content-grid">
    <div class="mdl-layout-spacer"></div>
    <div class="mdl-card mdl-shadow--2dp mdl-cell mdl-cell--2-col petite-carte">
        <div class="mdl-card__title">
            <h2>Connexion</h2>            
        </div>
        <form method="post">
	        <div class="mdl-card__supporting-text">
		        Bonjour et bienvenue à la BO'thèque. Veuillez vous conncter pour continuer.	            
	            <div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label">            
	                <input class="mdl-textfield__input" type="text" name="login" id="login"/>
	                <label class="mdl-textfield__label" for="login">Login : </label>
	            </div>
	            <div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label">            
	                <input class="mdl-textfield__input" type="password" name="password" id="password"/>
	                <label class="mdl-textfield__label" for="password">Mot de passe : </label>
	            </div>
	            <br>
	            <div class="erreur"><j:out value="${ erreur }"></j:out></div>
	            <br>
	        </div>
	        <div class="mdl-card__actions mdl-card--border mdl-grid content-grid">
	        	<div class="mdl-layout-spacer"></div>
	        	<input class="valider mdl-cell mdl-cell--10-col mdl-button mdl-js-button mdl-button--raised mdl-button--colored" type="submit" value="Connexion"/>
	        	<div class="mdl-layout-spacer"></div>
	        </div>
        </form>
    </div>
    <div class="mdl-layout-spacer"></div>
</body>
</html>