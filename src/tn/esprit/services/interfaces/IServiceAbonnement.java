/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.List;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Company;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Dhia
 */
public interface IServiceAbonnement extends IGenericService<Abonnement>{
    
   
    /**
     *
     * @param candidate
     * @return
     * @throws tn.esprit.services.exceptions.ObjectNotFoundException
     */
    List<Abonnement> findByCandidate(User candidate) throws ObjectNotFoundException;

    /**
     *
     * @param company
     * @return
     * @throws tn.esprit.services.exceptions.ObjectNotFoundException
     */
    List<Abonnement> findByCompany(Company company) throws ObjectNotFoundException;
    
}
