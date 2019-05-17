/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.List;
import java.util.Optional;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CategoryDaoImpl;
import tn.esprit.dao.interfaces.ICategoryDao;
import tn.esprit.entities.Category;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceCategory;

/**
 *
 * @author habib
 */
public class ServiceCategoryImpl implements IServiceCategory {

    ICategoryDao dao;

    public ServiceCategoryImpl() {
        this.dao = new CategoryDaoImpl();
    }

    @Override
    public List<Category> findAll() throws DataBaseException {
        return dao.findAll();
    }

    @Override
    public Integer create(Category entity) throws DataBaseException {
        return dao.create(entity);

    }

    @Override
    public Integer edit(Category entity) throws DataBaseException {
        return dao.edit(entity);
    }

    @Override
    public Integer delete(Category entity) throws DataBaseException {
        return dao.delete(entity);

    }

    @Override
    public Category findByLabel(String label) throws ObjectNotFoundException {

        try {
            List<Category> categories = dao.findAll();

            Optional<Category> optional = categories.stream()
                    .filter(e -> e.getLabel().equalsIgnoreCase(label))
                    .findFirst();
            if (optional.isPresent()) {

                return optional.get();
            } else {
                throw new ObjectNotFoundException("category not found");
            }
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

}
