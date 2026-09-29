package com.esisa.absences.dao;

import java.util.List;
import com.esisa.absences.models.Absence;

public interface AbsenceDao {
    public List<Absence> selectByMois(int mois);
    public List<Absence> selectByEtudiant(int idEtudiant);
}
