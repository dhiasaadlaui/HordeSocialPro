/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.interfaces;

import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Company;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.User;

/**
 *
 * @author mghozzi
 */
public interface IReclamationDao extends IGenericDao<Reclamation>{
      public Reclamation findById(int id) throws DataBaseException ;
          
      }