package fr.damien.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.damien.dao.AgeDao;
import fr.damien.dao.MarqueDao;
import fr.damien.dao.ModeleDao;
import fr.damien.entities.Age;
import fr.damien.entities.Marque;

@WebServlet( urlPatterns = { "/devis" } )
public class Devis extends HttpServlet implements Serializable {

    /**
     * 
     */
    private static final long  serialVersionUID = -8770867765377969623L;

    @EJB
    private ModeleDao          modeleDao;

    @EJB
    private MarqueDao          marqueDao;

    @EJB
    private AgeDao             ageDao;

    public static final String VUE              = "/WEB-INF/devis.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        List<Marque> marques = marqueDao.listeMarques();

        List<Age> ages = ageDao.listeAge();

        request.setAttribute( "marques", marques );
        request.setAttribute( "ages", ages );

        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

}
