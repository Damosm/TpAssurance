package fr.damien.beans;

import java.io.IOException;
import java.io.Serializable;

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
public class ConnexionBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2550403956572850735L;

    private Utilisateur       utilisateur;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UtilisateurDao    utilisateurDao;

    // Initialisation de l'entité utilisateur
    public ConnexionBean() {
        utilisateur = new Utilisateur();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // de connexion
    // public void connexion( Object value ) throws ValidatorException {
    public void connexion() throws IOException {

        if ( utilisateurDao.confirmerMotDePasse( utilisateur.getEmail(), utilisateur.getMotDePasse() ) != null ) {
            FacesMessage message = new FacesMessage( "Connecté !" );
            FacesContext.getCurrentInstance().addMessage( null, message );

            // ouverture de la page bienvenue
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect( externalContext
                    .getRequestContextPath() + "/bienvenue.xhtml" );

        } else {

            FacesMessage message = new FacesMessage( "Email ou mot de passe erroné !" );
            FacesContext.getCurrentInstance().addMessage( null, message );
        }

    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

}