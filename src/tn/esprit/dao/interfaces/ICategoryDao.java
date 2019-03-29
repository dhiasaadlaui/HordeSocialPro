/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import tn.esprit.entities.Category;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Alai Zid
 */
public interface ICategoryDao extends IGenericDao<Category> {
    
    Category findByID(Integer id) throws ObjectNotFoundException;
    
}
