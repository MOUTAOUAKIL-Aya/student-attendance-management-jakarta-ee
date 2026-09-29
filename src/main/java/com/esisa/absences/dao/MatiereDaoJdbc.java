package com.esisa.absences.dao;

import com.esisa.absences.jdbc.Database;
import com.esisa.absences.mapping.ORM;
import com.esisa.absences.models.Matiere;

public class MatiereDaoJdbc implements MatiereDao {
    private String tableName = "matieres";
    private Database db;
    public MatiereDaoJdbc(Database db) { this.db = db; }
    public Matiere selectById(int id) {
        String[][] data = db.selectById(tableName, "id", id);
        if (data.length >= 1) return ORM.toMatiere(data[0]);
        return null;
    }
}
