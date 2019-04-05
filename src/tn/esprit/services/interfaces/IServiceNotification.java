/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Notification;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Mehdi Sarray
 */
public interface IServiceNotification extends IGenericService<Notification>{
   
    public void craftNotification(Company entity,Comment comEntity) throws ConstraintViolationException; 
    public List<Notification> getNotificationByUser(Company entity) throws ObjectNotFoundException ; // for my thread
}
