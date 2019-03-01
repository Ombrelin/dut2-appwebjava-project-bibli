<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Médiathèque - Emprunt</title>
</head>
<body>
<h1>Emprunt</h1>
<form method="post">
	<label for="numero">Numéro du document à emprunter: </label>
	<input type="text" name="numero" id="numero"/>
	<input type="submit"/>
</form>
<j:if test="${ !empty erreur }">
	<j:out value="${ erreur }"></j:out>
</j:if>

</body>
</html>