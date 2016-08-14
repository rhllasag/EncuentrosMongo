
import ec.edu.espe.beans.UsuarioBean;
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
    }
}
