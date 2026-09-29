package com.esisa.absences.models;

public class Absence {
    private int id;
    private int idEtudiant;
    private int mois;
    private int jour;
    private int heure;
    private int duree;
    private int idMatiere;

    private Etudiant etudiant;
    private Matiere matiere;

    public Absence() {}
    public Absence(int id, int idEtudiant, int mois, int jour, int heure, int duree, int idMatiere) {
        this.id = id; this.idEtudiant = idEtudiant; this.mois = mois; this.jour = jour;
        this.heure = heure; this.duree = duree; this.idMatiere = idMatiere;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdEtudiant() { return idEtudiant; }
    public void setIdEtudiant(int idEtudiant) { this.idEtudiant = idEtudiant; }
    public int getMois() { return mois; }
    public void setMois(int mois) { this.mois = mois; }
    public int getJour() { return jour; }
    public void setJour(int jour) { this.jour = jour; }
    public int getHeure() { return heure; }
    public void setHeure(int heure) { this.heure = heure; }
    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }
    public int getIdMatiere() { return idMatiere; }
    public void setIdMatiere(int idMatiere) { this.idMatiere = idMatiere; }
    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }
    public Matiere getMatiere() { return matiere; }
    public void setMatiere(Matiere matiere) { this.matiere = matiere; }
}
