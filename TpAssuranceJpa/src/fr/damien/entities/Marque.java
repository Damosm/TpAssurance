package fr.damien.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Marque implements Serializable {

    /**
     * 
     */
    private static final long           serialVersionUID = 4871155874138806121L;

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

}
