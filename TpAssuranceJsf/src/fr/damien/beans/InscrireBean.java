package fr.damien.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.damien.dao.UtilisateurDao;
import fr.damien.entities.Utilisateur;

@ManagedBean
@ViewScoped
public class InscrireBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2036225906725555153L;

    private Utilisateur       utilisateur;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UtilisateurDao    utilisateurDao;

    // Initialisation de l'entité utilisateur
    public InscrireBean() {
        utilisateur = new Utilisateur();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void inscrire() throws IOException {

        initialiserDateInscription();
        utilisateurDao.creer( utilisateur );
        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );

        // ouverture de la page connexion
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect( externalContext
                .getRequestContextPath() + "/connexion.xhtml" );

    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        utilisateur.setDateInscription( date );
    }
}