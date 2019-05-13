/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Category;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.User;
import tn.esprit.entities.UserAccountStatus;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceJob;
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
             IServiceJob serviceJob ;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
     
//                               IServiceJob sj = new SerivceJobImpl();
//                               
//                               IServiceUser usrService =  new ServiceUserImpl();
//                               
//                 try {
//                     User recr = usrService.findByID(2);
//                                                   ICompanyDao cdao = new CompanyDaoImpl();
//                              Company cc = cdao.findByRecruter(recr);
//                              
//                 } catch (ObjectNotFoundException ex) {
//                     Logger.getLogger(TestHabib.class.getName()).log(Level.SEVERE, null, ex);
//                 }
//                               
//                               
//
//                    
//                     User user1 = new User.Builder()
//                             .id(2)
//                             .firstName("habibbbbbbbbb")
//                             .lastName("aliii")
//                             .userName("habibaliiii")
//                             .accountStatus(UserAccountStatus.ACTIVATED)
//                             .adress("ddkkkkkkd")
//                             .email("ssskkkks")
//                             .password("akka")
//                             .photo("img.kkilmg")
//                             .build();
//                     
//                     
//                     
//                     Category category = new Category.Builder()
//                             .id(2)
//                             .label("just a gat")
//                             .description("ddd")
//                             .moderator(user1)
//                             .build();
//                     
//                     Date vcreationDate = new Date ();
//              
//           
//                     Job job = new Job.Builder()
//                             .category(category)
//                             .company(company)
//                             .creationDate(vcreationDate)
//                             .description("god")
//                             .expireDate(new Date())
//                             .location("fedar")
//                             .salary(100.0)
//                             .title("devv")
//                             .status(JobStatus.PENDING)
//                             .build();
//                     
//                     
//                 try {
//                     sj.postJob(job, user);
//                 } catch (ConstraintViolationException ex) {
//                     System.out.println(ex.getMessage());
//                 }
//               
             
                 
       
        
        
 }

}
