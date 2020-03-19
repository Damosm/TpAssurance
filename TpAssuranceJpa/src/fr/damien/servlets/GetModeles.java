package fr.damien.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.damien.dao.ModeleDao;
import fr.damien.entities.Modele;

@WebServlet( urlPatterns = { "/getModeles" } )
public class GetModeles extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 8012731470908564200L;

    @EJB
    ModeleDao                 modeleDao;

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Integer marqueId = null;

        try {
            marqueId = Integer.parseInt( request.getParameter( "marque_id" ) );
        } catch ( NumberFormatException e ) {
            e.printStackTrace();
        }

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        List<Modele> modeles = modeleDao.listeModele( marqueId );

        try {
            PrintWriter out = response.getWriter();
            out.print( gson.toJson( modeles ) );
            out.flush();
        } catch ( IOException e ) {
            System.out.println( e );
        }
    }

}
