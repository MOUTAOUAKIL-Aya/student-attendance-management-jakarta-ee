package com.esisa.absences.mapping;

import java.util.List;
import java.util.Vector;

import com.esisa.absences.models.Absence;
import com.esisa.absences.models.Etudiant;
import com.esisa.absences.models.Matiere;

public class ORM {
    public static int toInt(String value) {
        try { return Integer.parseInt(value); }
        catch (Exception e) { return 0; }
    }

    public static Etudiant toEtudiant(String... row) {
        return new Etudiant(toInt(row[0]), row[1], row[2], row[3], row[4], row[5], row[6]);
    }
    public static List<Etudiant> toEtudiantList(String[][] data) {
        List<Etudiant> list = new Vector<Etudiant>();
        for (String[] row : data) list.add(toEtudiant(row));
        return list;
    }

    public static Matiere toMatiere(String... row) {
        return new Matiere(toInt(row[0]), row[1], row[2]);
    }
    public static List<Matiere> toMatiereList(String[][] data) {
        List<Matiere> list = new Vector<Matiere>();
        for (String[] row : data) list.add(toMatiere(row));
        return list;
    }

    public static Absence toAbsence(String... row) {
        return new Absence(toInt(row[0]), toInt(row[1]), toInt(row[2]), toInt(row[3]), toInt(row[4]), toInt(row[5]), toInt(row[6]));
    }
    public static List<Absence> toAbsenceList(String[][] data) {
        List<Absence> list = new Vector<Absence>();
        for (String[] row : data) list.add(toAbsence(row));
        return list;
    }
}
