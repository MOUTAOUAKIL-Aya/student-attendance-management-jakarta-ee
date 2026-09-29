package com.esisa.absences.dao;

import java.util.List;
import com.esisa.absences.models.Etudiant;

public interface EtudiantDao {
    public List<Etudiant> selectAll();
    public List<Etudiant> selectByNom(String nom);
    public Etudiant selectById(int id);
}
