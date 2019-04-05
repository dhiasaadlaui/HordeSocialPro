/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;


import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.RateDaoImpl;
import tn.esprit.dao.interfaces.IRateDao;
import tn.esprit.entities.Job;
import tn.esprit.entities.Rate;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceRate;

/**
 *
 * @author Mehdi Sarray
 */
public class ServiceRateImpl implements IServiceRate{

    IRateDao iservicerate ;

    public ServiceRateImpl() {
        iservicerate = new RateDaoImpl() ;
    }
    
    
    
    
    @Override
    public List<Rate> findAll() throws DataBaseException {
        return iservicerate.findAll() ;
    }

    @Override
    public Integer create(Rate entity) throws DataBaseException {
       return iservicerate.create(entity) ;
    }

    @Override
    public Integer edit(Rate entity) throws DataBaseException {
       return iservicerate.edit(entity) ;
    }

    @Override
    public Integer delete(Rate entity) throws DataBaseException {
       return iservicerate.delete(entity);
    }

    @Override
    public List<Rate> findByJob(Job job) throws ObjectNotFoundException {
         try {
             
            return iservicerate.findByJob(job);
            
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Rate> findByCandidate(User candidate) throws ObjectNotFoundException {
          try {
              
          return iservicerate.findByCandidate(candidate);
          
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }
    
    
}
