/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;

/**
 *
 * @author ali
 */
public interface IApplyDao extends IGenericDao<Apply> {

    List<Apply> findByjob(Job job) throws DataBaseException;
    List<Apply> findBycandidate(User candidate) throws DataBaseException;

}
