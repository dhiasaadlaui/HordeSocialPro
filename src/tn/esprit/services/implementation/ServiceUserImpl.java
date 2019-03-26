/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.List;
import java.util.Optional;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.User;
import tn.esprit.entities.UserRole;
import tn.esprit.gui.login.LanguageToolBar;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class ServiceUserImpl implements IServiceUser {

    /**
     *
     */
    IUserDao userDao;

    /**
     *
     */
    public ServiceUserImpl() {
        userDao = new UserDaoImpl();
    }

    /**
     *
     * @param identifier
     * @param password
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public User authentication(String identifier, String password) throws ObjectNotFoundException {

        try {
            List<User> users = userDao.findAll();
            Optional<User> optional = users.stream()
                    .filter(e -> (e.getUserName().equals(identifier) || e.getEmail().equals(identifier)))
                    .filter(e -> e.getPassword().equals(password))
                    .findFirst();
            if (optional.isPresent()) {
                return optional.get();
            } else {
                throw new ObjectNotFoundException(LanguageToolBar.BUNDLE.getString("loginfail"));
            }
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    /**
     *
     * @return @throws DataBaseException
     */
    @Override
    public List<User> findAll() throws DataBaseException {
        return userDao.findAll();
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer create(User entity) throws DataBaseException {
        return userDao.create(entity);
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer edit(User entity) throws DataBaseException {
        return userDao.edit(entity);
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer delete(User entity) throws DataBaseException {
        return userDao.delete(entity);
    }

    /**
     *
     * @param id
     * @return
     * @throws ObjectNotFoundException
     */
    @Override
    public User findByID(Integer id) throws ObjectNotFoundException {

        try {
            return userDao.findByID(id);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
        
        
       
    }

    @Override
    public Boolean SignUp(User user) throws ConstraintViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean banUser(User user) throws ConstraintViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean changeRole(User user, UserRole to) throws ConstraintViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean accountActivation(User user, String code) throws ConstraintViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
