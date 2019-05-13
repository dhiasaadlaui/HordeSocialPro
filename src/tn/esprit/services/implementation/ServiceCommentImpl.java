/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CommentDaoImpl;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceComment;

/**
 *
 * @author Mehdi Sarray
 */
public class ServiceCommentImpl implements IServiceComment {

    ICommentDao icomment;
    IJobDao ijob;
    ICompanyDao icompany;

    /**
     *
     */
    public ServiceCommentImpl() {
        icomment = new CommentDaoImpl();
        ijob = new JobDaoImpl();
        icompany = new CompanyDaoImpl();
    }

    @Override
    public List<Comment> findAll() throws DataBaseException {
        return icomment.findAll();
    }

    @Override
    public Integer create(Comment entity) throws DataBaseException {
        return icomment.create(entity);
    }

    @Override
    public Integer edit(Comment entity) throws DataBaseException {
        return icomment.edit(entity);
    }

    @Override
    public Integer delete(Comment entity) throws DataBaseException {
        return icomment.delete(entity);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Comment findByID(Integer id) throws ObjectNotFoundException {
        try {
            return icomment.findByID(id);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    /**
     *
     * @param entity
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public Company getJobPoster(Comment entity) throws ObjectNotFoundException {
        try {
            return icompany.findByRecruter(new User.Builder().id(ijob.findByID(entity.getJob().getId()).getCompany().getRecruiter().getId()).build());
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    /**
     *
     * @param name
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public List<Comment> findCommentByName(String name) throws ObjectNotFoundException {
        try {
            return findAll().stream().filter(e -> e.getUser().getUserName().equalsIgnoreCase(name)).collect(Collectors.toList());
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    @Override
    public List<Comment> findCommentByJob(Job job) throws ObjectNotFoundException {
        try {
            return findAll().stream().filter(e -> e.getJob().getId().equals(job.getId())).collect(Collectors.toList());
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

}
