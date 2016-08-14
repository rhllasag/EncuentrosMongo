/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.beans;

import ec.edu.espe.dao.ChatDAO;
import ec.edu.espe.dao.ChatDAO;
import ec.edu.espe.model.Chat;
import ec.edu.espe.model.Chat;
import ec.edu.espe.persistence.PersistenceManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class ChatBean {
    ChatDAO chatDAO;
    Chat chat;
    List<Chat> chats;

    public ChatBean() {
        this.chatDAO=new ChatDAO(Chat.class, PersistenceManager.instance().datastore());
        
    }

    public ChatDAO getChatDAO() {
        return chatDAO;
    }

    public void setChatDAO(ChatDAO chatoDAO) {
        this.chatDAO = chatoDAO;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public List<Chat> getChats() {
        chats=chatDAO.find().asList();
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
    public void insertChat()
    {
        try {
            Chat temp = this.chatDAO.findOne("_id", chat.getId());
            System.out.println("Chat seteado: "+chat);
            if (temp == null) {
                System.out.println("Temp =null");
                this.chatDAO.save(chat);
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El  nuevo cliente ha sido registrado"));
                this.chat = new Chat();
                 System.out.println("Chat Guardado");
            } else {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Un cliente ya ha sido registrado con esa identificacion"));

            }
        } catch (Exception e) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El  nuevo cliente no se pudo registrar"));
            System.err.println("" + e);
        }
    }

    
    public List<Chat> getMisChats(String id_usuario)
    {
        chats=chatDAO.find().asList();
        List<Chat> misChats= new ArrayList<>();
        for (Chat miChat : chats) {
            if (miChat.getId_usuario1().compareTo(id_usuario)==0||miChat.getId_usuario2().compareTo(id_usuario)==0) {
                misChats.add(miChat);
            }
            
        }
        return misChats;
    }
}
