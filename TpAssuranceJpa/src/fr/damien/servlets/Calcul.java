package fr.damien.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet( "/calcul" )
public class Calcul extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -1833344783238033866L;

    private int               prixMarque       = 0;
    private int               prixModele       = 0;
    private Double            prixAge          = 0.0;
    private Double            prixTotal        = 0.0;

    public Calcul() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        response.getWriter().append( "Served at: " ).append( request.getContextPath() );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Integer idMarque = null;
        Integer idModele = null;
        Integer idAge = null;

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        try {
            idMarque = Integer.parseInt( request.getParameter( "idMarque" ) );
        } catch ( NumberFormatException e ) {
            e.printStackTrace();
        }

        try {
            idModele = Integer.parseInt( request.getParameter( "idModele" ) );
        } catch ( NumberFormatException e ) {
            e.printStackTrace();
        }

        try {
            idAge = Integer.parseInt( request.getParameter( "idAge" ) );
        } catch ( NumberFormatException e ) {
            e.printStackTrace();
        }

        switch ( idMarque ) {

        case 1:
            prixMarque = 200;

            break;

        case 2:
            prixMarque = 150;

            break;

        case 3:
            prixMarque = 100;

            break;

        }

        /////////////////////////////////////////////////////////////////////////////

        switch ( idModele ) {

        case 1:
            prixModele = 50;

            break;

        case 2:
            prixModele = 100;

            break;

        case 3:
            prixModele = 150;

            break;

        case 4:
            prixModele = 50;

            break;

        case 5:
            prixModele = 100;

            break;

        case 6:
            prixModele = 150;

            break;

        case 7:
            prixModele = 50;

            break;

        case 8:
            prixModele = 100;

            break;

        case 9:
            prixModele = 150;

            break;

        }

        ////////////////////////////////////////////////////////////////////////

        switch ( idAge ) {

        case 1:
            prixAge = 2.0;

            break;
        case 2:
            prixAge = 1.9;

            break;
        case 3:
            prixAge = 1.8;

            break;
        case 4:
            prixAge = 1.7;

            break;
        case 5:
            prixAge = 1.6;

            break;
        case 6:
            prixAge = 1.5;

            break;
        case 7:
            prixAge = 1.4;

            break;
        case 8:
            prixAge = 1.3;

            break;
        case 9:
            prixAge = 1.2;

            break;
        case 10:
            prixAge = 1.1;

            break;
        case 11:
            prixAge = 1.0;

            break;
        case 12:
            prixAge = 1.2;

            break;
        case 13:
            prixAge = 1.5;

            break;
        case 14:
            prixAge = 10.0;

            break;

        }

        prixTotal = ( prixMarque + prixModele ) * prixAge;

        System.out.println( idMarque );
        System.out.println( idModele );
        System.out.println( idAge );
        System.out.println( prixTotal );

        try {
            PrintWriter out = response.getWriter();
            out.print( gson.toJson( prixTotal ) );
            out.flush();
        } catch ( IOException e ) {
            System.out.println( e );
        }

    }

    public Double getPrixTotal() {
        return prixTotal;
    }

}
