<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Médiatheque - Connexion</title>
</head>
<body>
<form method="post">

<label for="login">Login : </label>
<input type="text" name="login" id="login"/>

<label for="password">Mot de passe : </label>
<input type="password" name="password" id="password"/>

<input type="submit" value="Connexion"/>
<j:out value="${ erreur }"></j:out>
</form>
</body>
</html>