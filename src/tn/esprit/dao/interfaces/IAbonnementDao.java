/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Company;
import tn.esprit.entities.User;

/**
 *
 * @author Alai Zid
 */
public interface IAbonnementDao extends IGenericDao<Abonnement> {

    /**
     *
     * @param candidate
     * @return
     * @throws DataBaseException
     */
    List<Abonnement> findByCandidate(User candidate) throws DataBaseException;

    /**
     *
     * @param company
     * @return
     * @throws DataBaseException
     */
    List<Abonnement> findByCompany(Company company) throws DataBaseException;

}
