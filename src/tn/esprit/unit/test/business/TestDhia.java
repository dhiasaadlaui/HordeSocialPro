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
import tn.esprit.dao.implementation.NotificationDaoImpl;
import tn.esprit.dao.implementation.RateDaoImpl;
import tn.esprit.dao.implementation.ReclamationDaoImpl;
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IAbonnementDao;
import tn.esprit.dao.interfaces.IApplyDao;
import tn.esprit.dao.interfaces.ICategoryDao;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.INotificationDao;
import tn.esprit.dao.interfaces.IRateDao;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationType;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.ServiceApplyImpl;
import tn.esprit.services.implementation.ServiceCommentImpl;
import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceApply;
import tn.esprit.services.interfaces.IServiceComment;
import tn.esprit.services.interfaces.IServiceReclamation;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class TestDhia {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //-----------DAO LAYER----------------
        IUserDao userDao = new UserDaoImpl();
        ICategoryDao categoryDao = new CategoryDaoImpl();
        ICompanyDao companyDao = new CompanyDaoImpl();
        IJobDao jobDao = new JobDaoImpl();
        IApplyDao applyDao = new ApplyDaoImpl();
        ICommentDao commentDao = new CommentDaoImpl();
        IReclamationDao reclamationdao = new ReclamationDaoImpl();
        IAbonnementDao abonnementDao = new AbonnementDaoImpl();
        IRateDao rateDao = new RateDaoImpl();
        INotificationDao notificationDao = new NotificationDaoImpl();

        //-----------SERVICE LAYER-------------
        
        IServiceUser serviceUser = new ServiceUserImpl();
        IServiceApply serviceApply = new ServiceApplyImpl();
        IServiceComment serviceComment = new ServiceCommentImpl();
        IServiceReclamation serviceReclamation = new ServiceReclamationImpl();
        
        
        
        try {
            System.out.println(userDao.findAll());
            System.out.println(categoryDao.findAll());
            System.out.println(companyDao.findAll());
            System.out.println(jobDao.findAll());
            System.out.println(applyDao.findAll());
            System.out.println(commentDao.findAll());
            System.out.println(reclamationdao.findAll());
            System.out.println(abonnementDao.findAll());
            System.out.println(rateDao.findAll());
            System.out.println(notificationDao.findAll());
            
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
//        
//        try {
//            
//            serviceReclamation.claim(
//                    new Reclamation.Builder()
//                            .type(ReclamationType.SCAM)
//                            .job(jobDao.findByID(2))
//                    .build()
//                    , userDao.findByID(2));
//            
//        } catch (DataBaseException ex) {
//               System.out.println(ex.getMessage());
//        } catch (ConstraintViolationException ex) {
//            System.out.println(ex.getMessage());
//        }
//        

    }
}
