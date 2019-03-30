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
import tn.esprit.dao.implementation.AbonnementDaoImpl;
import tn.esprit.dao.implementation.ApplyDaoImpl;
import tn.esprit.dao.implementation.CategoryDaoImpl;
import tn.esprit.dao.implementation.CommentDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.dao.implementation.RateDaoImpl;
import tn.esprit.dao.implementation.ReclamationDaoImpl;

import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IAbonnementDao;
import tn.esprit.dao.interfaces.IApplyDao;
import tn.esprit.dao.interfaces.ICategoryDao;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.IRateDao;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.HandleReclamationModerator;
import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceReclamation;
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
        
        IServiceReclamation serviceReclamation = new ServiceReclamationImpl();
        
        
        try {
          
        
            
            serviceReclamation.handleModerator(reclamationdao.findById(3), HandleReclamationModerator.DISABLE_JOB);
        } catch (DataBaseException|  ConstraintViolationException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
