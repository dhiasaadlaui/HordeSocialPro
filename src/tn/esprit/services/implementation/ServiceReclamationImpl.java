/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.dao.implementation.ReclamationDaoImpl;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceReclamation;

/**
 *
 * @author mghozzi
 */
public class ServiceReclamationImpl implements IServiceReclamation {

    IReclamationDao reclamationDao;
    IJobDao jobDao ;
    public ServiceReclamationImpl() {
        reclamationDao = new ReclamationDaoImpl();
        jobDao = new JobDaoImpl() ;
    }

    @Override
    public void claim(Reclamation reclamation, User loggedUser) throws ConstraintViolationException {
        if (reclamation.getType() == null) {
            throw new ConstraintViolationException("you must choose a type !");
        }

        reclamation.setStatus(ReclamationStatus.PENDING);
        reclamation.setClaimer(loggedUser);
        try {
            reclamationDao.create(reclamation);
        } catch (DataBaseException ex) {
            throw new ConstraintViolationException(ex.getMessage());
        }
    }

    @Override
    public List<Reclamation> findByClaimer(User claimerUser) throws ObjectNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancel(Reclamation reclamtion) throws ConstraintViolationException {
     
        if ( reclamtion.getStatus().equals(ReclamationStatus.PENDING.name())  ){
            try {
                reclamtion.setStatus(ReclamationStatus.CANCELED);
                reclamationDao.edit(reclamtion) ;
            } catch (DataBaseException ex) {
               throw new ConstraintViolationException(ex.getMessage()) ;
            }
        }
        
        else {
            throw new ConstraintViolationException("impossible d'annuler une reclamation traité ou bien en cours de traitement") ;
        } 
        
        
    }

    @Override
    public void handleModerator(Reclamation reclamation, HandleReclamationModerator action) throws ConstraintViolationException {
       switch (action){
           case DISABLE_JOB:
           {
           reclamation.getJob().setStatus(JobStatus.DISABLED);
           try {
               jobDao.edit(reclamation.getJob());
           } catch (DataBaseException ex) {
             throw  new ConstraintViolationException(ex.getMessage()) ;
           }
           }
           case REJECT : 
           {
           
           }
           case REMOVE_COMMENT : 
           {
           
           }
           case REDIRECT : 
           {
           
           }
       }
    }

    @Override
    public void handleAdmin(Reclamation reclamation, HandleReclamationAdmin action) throws ConstraintViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reclamation> findByStatus(ReclamationStatus status) throws ObjectNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reclamation> findByType(ReclamationType type) throws ObjectNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void openReclamation(Reclamation reclamation) throws ObjectNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reclamation> findAll() throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer create(Reclamation entity) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer edit(Reclamation entity) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Reclamation entity) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
