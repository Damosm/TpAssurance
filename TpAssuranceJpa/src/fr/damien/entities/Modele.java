package fr.damien.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Modele implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2502373135024935972L;

    @Id
    @GeneratedValue
    @Column( name = "idModele" )
    private int               idModele;

    @Column( name = "nomModele" )
    private String            nomModele;

    @ManyToOne
    @JoinColumn( name = "idMarque" )
    Marque                    marque;

    ///////////////////////////////////////////////////////
    public Modele( String nomModele, Marque marque ) {

        this.nomModele = nomModele;
        this.marque = marque;
        marque.addModele( this );

    }

    public Modele() {
    }

    ////////////////////////////////////////////////////////////////////////////
    public int getIdModele() {
        return idModele;
    }

    public void setIdModele( int idModele ) {
        this.idModele = idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele( String nomModele ) {
        this.nomModele = nomModele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque( Marque marque ) {
        this.marque = marque;
    }

}
