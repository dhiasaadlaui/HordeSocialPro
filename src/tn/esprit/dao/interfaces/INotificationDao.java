/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Notification;

/**
 *
 * @author Mehdi Sarray
 */
public interface INotificationDao extends IGenericDao<Notification> {
    
    /**
     *
     * @param entity
     * @param comEntity
     * @throws DataBaseException
     */
    public void craftNotification(Company entity,Comment comEntity) throws DataBaseException; 

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    public List<Notification> getNotificationByUser(Company entity) throws DataBaseException ; // for my thread
}
