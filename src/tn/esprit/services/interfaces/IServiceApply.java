/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;

/**
 *
 * @author mourad
 */
public interface IServiceApply extends IGenericService<Apply>{
     public List<Apply> findByjob(Job job) throws DataBaseException;
      public List<Apply> findBycandidate(User candidate) throws DataBaseException ;
      public List<Apply> advancedsearch(String job , String category , double salarymin ,double salarymax) throws DataBaseException;
    
}
