package fr.damien.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import fr.damien.dao.MarqueDao;
import fr.damien.entities.Marque;

@ManagedBean
@ViewScoped
public class MarqueBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 676555671345564280L;

    private Marque            marque;
    private int               idMarque;
    private List<Marque>      listeMarques;

    public List<Marque> getListeMarques() {
        listeMarques = marqueDao.listeMarques();
        return listeMarques;
    }

    public MarqueBean() {

        marque = new Marque();
    }

    @EJB
    private MarqueDao marqueDao;

    public MarqueDao getMarqueDao() {
        return marqueDao;
    }

}
