/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.List;
import tn.esprit.entities.Job;
import tn.esprit.entities.Rate;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Mehdi Sarray
 */
public interface IServiceRate extends IGenericService<Rate>{
    
      /**
     *
     * @param job
     * @return
     * @throws DataBaseException
     */
    List<Rate> findByJob(Job job) throws ObjectNotFoundException;

    /**
     *
     * @param candidate
     * @return
     * @throws DataBaseException
     */
    List<Rate> findByCandidate(User candidate) throws ObjectNotFoundException;
    
}
