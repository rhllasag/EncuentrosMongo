
import ec.edu.espe.beans.BloqueoBean;
import ec.edu.espe.beans.ChatBean;
import ec.edu.espe.beans.UsuarioBean;
import ec.edu.espe.dao.ChatDAO;
import ec.edu.espe.model.Bloqueo;
import ec.edu.espe.model.Chat;
import ec.edu.espe.model.EstadisticaUsuario;
import ec.edu.espe.model.Usuario;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.bson.types.ObjectId;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author homer
 */
public class Main {
    public static void main(String[] args) {
        UsuarioBean bean = new UsuarioBean();
//        Usuario usuario = new Usuario();
//        usuario.setId(new ObjectId());
//        usuario.setNickname("camilaX");
//        EstadisticaUsuario estadistica= new EstadisticaUsuario();
//        estadistica.setEcuentros(0);
//        usuario.setEstadistica_usuario(estadistica);
//        bean.setUsuario(usuario);
//        bean.insertUsuario();
        ArrayList<Usuario> usuarios=new ArrayList<>();
        usuarios=(ArrayList<Usuario>) bean.getUsuarios();
        for (Usuario usuario1 : usuarios) {
            System.out.println(usuarios.toString());
        }
        BloqueoBean bloque=new BloqueoBean();
        Bloqueo bloq=new Bloqueo();
        bloq.setId(new ObjectId());
        bloq.setId_usuario1("@s");
        bloq.setId_usuario2("s@");
        System.out.println(bloq.toString());
        bloque.setBloqueo(bloq);
        bloque.insertBloqueo();
//        ArrayList<Bloqueo> bloqueos=new ArrayList<>();
//        bloqueos=(ArrayList<Bloqueo>) bloque.getBloqueos();
//        for (Bloqueo bloqueo : bloqueos) {
//            System.out.println(bloqueo.getId_usuario1());
//        }
        ChatBean beanC=new ChatBean();
        for (Chat cah : beanC.getMisChats("@1")) {
            System.out.println("Cht: "+cah.getMensaje());
        }
    }
}
