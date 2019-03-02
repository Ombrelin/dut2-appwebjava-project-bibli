<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ include file="header.jsp" %>
<body class="mdl-grid content-grid">
<div class="mdl-layout-spacer"></div>
	<div class="mdl-cell mdl-cell--7 mdl-card mdl-shadow--2dp " id="addDoc">
		<div class="mdl-card__title">
			<h2>Ajouter un document</h2>
		</div>	
	<form method="post">
		<div class="mdl-card__supporting-text">
		<input type="hidden" name="typeAjout" value="<j:out value="${ typeAjout }"></j:out>" /> 
		<div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label"> 				
			<input class="mdl-textfield__input" type="text" id="titre" name="titre"  />
			<label class="mdl-textfield__label" for="titre">Titre</label>
		</div>
		
		Date de parution : 
		<div class="fill mdl-textfield mdl-js-textfield"> 
			<input class="mdl-textfield__input" type="date" id="date" name="date"  />		
			<label class="mdl-textfield__label" for="date"></label> 					
		</div>
		
		<j:if test="${ typeAjout == '1' }">
			<div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label"> 
				<input class="mdl-textfield__input" type="text" id="auteur" name="auteur"  />
				<label class="mdl-textfield__label" for="auteur">Auteur du livre : </label>
			</div>
		</j:if>

		<j:if test="${ typeAjout == '2' }">
			<div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label"> 
				<label class="mdl-textfield__label" for="realisateur">Réalisateur du film : </label>
				<input class="mdl-textfield__input" type="text" id="realisateur" name="realisateur"  />
			</div>
			
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select fill">
		        <input type="text" value="" class="mdl-textfield__input" id="qualite" readonly>
		        <input type="hidden" value="" name="qualite">
		        <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
		        <label for="sample4" class="mdl-textfield__label">Qualité : </label>
		        <ul for="qualite" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
		            <li class="mdl-menu__item" data-val="SD">Définition Standard (SD - 480p)</li>
		            <li class="mdl-menu__item" data-val="HD">Haute Définition (HD - 720p)</li>
		            <li class="mdl-menu__item" data-val="FULLHD">Très Haute Définition (FHD - 1080p)</li>
		            <li class="mdl-menu__item" data-val="UHD">Ultra haute Définition (UHD - 4K)</li>
		        </ul>
    		</div>
    		<br><br><br><br><br><br><br><br><br><br><br><br>
		</j:if>

		<j:if test="${ typeAjout == 	'3' }">
			<div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label"> 
				<input class="mdl-textfield__input" type="text" id="artiste" name="artiste"  />
				<label class="mdl-textfield__label" for="artiste">Artiste : </label>
			</div>			
			<div class="fill mdl-textfield mdl-js-textfield mdl-textfield--floating-label"> 
				<input class="mdl-textfield__input" type="text" id="genre" name="genre"  />
				<label class="mdl-textfield__label"  for="genre">Genre : </label>
			</div>
		</j:if>
		<div class="mdl-card__actions mdl-card--border mdl-grid content-grid">
			<div class="mdl-layout-spacer"></div>
			<input type="submit" value="Ajouter le document" class="valider mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-cell mdl-cell--8-col" />
			<div class="mdl-layout-spacer"></div>
		</div>
		</div>
	</form>
</div>
<div class="mdl-layout-spacer"></div>
</body>
</html>