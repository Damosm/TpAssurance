package fr.damien.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.damien.entities.Age;

@Stateless
public class AgeDao implements Serializable {

    /**
     * 
     */
    private static final long   serialVersionUID = -7113022880380508430L;

    private static final String JPQL_AGE         = "select a FROM Age a";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "tpassurance_PU" )
    private EntityManager       em;

    // Liste age en fonction de l'idAge
    public List<Age> listeAge() {

        try {
            TypedQuery<Age> query = em.createQuery( JPQL_AGE, Age.class );
            return query.getResultList();

        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

}
