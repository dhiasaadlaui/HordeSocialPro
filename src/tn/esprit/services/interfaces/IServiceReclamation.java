/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.List;
import tn.esprit.entities.Job;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.HandleReclamationAdmin;
import tn.esprit.services.implementation.HandleReclamationModerator;

/**
 *
 * @author mghozzi
 */
public interface IServiceReclamation extends IGenericService<Reclamation>{

    /**
     *
     * @param reclamation
     * @param loggedUser
     * @throws ConstraintViolationException
     */
    void claim ( Reclamation reclamation , User loggedUser) throws ConstraintViolationException ;
    
    /**
     *
     * @param claimerUser
     * @return
     * @throws ObjectNotFoundException
     */
    List <Reclamation> findByClaimer (User claimerUser) throws ObjectNotFoundException; 
    
    /**
     *
     * @param reclamtion
     * @throws ConstraintViolationException
     */
    void cancel ( Reclamation reclamtion) throws ConstraintViolationException ;
    
    /**
     *
     * @param reclamation
     * @param action
     * @throws ConstraintViolationException
     */
    void handleModerator ( Reclamation reclamation , HandleReclamationModerator action ) throws ConstraintViolationException  ;
     
    /**
     *
     * @param reclamation
     * @param action
     * @throws ConstraintViolationException
     */
    void handleAdmin ( Reclamation reclamation , HandleReclamationAdmin action) throws ConstraintViolationException;
     
    /**
     *
     * @param status
     * @return
     * @throws ObjectNotFoundException
     */
    List <Reclamation> findByStatus (ReclamationStatus status) throws ObjectNotFoundException;
     
    /**
     *
     * @param type
     * @return
     * @throws ObjectNotFoundException
     */
    List<Reclamation> findByType ( ReclamationType type) throws ObjectNotFoundException ;
     
    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    Reclamation findById ( int id ) throws ObjectNotFoundException ;
 
    /**
     *
     * @param reclamation
     * @throws ObjectNotFoundException
     */
    void openReclamation ( Reclamation reclamation) throws ObjectNotFoundException ;
     
     // ca manque le service d'envoi de mail en cas d'une desactivation de statut ou bien de ban d'un compte .
     
}
