package com.esisa.absences.dao;

import java.util.List;
import com.esisa.absences.jdbc.Database;
import com.esisa.absences.mapping.ORM;
import com.esisa.absences.models.Etudiant;

public class EtudiantDaoJdbc implements EtudiantDao {
    private String tableName = "etudiants";
    private Database db;
    public EtudiantDaoJdbc(Database db) { this.db = db; }

    public List<Etudiant> selectAll() { return ORM.toEtudiantList(db.selectAll(tableName)); }
    public List<Etudiant> selectByNom(String nom) { return ORM.toEtudiantList(db.selectByKeyword(tableName, "nom", nom)); }
    public Etudiant selectById(int id) {
        String[][] data = db.selectById(tableName, "id", id);
        if (data.length >= 1) return ORM.toEtudiant(data[0]);
        return null;
    }
}
