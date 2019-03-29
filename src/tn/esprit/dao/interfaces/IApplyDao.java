/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Apply;

/**
 *
 * @author ali
 */
public interface IApplyDao extends IGenericDao<Apply> {
    Apply findByjob(Integer id)throws DataBaseException;
    Apply findBycandidate(Integer id)throws DataBaseException;
    
    
}
