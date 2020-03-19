package fr.damien.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import fr.damien.dao.ModeleDao;
import fr.damien.entities.Modele;

@ManagedBean
@ViewScoped
public class ModeleBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1247265830430551890L;

    private Modele            modele;
    private int               idMarque;
    private int               idModele;
    private int               idAge;

    private int               prixMarque       = 0;
    private int               prixModele       = 0;
    private Double            prixAge          = 0.0;
    private Double            prixTotal        = 0.0;

    private List<Modele>      listeModele;

    public ModeleBean() {

        modele = new Modele();
    }

    @EJB
    private ModeleDao modeleDao;

    public ModeleDao getModeleDao() {
        return modeleDao;
    }

    public List<Modele> getListeModele() {

        listeModele = modeleDao.listeModele( this.getIdMarque() );
        return listeModele;
    }

    public Double selectionChanged( final AjaxBehaviorEvent event ) {

        switch ( this.idMarque ) {

        case 1:
            prixMarque = 200;

            break;

        case 2:
            prixMarque = 150;

            break;

        case 3:
            prixMarque = 100;

            break;

        }

        /////////////////////////////////////////////////////////////////////////////

        switch ( this.idModele ) {

        case 1:
            prixModele = 50;

            break;

        case 2:
            prixModele = 100;

            break;

        case 3:
            prixModele = 150;

            break;

        case 4:
            prixModele = 50;

            break;

        case 5:
            prixModele = 100;

            break;

        case 6:
            prixModele = 150;

            break;

        case 7:
            prixModele = 50;

            break;

        case 8:
            prixModele = 100;

            break;

        case 9:
            prixModele = 150;

            break;

        }

        ////////////////////////////////////////////////////////////////////////

        switch ( this.idAge ) {

        case 1:
            prixAge = 2.0;

            break;
        case 2:
            prixAge = 1.9;

            break;
        case 3:
            prixAge = 1.8;

            break;
        case 4:
            prixAge = 1.7;

            break;
        case 5:
            prixAge = 1.6;

            break;
        case 6:
            prixAge = 1.5;

            break;
        case 7:
            prixAge = 1.4;

            break;
        case 8:
            prixAge = 1.3;

            break;
        case 9:
            prixAge = 1.2;

            break;
        case 10:
            prixAge = 1.1;

            break;
        case 11:
            prixAge = 1.0;

            break;
        case 12:
            prixAge = 1.2;

            break;
        case 13:
            prixAge = 1.5;

            break;
        case 14:
            prixAge = 10.0;

            break;

        }

        prixTotal = ( prixMarque + prixModele ) * prixAge;

        return prixTotal;
    }

    private Double output;

    public void submit() {
        // handle form submission
        output = 12.02;
    }

    public Double getOutput() {
        return output;
    }

    public void setOutput( Double output ) {
        this.output = output;
    }

    public void setIdMarque( int pIdMarque ) {
        this.idMarque = pIdMarque;
    }

    public int getIdMarque() {
        return this.idMarque;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele( int idModele ) {
        this.idModele = idModele;
    }

    public int getIdAge() {
        return idAge;
    }

    public void setIdAge( int idAge ) {
        this.idAge = idAge;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

}
