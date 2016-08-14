/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.beans;

import ec.edu.espe.dao.CalificacionEncuentroDAO;
import ec.edu.espe.dao.UsuarioDAO;
import ec.edu.espe.model.CalificacionEncuentro;
import ec.edu.espe.model.EstadisticaUsuario;
import ec.edu.espe.model.Usuario;
import ec.edu.espe.persistence.PersistenceManager;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class CalificacionEncuentroBean  {
    CalificacionEncuentroDAO calificacionEncuentroDAO;
    CalificacionEncuentro calificacionEncuentro;
    List<CalificacionEncuentro> calificacionEncuentros;
    UsuarioDAO usuarioDAO;
    Usuario usuario;
    public CalificacionEncuentroDAO getUsuarioDAO() {
        return calificacionEncuentroDAO;
    }

    public void setUsuarioDAO(CalificacionEncuentroDAO calificacionEncuentroDAO) {
        this.calificacionEncuentroDAO = calificacionEncuentroDAO;
    }

    public CalificacionEncuentro getCalificacion() {
        return calificacionEncuentro;
    }

    public void setCalificacion(CalificacionEncuentro calificacionEncuentro) {
        this.calificacionEncuentro = calificacionEncuentro;
    }

    public List<CalificacionEncuentro> getUsuarios() {
        return calificacionEncuentroDAO.find().asList();
    }

    public void setUsuarios(List<CalificacionEncuentro> calificacionEncuentros) {
        this.calificacionEncuentros = calificacionEncuentros;
    }

    public CalificacionEncuentroBean() {
        this.calificacionEncuentroDAO=new CalificacionEncuentroDAO(CalificacionEncuentro.class, PersistenceManager.instance().datastore());;
        usuario=new Usuario();
        
    }
    
    public void insertCalificacionEncuentro()
    {
        try {
            CalificacionEncuentro temp = this.calificacionEncuentroDAO.findOne("_id", calificacionEncuentro.getId());
            System.out.println("Calificacion Encuentro seteado: "+calificacionEncuentro);
            if (temp == null) {
                System.out.println("Temp =null");
                this.calificacionEncuentroDAO.save(calificacionEncuentro);
                //modificarCalificacion(usuarioDAO.findOne("id_usuario", calificacionEncuentro.getId_usuario()));
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.calificacionEncuentro = new CalificacionEncuentro();
                 System.out.println("Caliificacion Encuentro Guardado");
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.err.println("" + e);
        }
    }   
}
