/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author habib
 */
public class SerivceJobImpl implements IServiceJob{
    
    IJobDao jobDao;
    
    public SerivceJobImpl (){
    jobDao = new JobDaoImpl();
    
}

    @Override
    public List<Job> findAll() throws DataBaseException {
        return jobDao.findAll();
    }

    @Override
    public Integer create(Job entity) throws DataBaseException {
return jobDao.create(entity);
        
        }

    @Override
    public Integer edit(Job entity) throws DataBaseException {
        return jobDao.edit(entity);
    }

    @Override
    public Integer delete(Job entity) throws DataBaseException {
        return jobDao.delete(entity);
        }

    @Override
    public Job findByID(Integer id) throws ObjectNotFoundException {
        try {
            return jobDao.findByID(id);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
      }

    @Override
    public List<Job> findByCompany(Job job) throws ObjectNotFoundException {
 
        try {
            return (ArrayList<Job>) findAll()
                    .stream()
                    .filter(t -> t.getCompany().getName().equals(job.getCompany().getName())
                    ).collect(Collectors.toList());
                    } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Job> findByLocation(Job job) throws ObjectNotFoundException {
       try {
            return (ArrayList<Job>) findAll()
                    .stream()
                    .filter(t -> t.getLocation().contains(job.getLocation())
               ).collect(Collectors.toList());
                    } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Job> findByCategory(Job job) throws ObjectNotFoundException {
       try {
            return (ArrayList<Job>) findAll()
                    .stream()
                    .filter(t -> t.getCategory().getId().equals(job.getCategory().getId())
               ).collect(Collectors.toList());
                    
                    } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }    @Override
    public void jobActivation(Job job) {
  
            job.setStatus(JobStatus.CONFIRMED);
        try {
            edit(job);
        } catch (DataBaseException ex) {

        }

    }

    @Override
    public void jobDisable(Job job) {
  

    
        try {
            job.setStatus(JobStatus.DISABLED);
            
            edit(job);
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
  
    public void postJob(Job job, User loggedUser) throws ConstraintViolationException {

        try {
            ICompanyDao companyDao = new CompanyDaoImpl();
            job.setCompany(companyDao.findByRecruter(loggedUser));
            job.setStatus(JobStatus.PENDING);
            job.setCreationDate(new Date());
            if (job.getExpireDate() == null) 
                throw  new ConstraintViolationException("missing expire date");
            if (job.getExpireDate().after(new Date())) 
                     throw  new ConstraintViolationException("invalid date");
            if (job.getCategory()== null) 
                           throw  new ConstraintViolationException("missing job category");
         
            if(job.getCompany()==null)
                throw new ConstraintViolationException("missing job company");
            
            if(job.getSalary()==null)
                throw new ConstraintViolationException("missing job salary");
            
            if (job.getDescription()==null)
                throw new ConstraintViolationException("missing job description");
            
            if (job.getTitle()== null) 
                throw new ConstraintViolationException("missing job title");
            
            if (job.getStatus()== null)
                throw new ConstraintViolationException("missing job title");
            
            
            
            
        } catch (DataBaseException ex) {
            throw new ConstraintViolationException(ex.getMessage());
        }

    }
   
    
}
