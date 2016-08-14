package ec.edu.espe.rest;

import ec.edu.espe.beans.BloqueoBean;
import ec.edu.espe.beans.CalificacionEncuentroBean;
import ec.edu.espe.beans.ChatBean;
import ec.edu.espe.beans.EncuentroBean;
import ec.edu.espe.beans.UsuarioBean;
import ec.edu.espe.model.Bloqueo;
import ec.edu.espe.model.CalificacionEncuentro;
import ec.edu.espe.model.Chat;
import ec.edu.espe.model.Encuentro;
import ec.edu.espe.model.Nickname;
import ec.edu.espe.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    @POST
    @Path("createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(Usuario usuario) {
        UsuarioBean bean=new UsuarioBean();
        bean.setUsuario(usuario);
        bean.insertUsuario();
    }
    @GET
    @Path("getUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsers() {
        UsuarioBean bean=new UsuarioBean();
        return bean.getUsuarios();
    }
    @GET
    @Path("getUserByNickname/{nickname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUserById(@PathParam("nickname")String nickname) {
        UsuarioBean bean=new UsuarioBean();
        return bean.getUsuarioByNickname(nickname);
    }
    @DELETE
    @Path("removeUser/{nickname}")
    public void remove(@PathParam("nickname") String nickname) {
        UsuarioBean bean=new UsuarioBean();
        bean.removeUsuarioByNickname(nickname);
    }

    


    
    
    @POST
    @Path("createBloqueo")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBloqueo(Bloqueo bloqueo) {
        BloqueoBean bean=new BloqueoBean();
        bean.setBloqueo(bloqueo);
        bean.insertBloqueo();
    }
    @GET
    @Path("getUsuarioConBloqueo/{id_usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Nickname> getUsuariosQueHeBloqueado(@PathParam("id_usuario")String usuario) {
        BloqueoBean bean=new BloqueoBean();
        List<Bloqueo> bloqueos=bean.getUsuariosConBloqueo();
        List<Nickname> usuariosConBloqueo=new ArrayList<>();
        for (Bloqueo bloqueo : bloqueos) {
            if(usuario.compareTo(bloqueo.getId_usuario1())==0){
            Nickname nik=new Nickname();
            nik.setNickname(bloqueo.getId_usuario2());
            usuariosConBloqueo.add(nik);
            }
            if(usuario.compareTo(bloqueo.getId_usuario2())==0){
            Nickname nik=new Nickname();
            nik.setNickname(bloqueo.getId_usuario1());
            usuariosConBloqueo.add(nik);
            }
        }
        return usuariosConBloqueo;
    }
    @GET
    @Path("getBloqueos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bloqueo> getUsuariosQueHeBloqueado() {
        BloqueoBean bean=new BloqueoBean();
        return bean.getBloqueos();
    }
    
    @DELETE
    @Path("removeBloqueo/{id_usuario2}")
    public void removeBloqueo(@PathParam("id_usuario2") String usuario2) {
        BloqueoBean bean=new BloqueoBean();
        bean.removeBloqueoByNickname(usuario2);
    }
    
    
    
    
    
    
    @POST
    @Path("createChat")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createChat(Chat chat) {
        ChatBean bean=new ChatBean();
        bean.setChat(chat);
        bean.insertChat();
    }
    @GET
    @Path("getChats/{id_usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chat> getChats(@PathParam("id_usuario") String usuario) {
         ChatBean bean=new ChatBean();
        return bean.getMisChats(usuario);
    }
    
    
    
    
    
    @POST
    @Path("createEnuentro")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createEncuentro(Encuentro encuentro) {
        EncuentroBean bean=new EncuentroBean();
        bean.setEncuentro(encuentro);
        bean.insertEncuentro();
    }
    @GET
    @Path("getEncuentros/{id_usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Encuentro> getEncuentros(@PathParam("id_usuario") String usuario) {
        EncuentroBean bean=new EncuentroBean();
        return bean.getMisEncuentros(usuario);
    }
    
    @POST
    @Path("createCalificacion")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCalificacionE(CalificacionEncuentro calificacionEncuentro) {
        CalificacionEncuentroBean bean=new CalificacionEncuentroBean();
        bean.setCalificacion(calificacionEncuentro);
        bean.insertCalificacionEncuentro();
        
    }
}
