/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CommentDaoImpl;
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.dao.implementation.ReclamationDaoImpl;
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;
import tn.esprit.entities.User;
import tn.esprit.entities.UserAccountStatus;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceComment;
import tn.esprit.services.interfaces.IServiceReclamation;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author mghozzi
 */
public class ServiceReclamationImpl implements IServiceReclamation {
    IUserDao userDao ;
    IReclamationDao reclamationDao;
    IJobDao jobDao ;
    ICommentDao commentDao ;
    IServiceUser userImpl ;
    IServiceComment commentImpl ;
    public ServiceReclamationImpl() {
        reclamationDao = new ReclamationDaoImpl();
        jobDao = new JobDaoImpl() ;
        commentDao = new CommentDaoImpl() ;
        userDao = new UserDaoImpl() ;
        
    }

    @Override
    public void claim(Reclamation reclamation, User loggedUser) throws ConstraintViolationException {
        if (reclamation.getType() == null) {
            throw new ConstraintViolationException("you must choose a type !");
        }
        reclamation.setStatus(ReclamationStatus.PENDING);
        reclamation.setClaimer(loggedUser);
        try {
         create(reclamation);
     /*    List<Job> listClaims = findAll()
                 .stream()
                 .filter(e-> e.getType().equals(reclamation.getType()))
                 .map(e -> e.getJob())
                 .filter(e-> e.getId().equals(reclamation.getJob().getId()))
                 .collect(Collectors.toList());
         
                 System.out.println(listClaims.size());
                 /*
        if( listClaims.size()>5 ){
            
            handleModerator(reclamation, HandleReclamationModerator.DISABLE_JOB);
        }
         */
         
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
               edit(reclamtion) ;
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
            reclamation.setStatus(ReclamationStatus.CLOSED);
           try {
             edit(reclamation) ;
           } catch (DataBaseException ex) {
             throw new ConstraintViolationException(ex.getMessage());
           }
           
           }
           case REMOVE_COMMENT : 
           {
              reclamation.setStatus(ReclamationStatus.OPEN) ;
           try {
           commentImpl.delete(reclamation.getComment());
           } catch (DataBaseException ex) {
              throw new ConstraintViolationException(ex.getMessage());
           }
                  
              }
           {
           
           }
           case REDIRECT : 
           {
                reclamation.setStatus(ReclamationStatus.REDIRECTED);
                
           try {
               edit(reclamation) ;
           } catch (DataBaseException ex) {
                throw new ConstraintViolationException(ex.getMessage());
           }           
           }
       }
    }

    @Override
    public void handleAdmin(Reclamation reclamation, HandleReclamationAdmin action) throws ConstraintViolationException {
         switch ( action ){
             case BAN : {
             reclamation.setStatus(ReclamationStatus.CLOSED);
             reclamation.getJob().setStatus(JobStatus.DISABLED);
            reclamation.getJob().getCompany().getRecruiter().setAccountStatus(UserAccountStatus.BANNED);
             }
         {
             try {
                 edit(reclamation) ;
                 userImpl.edit(reclamation.getJob().getCompany().getRecruiter());
             } catch (DataBaseException ex) {
           throw new ConstraintViolationException(ex.getMessage());
             }
             
         }
             case REJECT : {
              reclamation.setStatus(ReclamationStatus.CLOSED);
           try {
               edit(reclamation) ;
           } catch (DataBaseException ex) {
             throw new ConstraintViolationException(ex.getMessage());
           }
             
             }
         }
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
    public  List<Reclamation> findAll() throws DataBaseException {
    return reclamationDao.findAll() ;
    }

    @Override
    public Integer create(Reclamation entity) throws DataBaseException {
    return reclamationDao.create(entity);    }

    @Override
    public Integer edit(Reclamation entity) throws DataBaseException {
    return reclamationDao.edit(entity) ;
    }

    @Override
    public Integer delete(Reclamation entity) throws DataBaseException {
    return reclamationDao.delete(entity) ;
    }

}
