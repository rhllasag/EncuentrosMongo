/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.beans;

import com.mongodb.BasicDBObject;
import ec.edu.espe.dao.UsuarioDAO;
import ec.edu.espe.model.Usuario;
import ec.edu.espe.persistence.PersistenceManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author homer
 */
@Stateless
public class UsuarioBean {
    
    UsuarioDAO usuarioDAO;
    Usuario usuario;
    List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        usuarios=usuarioDAO.find().asList();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioBean() {
        usuarioDAO = new UsuarioDAO(Usuario.class, PersistenceManager.instance().datastore());
        usuario = new Usuario();
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public void insertUsuario()
    {
        try {
            Usuario temp = this.usuarioDAO.findOne("nickname", usuario.getNickname());
            System.out.println("Usuario seteado: "+usuario);
            if (temp == null) {
                System.out.println("Temp =null");
                this.usuarioDAO.save(usuario);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.usuario = new Usuario();
                 System.out.println("Usuario Guardado");
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.out.println("" + e);
        }
    }
    public void updateUsuario()
    {
        try {
            Usuario temp = this.usuarioDAO.findOne("nickname", usuario.getNickname());
            System.out.println("Usuario a actualizar: "+usuario);
            if (temp != null) {
                 
                this.usuarioDAO.update(usuario);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.usuario = new Usuario();
                 System.out.println("Usuario Actualizado");
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.out.println("" + e);
        }
    }
}
