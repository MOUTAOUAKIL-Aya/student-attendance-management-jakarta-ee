package com.esisa.absences.models;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String niveau;
    private String groupe;

    public Etudiant() {}

    public Etudiant(int id, String nom, String prenom, String tel, String email, String niveau, String groupe) {
        this.id = id; this.nom = nom; this.prenom = prenom; this.tel = tel;
        this.email = email; this.niveau = niveau; this.groupe = groupe;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }
    public String getGroupe() { return groupe; }
    public void setGroupe(String groupe) { this.groupe = groupe; }
}
