/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.ArrayList;
import java.util.List;
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

    IUserDao userDao;
    IReclamationDao reclamationDao;
    IJobDao jobDao;
    ICommentDao commentDao;
    IServiceUser userImpl;
    IServiceComment commentImpl;

    /**
     *
     */
    public ServiceReclamationImpl() {
        reclamationDao = new ReclamationDaoImpl();
        jobDao = new JobDaoImpl();
        commentDao = new CommentDaoImpl();
        userDao = new UserDaoImpl();
        commentDao = new CommentDaoImpl();
    }

    /**
     *
     * @param reclamation
     * @param loggedUser
     * @throws ConstraintViolationException
     */
    @Override
    public void claim(Reclamation reclamation, User loggedUser) throws ConstraintViolationException {
        if (reclamation.getType() == null) {
            throw new ConstraintViolationException("you must choose a type !");
        }
        reclamation.setStatus(ReclamationStatus.PENDING);
        reclamation.setClaimer(loggedUser);
        try {
            create(reclamation);
            List<Job> listClaims = findAll()
                    .stream()
                    .filter(e -> e.getType().equals(reclamation.getType()))
                    .map(e -> e.getJob())
                    .filter(e -> e.getId().equals(reclamation.getJob().getId()))
                    .collect(Collectors.toList());

            if (listClaims.size() > 5) {

                handleModerator(reclamation, HandleReclamationModerator.DISABLE_JOB);
              for(Reclamation rec: findAll()){
                  if (rec.getJob().equals(reclamation.getJob())){
                     handleModerator(rec, HandleReclamationModerator.REJECT);
                  }
              }
            }

        } catch (DataBaseException ex) {
            throw new ConstraintViolationException(ex.getMessage());
        }

    }

    /**
     *
     * @param claimerUser
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public List<Reclamation> findByClaimer(User claimerUser) throws ObjectNotFoundException {
       
         try {
            return findAll().stream().filter(e -> e.getClaimer().equals(claimerUser)).collect(Collectors.toList());
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    /**
     *
     * @param reclamtion
     * @throws ConstraintViolationException
     */
    @Override
    public void cancel(Reclamation reclamtion) throws ConstraintViolationException {

        if (reclamtion.getStatus().equals(ReclamationStatus.PENDING.name())) {
            try {
                reclamtion.setStatus(ReclamationStatus.CANCELED);
                edit(reclamtion);
            } catch (DataBaseException ex) {
                throw new ConstraintViolationException(ex.getMessage());
            }
        } else {
            throw new ConstraintViolationException("impossible d'annuler une reclamation traité ou bien en cours de traitement");
        }

    }

    /**
     *
     * @param reclamation
     * @param action
     * @throws ConstraintViolationException
     */
    @Override
    public void handleModerator(Reclamation reclamation, HandleReclamationModerator action) throws ConstraintViolationException {
        
             if (action.name().equals("DISABLE_JOB")) {
                reclamation.getJob().setStatus(JobStatus.DISABLED); // en attente hbib
                reclamation.setStatus(ReclamationStatus.CLOSED);
                try {

                    jobDao.edit(reclamation.getJob());
                    reclamationDao.edit(reclamation);
                } catch (DataBaseException ex) {
                    throw new ConstraintViolationException(ex.getMessage());
                }
            }
             
            if (action.name().equals("REJECT")){
                reclamation.setStatus(ReclamationStatus.CLOSED);
                try {
                    reclamationDao.edit(reclamation);
                } catch (DataBaseException ex) {
                    throw new ConstraintViolationException(ex.getMessage());
                }

            }
           
             if (action.name().equals("REMOVE_COMMENT")) {
                reclamation.setStatus(ReclamationStatus.OPEN);
                try {
                    if (reclamation.getComment() != null) {

                        commentDao.delete(reclamation.getComment());
                    }
                } catch (DataBaseException ex) {
                    throw new ConstraintViolationException(ex.getMessage());
                }

            }

            if (action.name().equals("REDIRECT")){
                reclamation.setStatus(ReclamationStatus.REDIRECTED);

                try {
                    edit(reclamation);
                } catch (DataBaseException ex) {
                    throw new ConstraintViolationException(ex.getMessage());
                }
            
        }
    }

    /**
     *
     * @param reclamation
     * @param action
     * @throws ConstraintViolationException
     */
    @Override
    public void handleAdmin(Reclamation reclamation, HandleReclamationAdmin action) throws ConstraintViolationException {
        switch (action) {
            case BAN: {
                reclamation.setStatus(ReclamationStatus.CLOSED);
                reclamation.getJob().setStatus(JobStatus.DISABLED);
                reclamation.getJob().getCompany().getRecruiter().setAccountStatus(UserAccountStatus.BANNED);
            }
             {
                try {
                    edit(reclamation);
                    userImpl.edit(reclamation.getJob().getCompany().getRecruiter());
                } catch (DataBaseException ex) {
                    throw new ConstraintViolationException(ex.getMessage());
                }

            }
            case REJECT: {
                reclamation.setStatus(ReclamationStatus.CLOSED);
                try {
                    edit(reclamation);
                } catch (DataBaseException ex) {
                    throw new ConstraintViolationException(ex.getMessage());
                }

            }
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public Reclamation findById(int id) throws ObjectNotFoundException {
        try {
            return reclamationDao.findById(id);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    /**
     *
     * @param status
     * @return
     * @throws ObjectNotFoundException
     */
    @Override

    public List<Reclamation> findByStatus(ReclamationStatus status) throws ObjectNotFoundException {
        try {

            return (ArrayList<Reclamation>) findAll()
                    .stream()
                    .filter(t -> t.getJob().getStatus().equals(status.toString())
                    ).collect(Collectors.toList());

        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    /**
     *
     * @param type
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public List<Reclamation> findByType(ReclamationType type) throws ObjectNotFoundException {
        try {
            return findAll().stream().filter(e -> e.getType().equals(type.toString())).collect(Collectors.toList());
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    /**
     *
     * @param reclamation
     * @throws ObjectNotFoundException
     */
    @Override
    public void openReclamation(Reclamation reclamation) throws ObjectNotFoundException {

        reclamation.setStatus(ReclamationStatus.OPEN);
        try {
            reclamationDao.edit(reclamation);
        } catch (DataBaseException e) {
             throw new ObjectNotFoundException(e.getMessage());
        }

    }

    @Override
    public List<Reclamation> findAll() throws DataBaseException {
        return reclamationDao.findAll();
    }

    @Override
    public Integer create(Reclamation entity) throws DataBaseException {

        return reclamationDao.create(entity);
    }

    @Override
    public Integer edit(Reclamation entity) throws DataBaseException {
        return reclamationDao.edit(entity);
    }

    @Override
    public Integer delete(Reclamation entity) throws DataBaseException {
        return reclamationDao.delete(entity);
    }

}
