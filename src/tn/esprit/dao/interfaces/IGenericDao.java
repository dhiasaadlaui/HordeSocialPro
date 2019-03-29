/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;

/**
 *
 * @author Dhia
 * @param <T>
 */
public interface IGenericDao<T> {

    /**
     *
     * @return @throws DataBaseException
     */
    List<T> findAll() throws DataBaseException;

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    Integer create(T entity) throws DataBaseException;

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    Integer edit(T entity) throws DataBaseException;

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    Integer delete(T entity) throws DataBaseException;

}
