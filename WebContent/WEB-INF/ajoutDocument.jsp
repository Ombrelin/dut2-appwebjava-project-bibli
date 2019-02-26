<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Médiatheque - Ajout document</title>
</head>
<body>
	<form method="post">
		<input type="hidden" name="typeAjout"
			value="<j:out value="${ typeAjout }"></j:out>" /> <label for="titre">Titre</label>
		<input type="text" id="titre" name="titre" required /> <label
			for="date">Date de parution</label> <input type="date" id="date"
			name="date" required />

		<j:if test="${ typeAjout == '1' }">
			<label for="auteur">Auteur du livre : </label>
			<input type="text" id="auteur" name="auteur" required />
		</j:if>

		<j:if test="${ typeAjout == '2' }">
			<label for="realisateur">Réalisateur du film : </label>
			<input type="text" id="realisateur" name="realisateur" required />

			<label for="qualite">Réalisateur du film : </label>
			<select id="qualite" name="qualite" required>
				<option value="SD">Définition Standard (SD - 480p)</option>
				<option value="HD">Haute Définition (HD - 720p)</option>
				<option value="FULLHD">Très Haute Définition (FHD - 1080p)</option>
				<option value="UHD">Ultra haute Définition (UHD - 4K)</option>
			</select>
		</j:if>

		<j:if test="${ typeAjout == 	'3' }">
			<label for="artiste">Réalisateur du film : </label>
			<input type="text" id="artiste" name="artiste" required />
			<label for="genre">Réalisateur du film : </label>
			<input type="text" id="genre" name="genre" required />
		</j:if>
		<input type="submit" value="Ajouter le document" />
	</form>

</body>
</html>