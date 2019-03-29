/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Category;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;

/**
 *
 * @author habib
 */
public interface IJobDao extends IGenericDao<Job>{
    Job findByID(Integer id) throws DataBaseException;
    List<Job> findByCompany(Company company) throws DataBaseException;
    List<Job> findByCategory(Category category) throws DataBaseException;
    
    
}
