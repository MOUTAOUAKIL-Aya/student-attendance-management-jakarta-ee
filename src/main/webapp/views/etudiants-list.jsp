<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.esisa.absences.models.Etudiant" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Etudiants</title><link rel="stylesheet" href="../css/styles.css"></head>
<body>
<h1>Liste des étudiants</h1>
<% if(request.getAttribute("nom") != null) { %>
<h3>Recherche par nom : ${nom}</h3>
<% } %>
<table>
<tr><th>ID</th><th>Nom</th><th>Prénom</th><th>Téléphone</th><th>Email</th><th>Niveau</th><th>Groupe</th><th>Absences</th></tr>
<%
List<Etudiant> etudiants = (List<Etudiant>)request.getAttribute("etudiants");
if(etudiants != null) {
  for(Etudiant e : etudiants) {
%>
<tr>
<td><%= e.getId() %></td><td><%= e.getNom() %></td><td><%= e.getPrenom() %></td><td><%= e.getTel() %></td>
<td><%= e.getEmail() %></td><td><%= e.getNiveau() %></td><td><%= e.getGroupe() %></td>
<td><a href="absences-etudiant?id=<%= e.getId() %>">voir</a></td>
</tr>
<% }} %>
</table>
<p><a href="../index.html">Accueil</a></p>
</body></html>
