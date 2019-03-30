/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import tn.esprit.entities.Rate;
import tn.esprit.entities.User;

/**
 *
 * @author Mehdi Sarray
 */
public interface IRateDao extends IGenericDao<Rate> {

    /**
     *
     * @param job
     * @return
     * @throws DataBaseException
     */
    List<Rate> findByJob(Job job) throws DataBaseException;

    /**
     *
     * @param candidate
     * @return
     * @throws DataBaseException
     */
    List<Rate> findByCandidate(User candidate) throws DataBaseException;

}
