/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Job;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author habib
 */
public interface IServiceJob extends IGenericService<Job>{
       
    
    
       Job findByID(Integer id) throws ObjectNotFoundException;
        
       
    List<Job> findByCompany(Job job) throws ObjectNotFoundException;
      List<Job> findByLocation(Job job) throws ObjectNotFoundException;
       List<Job> findByCategory(Job job) throws ObjectNotFoundException;

       void jobActivation(Job job);
       
       void jobDisable (Job job);
       
        void postJob(Job job);
        
        
         
        

}
