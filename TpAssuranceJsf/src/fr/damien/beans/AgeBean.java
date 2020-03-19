package fr.damien.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.damien.dao.AgeDao;
import fr.damien.entities.Age;

@ManagedBean
@ViewScoped
public class AgeBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3655024997470293321L;

    private Age               age;
    private int               idAge;
    private String            valeurAge;
    private Double            coefAge;
    private List<Age>         listeAge;

    public AgeBean() {

        age = new Age();
    }

    @EJB
    private AgeDao ageDao;

    public AgeDao getAgeDao() {

        return ageDao;
    }

    public List<Age> getListeAge() {

        listeAge = ageDao.listeAge();
        return listeAge;
    }

    public Age getAge() {
        return age;
    }

    public void setAge( Age age ) {
        this.age = age;
    }

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

    public Double getCoefAge() {
        return coefAge;
    }

    public void setCoefAge( Double coefAge ) {
        this.coefAge = coefAge;
    }

    public void setListeAge( List<Age> listeAge ) {
        this.listeAge = listeAge;
    }

    public void setAgeDao( AgeDao ageDao ) {
        this.ageDao = ageDao;
    }

}
