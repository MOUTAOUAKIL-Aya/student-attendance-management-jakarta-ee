package com.esisa.absences.business;

import java.util.List;
import com.esisa.absences.dao.AbsenceDao;
import com.esisa.absences.dao.EtudiantDao;
import com.esisa.absences.dao.MatiereDao;
import com.esisa.absences.models.Absence;
import com.esisa.absences.models.Etudiant;

/*
 * Classe metier : business class
 * => son implementation sera basée sur la couche DAO
 */

public class AbsenceServiceDefault implements AbsenceService {
    private EtudiantDao etudiantDao;
    private MatiereDao matiereDao;
    private AbsenceDao absenceDao;

    public AbsenceServiceDefault(EtudiantDao etudiantDao, MatiereDao matiereDao, AbsenceDao absenceDao) {
        this.etudiantDao = etudiantDao;
        this.matiereDao = matiereDao;
        this.absenceDao = absenceDao;
    }

    public List<Absence> getAbsencesByMois(int mois) {
        List<Absence> list = absenceDao.selectByMois(mois);
        complete(list);
        return list;
    }
    public List<Etudiant> getAllEtudiants() { return etudiantDao.selectAll(); }
    public List<Etudiant> findEtudiantsByNom(String nom) { return etudiantDao.selectByNom(nom); }
    public List<Absence> getAbsencesByEtudiant(int idEtudiant) {
        List<Absence> list = absenceDao.selectByEtudiant(idEtudiant);
        complete(list);
        return list;
    }

    private void complete(List<Absence> list) {
        for (Absence a : list) {
            a.setEtudiant(etudiantDao.selectById(a.getIdEtudiant()));
            a.setMatiere(matiereDao.selectById(a.getIdMatiere()));
        }
    }
}
