package com.esisa.absences.models;

public class Matiere {
    private int id;
    private String nomMatiere;
    private String profMatiere;

    public Matiere() {}
    public Matiere(int id, String nomMatiere, String profMatiere) {
        this.id = id; this.nomMatiere = nomMatiere; this.profMatiere = profMatiere;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomMatiere() { return nomMatiere; }
    public void setNomMatiere(String nomMatiere) { this.nomMatiere = nomMatiere; }
    public String getProfMatiere() { return profMatiere; }
    public void setProfMatiere(String profMatiere) { this.profMatiere = profMatiere; }
}
