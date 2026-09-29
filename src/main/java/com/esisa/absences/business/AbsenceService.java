package com.esisa.absences.business;

import java.util.List;
import com.esisa.absences.models.Absence;
import com.esisa.absences.models.Etudiant;

public interface AbsenceService {
	
	//specificatin de l'ensemble des services metiers :
    public List<Absence> getAbsencesByMois(int mois);
    public List<Etudiant> getAllEtudiants();
    public List<Etudiant> findEtudiantsByNom(String nom);
    public List<Absence> getAbsencesByEtudiant(int idEtudiant);
}
