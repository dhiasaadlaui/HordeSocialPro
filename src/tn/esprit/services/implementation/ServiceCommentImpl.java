/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CommentDaoImpl;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.entities.Comment;
import tn.esprit.services.interfaces.IServiceComment;

/**
 *
 * @author Mehdi Sarray
 */
public class ServiceCommentImpl implements IServiceComment {

    ICommentDao icomment;

    /**
     *
     */
    public ServiceCommentImpl() {
        icomment = new CommentDaoImpl();
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
     * @throws DataBaseException
     */
    @Override
    public Comment findByID(Integer id) throws DataBaseException {
        return icomment.findByID(id);
    }
}
