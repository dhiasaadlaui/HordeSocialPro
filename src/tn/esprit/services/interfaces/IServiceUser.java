/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Dhia
 */
public interface IServiceUser extends IGenericService<User>{
    
    /**
     *
     * @param identifier username or password
     * @param password
     * @return
     * @throws ObjectNotFoundException
     */
    User authentication(String identifier,String password)throws ObjectNotFoundException;

    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    User findByID(Integer id) throws ObjectNotFoundException;

}
