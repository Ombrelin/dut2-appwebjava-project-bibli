<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Médiatheque - Bienvenue</title>
</head>
<body>
Bonjour <j:out value="${ sessionScope.utilisateur }"></j:out>. Vous êtes bibliothèquaire

<a href="<j:url value="${ '/AjoutDocument?typeAjout=1' }"></j:url>">Ajouter un Livre</a>
<a href="<j:url value="${ '/AjoutDocument?typeAjout=2' }"></j:url>">Ajouter un DVD</a>
<a href="<j:url value="${ '/AjoutDocument?typeAjout=3' }"></j:url>">Ajouter un CD</a>

<a href="<j:url value="/Deconnexion"></j:url>">Déconnexion</a>
</body>
</html>