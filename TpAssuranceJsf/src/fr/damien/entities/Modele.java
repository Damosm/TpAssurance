/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.damien.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class Modele implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3206313153718360168L;

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

    ////////////////////////////////////////////////////////////////////////
    /*
     * @Override public String toString() { return "Modele{" + "idModele=" +
     * idModele + ", nomModele=" + nomModele + ", idMarque=" + idMarque +
     * ", marque=" + marque + '}'; }
     * 
     * @Override public int hashCode() { int hash = 7; hash = 97 * hash +
     * this.idModele; hash = 97 * hash + Objects.hashCode(this.nomModele); hash
     * = 97 * hash + this.idMarque; hash = 97 * hash +
     * Objects.hashCode(this.marque); return hash; }
     * 
     * @Override public boolean equals(Object obj) { if (this == obj) { return
     * true; } if (obj == null) { return false; } if (getClass() !=
     * obj.getClass()) { return false; } final Modele other = (Modele) obj; if
     * (this.idModele != other.idModele) { return false; } if (this.idMarque !=
     * other.idMarque) { return false; } if (!Objects.equals(this.nomModele,
     * other.nomModele)) { return false; } if (!Objects.equals(this.marque,
     * other.marque)) { return false; } return true; }
     */

}
