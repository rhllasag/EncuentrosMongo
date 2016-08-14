/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

import ec.edu.espe.persistence.BaseEntity;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author homer
 */
@Entity(noClassnameStored = true)
public class Bloqueo extends BaseEntity{
    Object id_usuario1;
    Object id_usuario2;
    Date date;

    public Object getId_usuario1() {
        return id_usuario1;
    }

    public void setId_usuario1(Object id_usuario1) {
        this.id_usuario1 = id_usuario1;
    }

    public Object getId_usuario2() {
        return id_usuario2;
    }

    public void setId_usuario2(Object id_usuario2) {
        this.id_usuario2 = id_usuario2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
