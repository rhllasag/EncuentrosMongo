/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.model.CalificacionEncuentro;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author homer
 */
public class CalificacionEncuentroDAO extends BasicDAO<CalificacionEncuentro,ObjectId>{
    
    public CalificacionEncuentroDAO(Class<CalificacionEncuentro> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
    
}
