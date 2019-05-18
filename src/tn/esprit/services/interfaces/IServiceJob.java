/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Category;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author habib
 */
public interface IServiceJob extends IGenericService<Job> {

    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    Job findByID(Integer id) throws ObjectNotFoundException;

    /**
     *
     * @param job
     * @return
     * @throws ObjectNotFoundException
     */
    List<Job> findByCompany(Company company) throws ObjectNotFoundException;

    /**
     *
     * @param job
     * @return
     * @throws ObjectNotFoundException
     */
    List<Job> findByLocation(String location) throws ObjectNotFoundException;

    /**
     *
     * @param job
     * @return
     * @throws ObjectNotFoundException
     */
    List<Job> findByCategory(Category category) throws ObjectNotFoundException;

    /**
     *
     * @param job
     */
    void jobActivation(Job job) throws ConstraintViolationException;

    /**
     *
     * @param job
     */
    void jobDisable(Job job) throws ConstraintViolationException;

    /**
     *
     * @param job
     * @param loggedUser
     * @throws ConstraintViolationException
     */
    void postJob(Job job, User loggedUser) throws ConstraintViolationException;

}
