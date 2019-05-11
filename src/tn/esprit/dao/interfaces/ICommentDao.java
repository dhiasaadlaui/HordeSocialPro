/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;

/**
 *
 * @author Mehdi Sarray
 */
public interface ICommentDao extends IGenericDao<Comment> {

    /**
     *
     * @param id
     * @return
     * @throws DataBaseException
     */
    public Comment findByID(Integer id) throws DataBaseException;
    
   // public Company getJobPoster(Comment entity) ;

}
