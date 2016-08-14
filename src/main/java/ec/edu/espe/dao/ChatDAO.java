/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.model.Bloqueo;
import ec.edu.espe.model.Chat;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author homer
 */
public class ChatDAO extends BasicDAO<Chat,ObjectId>{
    
    public ChatDAO(Class<Chat> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
    
}
