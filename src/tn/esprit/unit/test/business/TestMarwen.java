/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import static com.sun.scenario.effect.impl.prism.PrImage.create;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.implementation.CompanyDaoImpl;

import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Company;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author mghozzi
 */
public class TestMarwen {

    /**
     *
     * @param args
     * @throws tn.esprit.services.exceptions.ObjectNotFoundException
     */
    public static void main(String[] args) throws ObjectNotFoundException {

        IServiceUser serviceUser = new ServiceUserImpl();
        ICompanyDao companyDao = new CompanyDaoImpl();
     


       
       
       
       
    }
    
    
    
    
    
    
}
