package fr.damien.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.damien.dao.DAOException;
import fr.damien.entities.Utilisateur;

@Stateless
public class UtilisateurDao implements Serializable {

    /**
     * 
     */
    private static final long   serialVersionUID      = 8748293236218203899L;

    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
    private static final String PARAM_EMAIL           = "email";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "tpassurance_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Utilisateur utilisateur ) throws DAOException {
        try {
            em.persist( utilisateur );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Utilisateur trouver( String email ) throws DAOException {
        Utilisateur utilisateur = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        try {
            utilisateur = (Utilisateur) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return utilisateur;
    }

    // Confirmation du mot de passe
    public Utilisateur confirmerMotDePasse( String email, String motDePasse ) throws DAOException {
        Utilisateur utilisateur = null;

        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );

        try {
            utilisateur = (Utilisateur) requete.getSingleResult();

            if ( utilisateur.getEmail().equals( email ) && utilisateur.getMotDePasse().equals( motDePasse ) ) {

                return utilisateur;

            } else {

                return null;
            }

        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }

    }

}
