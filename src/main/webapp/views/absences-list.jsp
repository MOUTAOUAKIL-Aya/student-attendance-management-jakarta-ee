<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.esisa.absences.models.Absence" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Absences</title><link rel="stylesheet" href="../css/styles.css"></head>
<body>
<h1>Liste des absences</h1>
<% if(request.getAttribute("mois") != null) { %><h3>Mois : ${mois}</h3><% } %>
<% if(request.getAttribute("idEtudiant") != null) { %><h3>Etudiant ID : ${idEtudiant}</h3><% } %>
<table>
<tr><th>ID</th><th>Etudiant</th><th>Mois</th><th>Jour</th><th>Heure</th><th>Durée</th><th>Matière</th><th>Prof</th></tr>
<%
List<Absence> absences = (List<Absence>)request.getAttribute("absences");
if(absences != null) {
  for(Absence a : absences) {
%>
<tr>
<td><%= a.getId() %></td>
<td><%= a.getEtudiant() == null ? a.getIdEtudiant() : a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom() %></td>
<td><%= a.getMois() %></td><td><%= a.getJour() %></td><td><%= a.getHeure() %>h</td><td><%= a.getDuree() %>h</td>
<td><%= a.getMatiere() == null ? a.getIdMatiere() : a.getMatiere().getNomMatiere() %></td>
<td><%= a.getMatiere() == null ? "" : a.getMatiere().getProfMatiere() %></td>
</tr>
<% }} %>
</table>
<p><a href="../index.html">Accueil</a></p>
</body></html>
