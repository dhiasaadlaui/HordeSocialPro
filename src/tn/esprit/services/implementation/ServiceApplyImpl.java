/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.ApplyDaoImpl;
import tn.esprit.dao.interfaces.IApplyDao;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.services.interfaces.IServiceApply;

/**
 *
 * @author mourad
 */
public class ServiceApplyImpl implements IServiceApply{
    
    IApplyDao iapply;
    
    /**
     *
     */
    public ServiceApplyImpl(){
        iapply = new ApplyDaoImpl();
    }
    
    /**
     *
     * @param job
     * @param category
     * @param salarymin
     * @param salarymax
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Apply> advancedsearch(String job, String category, double salarymin, double salarymax) throws DataBaseException {
        List<Apply> l = iapply.findAll();
         List<Apply> advancedapply = new ArrayList<>();
         l.stream().filter((a) -> ((a.getJob().getCategory().getLabel().equals(category))&& (a.getJob().getTitle().equals(job))&&((a.getJob().getSalary() >= salarymin))&&(a.getJob().getSalary() <= salarymax))).forEachOrdered((a) -> {
             advancedapply.add(a);
        });
    return advancedapply;
}

    @Override
    public List<Apply> findAll() throws DataBaseException {
        return iapply.findAll();
    }

    @Override
    public Integer create(Apply entity) throws DataBaseException {
        return iapply.create(entity);
    }

    @Override
    public Integer edit(Apply entity) throws DataBaseException {
        return iapply.create(entity);
    }

    @Override
    public Integer delete(Apply entity) throws DataBaseException {
        return iapply.delete(entity);
    }

    /**
     *
     * @param job
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Apply> findByjob(Job job) throws DataBaseException {
       return iapply.findByjob(job);
    }

    /**
     *
     * @param candidate
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Apply> findBycandidate(User candidate) throws DataBaseException {
        return iapply.findBycandidate(candidate);
    }

   
}