package fr.damien.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Age implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7509638734117211054L;

    @Id
    @GeneratedValue
    @Column( name = "idAge" )
    private int               idAge;

    @Column( name = "valeurAge" )
    private String            valeurAge;

    @Column( name = "coefAge" )
    private int               coefAge;

    public int getIdAge() {
        return idAge;
    }

    public void setIdAge( int idAge ) {
        this.idAge = idAge;
    }

    public String getValeurAge() {
        return valeurAge;
    }

    public void setValeurAge( String valeurAge ) {
        this.valeurAge = valeurAge;
    }

    public int getCoefAge() {
        return coefAge;
    }

    public void setCoefAge( int coefAge ) {
        this.coefAge = coefAge;
    }

}
