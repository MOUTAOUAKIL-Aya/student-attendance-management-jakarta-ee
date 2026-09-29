package com.esisa.absences.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.esisa.absences.business.AbsenceService;
import com.esisa.absences.business.AbsenceServiceDefault;
import com.esisa.absences.dao.AbsenceDao;
import com.esisa.absences.dao.AbsenceDaoJdbc;
import com.esisa.absences.dao.EtudiantDao;
import com.esisa.absences.dao.EtudiantDaoJdbc;
import com.esisa.absences.dao.MatiereDao;
import com.esisa.absences.dao.MatiereDaoJdbc;
import com.esisa.absences.jdbc.DataSource;
import com.esisa.absences.jdbc.Database;
import com.esisa.absences.jdbc.MySQLDataSource;
import com.esisa.absences.mapping.ORM;
import com.esisa.absences.web.actions.AbsenceAction;

@WebServlet({ "/absences/*", "*.do" })
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AbsenceAction absenceAction;

    public void init() throws ServletException {
        DataSource ds = new MySQLDataSource("absences");
        Database db = new Database(ds);
        EtudiantDao etudiantDao = new EtudiantDaoJdbc(db);
        MatiereDao matiereDao = new MatiereDaoJdbc(db);
        AbsenceDao absenceDao = new AbsenceDaoJdbc(db);
        AbsenceService service = new AbsenceServiceDefault(etudiantDao, matiereDao, absenceDao);
        absenceAction = new AbsenceAction(service);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String view;
        Model model = new Model();

        if (uri.endsWith("/get-all-etudiants")) {
            view = absenceAction.etudiantsList(model);
        }
        else if (uri.endsWith("/search-etudiant")) {
            String nom = request.getParameter("nom");
            view = absenceAction.searchEtudiants(nom, model);
        }
        else if (uri.endsWith("/absences-mois")) {
            int mois = ORM.toInt(request.getParameter("mois"));
            view = absenceAction.absencesByMois(mois, model);
        }
        else if (uri.endsWith("/absences-etudiant")) {
            int id = ORM.toInt(request.getParameter("id"));
            view = absenceAction.absencesByEtudiant(id, model);
        }
        else {
            view = "error";
            model.add("message", "Ressource introuvable : " + uri);
        }

        List<String> names = model.getAllModelsNames();
        for (String name : names) request.setAttribute(name, model.get(name));
        request.getRequestDispatcher("/views/" + view + ".jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
