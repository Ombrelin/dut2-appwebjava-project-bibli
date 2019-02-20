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
Bonjour <j:out value="${ sessionScope.utilisateur }"></j:out>
</body>
</html>