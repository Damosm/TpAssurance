/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.damien.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.damien.entities.Marque;

@Stateless
public class MarqueDao implements Serializable {

    /**
     * 
     */
    private static final long   serialVersionUID    = 1332917495600407618L;

    private static final String JPQL_SELECT_PAR_NOM = "SELECT u FROM Marque u WHERE u.nomMarque=:nom";
    private static final String JPQL_SELECT_MARQUE  = "SELECT m FROM Marque m ";
    private static final String PARAM_NOM           = "nom";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "tpassurance_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Marque marque ) throws DAOException {
        try {
            em.persist( marque );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Marque trouver( String nom ) throws DAOException {
        Marque marque = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
        requete.setParameter( PARAM_NOM, nom );
        try {
            marque = (Marque) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return marque;
    }

    // Liste de toutes les marques
    public List<Marque> listeMarques() {

        try {
            TypedQuery<Marque> query = em.createQuery( JPQL_SELECT_MARQUE, Marque.class );
            return query.getResultList();

        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
