package fr.damien.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.damien.entities.Modele;

@Stateless
public class ModeleDao implements Serializable {

    /**
     * 
     */
    private static final long   serialVersionUID    = 509266385395190599L;

    private static final String JPQL_SELECT_PAR_NOM = "SELECT u FROM Modele u WHERE u.nomModele=:nom";
    private static final String PARAM_NOM           = "nom";
    private static final String PARAM_MARQUE        = "idMarque";
    private static final String JPQL_MODELE         = "select m FROM Modele m WHERE m.marque.idMarque=:idMarque";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "tpassurance_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Modele modele ) throws DAOException {
        try {
            em.persist( modele );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un modele à partir de son nom
    public Modele trouver( String nom ) throws DAOException {
        Modele modele = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
        requete.setParameter( PARAM_NOM, nom );
        try {
            modele = (Modele) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return modele;
    }

    // Liste modele en fonction de l'idMarque
    public List<Modele> listeModele( int idMarque ) {

        try {
            TypedQuery<Modele> query = em.createQuery( JPQL_MODELE, Modele.class );
            query.setParameter( PARAM_MARQUE, idMarque );
            return query.getResultList();

        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

}
