package com.esisa.absences.web.actions;

import java.util.List;
import com.esisa.absences.business.AbsenceService;
import com.esisa.absences.models.Absence;
import com.esisa.absences.models.Etudiant;
import com.esisa.absences.web.Model;

public class AbsenceAction {
    private AbsenceService service;
    public AbsenceAction(AbsenceService service) { this.service = service; }

    public String etudiantsList(Model model) {
        List<Etudiant> etudiants = service.getAllEtudiants();
        model.add("etudiants", etudiants);
        return "etudiants-list";
    }

    public String searchEtudiants(String nom, Model model) {
        List<Etudiant> etudiants = service.findEtudiantsByNom(nom);
        model.add("etudiants", etudiants);
        model.add("nom", nom);
        return "etudiants-list";
    }

    public String absencesByMois(int mois, Model model) {
        List<Absence> absences = service.getAbsencesByMois(mois);
        model.add("absences", absences);
        model.add("mois", mois);
        return "absences-list";
    }

    public String absencesByEtudiant(int idEtudiant, Model model) {
        List<Absence> absences = service.getAbsencesByEtudiant(idEtudiant);
        model.add("absences", absences);
        model.add("idEtudiant", idEtudiant);
        return "absences-list";
    }
}
