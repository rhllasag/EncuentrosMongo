/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.beans;

import ec.edu.espe.dao.EncuentroDAO;
import ec.edu.espe.dao.EncuentroDAO;
import ec.edu.espe.model.Encuentro;
import ec.edu.espe.model.Encuentro;
import ec.edu.espe.persistence.PersistenceManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class EncuentroBean {
    EncuentroDAO encuentroDAO;
    Encuentro encuentro;
    List<Encuentro> encuentros;

    public EncuentroBean() {
        encuentroDAO = new EncuentroDAO(Encuentro.class, PersistenceManager.instance().datastore());
        encuentro = new Encuentro();
    }

    public EncuentroDAO getEncuentroDAO() {
        return encuentroDAO;
    }

    public void setEncuentroDAO(EncuentroDAO encuentroDAO) {
        this.encuentroDAO = encuentroDAO;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public List<Encuentro> getEncuentros() {
        encuentros=encuentroDAO.find().asList();
        return encuentros;
    }

    public void setEncuentros(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }
    public void insertEncuentro()
    {
        try {
            Encuentro temp = this.encuentroDAO.findOne("_id", encuentro.getId());
            System.out.println("Encuentro seteado: "+encuentro);
            if (temp == null) {
                System.out.println("Temp =null");
                this.encuentroDAO.save(encuentro);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.encuentro = new Encuentro();
                 System.out.println("Encuentro Guardado");
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.err.println("" + e);
        }
    }

    
    public List<Encuentro> getMisEncuentros(String id_usuario)
    {
        List<Encuentro> encuentros=encuentroDAO.find().asList();
        List<Encuentro> misEncuentros= new ArrayList<>();
        for (Encuentro miEncuentro : encuentros) {
            if (miEncuentro.getId_usuario1().compareTo(id_usuario)==0||miEncuentro.getId_usuario2().compareTo(id_usuario)==0) {
                misEncuentros.add(miEncuentro);
            }
            
        }
        return misEncuentros;
    }
}
