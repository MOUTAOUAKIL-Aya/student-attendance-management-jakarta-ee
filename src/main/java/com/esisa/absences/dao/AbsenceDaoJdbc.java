package com.esisa.absences.dao;

import java.util.List;
import com.esisa.absences.jdbc.Database;
import com.esisa.absences.mapping.ORM;
import com.esisa.absences.models.Absence;

public class AbsenceDaoJdbc implements AbsenceDao {
    private String tableName = "absences";
    private Database db;
    public AbsenceDaoJdbc(Database db) { this.db = db; }

    public List<Absence> selectByMois(int mois) {
        return ORM.toAbsenceList(db.selectById(tableName, "mois", mois));
    }
    public List<Absence> selectByEtudiant(int idEtudiant) {
        return ORM.toAbsenceList(db.selectById(tableName, "id_etudiant", idEtudiant));
    }
}
