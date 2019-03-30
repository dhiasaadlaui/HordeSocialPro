/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.AbonnementDaoImpl;
import tn.esprit.dao.implementation.ApplyDaoImpl;
import tn.esprit.dao.implementation.CategoryDaoImpl;
import tn.esprit.dao.implementation.CommentDaoImpl;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.dao.implementation.RateDaoImpl;
import tn.esprit.dao.implementation.ReclamationDaoImpl;
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IAbonnementDao;
import tn.esprit.dao.interfaces.IApplyDao;
import tn.esprit.dao.interfaces.ICategoryDao;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.IRateDao;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Rate;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class TestHabib {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        IUserDao userDao = new UserDaoImpl();
        ICategoryDao categoryDao = new CategoryDaoImpl();
        ICompanyDao companyDao = new CompanyDaoImpl();
        IJobDao jobDao = new JobDaoImpl();
        IApplyDao applyDao = new ApplyDaoImpl();
        ICommentDao commentDao = new CommentDaoImpl();
        IServiceUser serviceUser = new ServiceUserImpl();
        IReclamationDao reclamationdao = new ReclamationDaoImpl();
        IAbonnementDao abonnementDao = new AbonnementDaoImpl();
        IRateDao rateDao = new RateDaoImpl();

        try {
            rateDao.delete(rateDao.findAll().get(0));
        } catch (DataBaseException ex) {
            ex.getMessage();
        }

    }

}
