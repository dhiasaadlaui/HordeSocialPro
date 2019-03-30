/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.User;

/**
 *
 * @author Dhia
 */
public interface IUserDao extends IGenericDao<User> {

    /**
     *
     * @param id
     * @return
     * @throws DataBaseException
     */
    User findByID(Integer id) throws DataBaseException;

}
