/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.beans;

import ec.edu.espe.dao.BloqueoDAO;
import ec.edu.espe.dao.UsuarioDAO;
import ec.edu.espe.model.Bloqueo;
import ec.edu.espe.model.Usuario;
import ec.edu.espe.persistence.PersistenceManager;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.bson.types.ObjectId;

/**
 *
 * @author homer
 */
@Stateless
public class BloqueoBean {
    BloqueoDAO bloqueoDAO;

    Bloqueo bloqueo;
    List<Bloqueo> bloqueos;

    public BloqueoBean() {
        this.bloqueoDAO = new BloqueoDAO(Bloqueo.class, PersistenceManager.instance().datastore());
        this.bloqueo = bloqueo;
        
    }

    public BloqueoDAO getBloqueoDAO() {
        return bloqueoDAO;
    }

    public void setBloqueoDAO(BloqueoDAO bloqueoDAO) {
        this.bloqueoDAO = bloqueoDAO;
    }

    public Bloqueo getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(Bloqueo bloqueo) {
        this.bloqueo = bloqueo;
    }

    public List<Bloqueo> getBloqueos() {
        bloqueos=bloqueoDAO.find().asList();
        return bloqueos;
    }

    public void setBloqueos(List<Bloqueo> bloqueos) {
        this.bloqueos = bloqueos;
    }
    public void insertBloqueo()
    {
        
                this.bloqueoDAO.save(this.bloqueo);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.bloqueo = new Bloqueo();
                 System.out.println("Bloqueo Guardado");
           
    }
    public void updateBloqueo()
    {
        try {
            Bloqueo temp = this.bloqueoDAO.findOne("nickname", bloqueo.getId());
            System.out.println("Bloqueo a actualizar: "+bloqueo);
            if (temp != null) {
                 
                //this.bloqueoDAO.update(bloqueo);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.bloqueo = new Bloqueo();
                 System.out.println("Bloqueo Actualizado");
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.out.println("" + e);
        }
    }
    public List<Bloqueo> getUsuariosConBloqueo()
    {
        return bloqueoDAO.find().asList();
    }
    public void removeBloqueoByNickname(String id_usuario2)
    {
        Bloqueo temp= this.bloqueoDAO.findOne("id_usuario2",id_usuario2);
        bloqueoDAO.delete(temp);
    }
}
