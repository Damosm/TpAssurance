/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.damien.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author user
 */

@Entity
public class Marque implements Serializable {

    /**
     * 
     */
    private static final long           serialVersionUID = 2556299900751403474L;

    @Id
    @GeneratedValue
    @Column( name = "idMarque" )
    private int                         idMarque;

    @Column( name = "nomMarque" )
    private String                      nomMarque;

    @Column( name = "image" )
    private String                      image;

    @Transient
    public java.util.Collection<Modele> modele;

    ////////////////////////////////////////////////////////
    public Marque( String nomMarque ) {
        this.nomMarque = nomMarque;
    }

    public Marque() {
    }

    ////////////////////////////////////////////////////////
    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque( int idMarque ) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque( String nomMarque ) {
        this.nomMarque = nomMarque;
    }

    public String getImage() {
        return image;
    }

    public void setImage( String image ) {
        this.image = image;
    }

    public Collection<Modele> getModele() {

        if ( modele == null ) {
            modele = new java.util.HashSet<Modele>();
        }
        return modele;

    }

    public void setModele( Collection<Modele> newModele ) {
        removeAllModele();

        for ( java.util.Iterator iter = newModele.iterator(); iter.hasNext(); ) {
            addModele( (Modele) iter.next() );
        }

    }

    public java.util.Iterator getIteratorModele() {
        if ( modele == null ) {
            modele = new java.util.HashSet<Modele>();
        }
        return modele.iterator();
    }

    public void addModele( Modele newModele ) {
        if ( newModele == null ) {
            return;
        }
        if ( this.modele == null ) {
            this.modele = new java.util.HashSet<Modele>();
        }
        if ( !this.modele.contains( newModele ) ) {
            this.modele.add( newModele );
            newModele.setMarque( this );
        }
    }

    public void removeModele( Modele oldModele ) {
        if ( oldModele == null ) {
            return;
        }
        if ( this.modele != null ) {
            if ( this.modele.contains( oldModele ) ) {
                this.modele.remove( oldModele );
                oldModele.setMarque( (Marque) null );
            }
        }
    }

    public void removeAllModele() {
        if ( modele != null ) {
            Modele oldModele;
            for ( java.util.Iterator iter = getIteratorModele(); iter.hasNext(); ) {
                oldModele = (Modele) iter.next();
                iter.remove();
                oldModele.setMarque( (Marque) null );
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////

    /*
     * @Override public String toString() { return "Marque{" + "idMarque=" +
     * idMarque + ", nomMarque=" + nomMarque + ", modele=" + modele + '}'; }
     * 
     * @Override public int hashCode() { int hash = 3; hash = 13 * hash +
     * this.idMarque; hash = 13 * hash + Objects.hashCode(this.nomMarque); hash
     * = 13 * hash + Objects.hashCode(this.modele); return hash; }
     * 
     * @Override public boolean equals(Object obj) { if (this == obj) { return
     * true; } if (obj == null) { return false; } if (getClass() !=
     * obj.getClass()) { return false; } final Marque other = (Marque) obj; if
     * (this.idMarque != other.idMarque) { return false; } if
     * (!Objects.equals(this.nomMarque, other.nomMarque)) { return false; } if
     * (!Objects.equals(this.modele, other.modele)) { return false; } return
     * true; }
     */

}
