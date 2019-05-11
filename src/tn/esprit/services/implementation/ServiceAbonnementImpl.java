/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.implementation;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.AbonnementDaoImpl;
import tn.esprit.dao.interfaces.IAbonnementDao;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Company;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.interfaces.IServiceAbonnement;

/**
 *
 * @author Dhia
 */
public class ServiceAbonnementImpl implements IServiceAbonnement {

    private final IAbonnementDao abonnementDao;

    public ServiceAbonnementImpl() {
        this.abonnementDao = new AbonnementDaoImpl();
    }

    @Override
    public List<Abonnement> findByCandidate(User candidate) throws ObjectNotFoundException {

        try {
            return abonnementDao.findByCandidate(candidate);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

    }

    @Override
    public List<Abonnement> findByCompany(Company company) throws ObjectNotFoundException {
        try {
            return abonnementDao.findByCompany(company);
        } catch (DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Abonnement> findAll() throws DataBaseException {
        return abonnementDao.findAll();
    }

    @Override
    public Integer create(Abonnement entity) throws DataBaseException {
       return abonnementDao.create(entity);
    }

    @Override
    public Integer edit(Abonnement entity) throws DataBaseException {
     return abonnementDao.edit(entity);
    }

    @Override
    public Integer delete(Abonnement entity) throws DataBaseException {
   
    return abonnementDao.create(entity);
    }

}
