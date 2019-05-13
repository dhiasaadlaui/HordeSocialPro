/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;
import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.services.exceptions.ObjectNotFoundException;
/**
 *
 * @author Mehdi Sarray
 */
public interface IServiceComment extends IGenericService<Comment>{
    
    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    public Comment findByID(Integer id)throws ObjectNotFoundException;

    /**
     *
     * @param entity
     * @return
     * @throws ObjectNotFoundException
     */
    public Company getJobPoster(Comment entity) throws ObjectNotFoundException;

    /**
     *
     * @param name
     * @return
     * @throws ObjectNotFoundException
     */
    public List<Comment> findCommentByName(String name) throws ObjectNotFoundException;
    
    public List<Comment> findCommentByJob(Job job) throws ObjectNotFoundException;
}
