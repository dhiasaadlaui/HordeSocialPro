/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Category;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.User;
import tn.esprit.entities.UserAccountStatus;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.interfaces.IServiceJob;

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

    
    public static void main(String[] args) {

       
                
                     IServiceJob sj = new SerivceJobImpl();
                     User user = new User.Builder()
                             .id(1)
                             .firstName("habib")
                             .lastName("ali")
                             .userName("habibali")
                             .accountStatus(UserAccountStatus.ACTIVATED)
                             .adress("ddd")
                             .email("ssss")
                             .password("aa")
                             .photo("img.ilmg")
                             .build();
                     User user1 = new User.Builder()
                             .id(2)
                             .firstName("habibbbbbbbbb")
                             .lastName("aliii")
                             .userName("habibaliiii")
                             .accountStatus(UserAccountStatus.ACTIVATED)
                             .adress("ddkkkkkkd")
                             .email("ssskkkks")
                             .password("akka")
                             .photo("img.kkilmg")
                             .build();
                     Company company = new Company.Builder()
                             
                             .name("vermeg")
                             .adress("lac1")
                             .description("good")
                             .domain("dev")
                             .image("img.png")
                             .phone("225")
                             .recruiter(user1)
                             .build();
                     
                     
                     Category category = new Category.Builder()
                             .id(2)
                             .label("just a gat")
                             .description("ddd")
                             .moderator(user1)
                             .build();
                     
                     Date vcreationDate = new Date ();
                     
                 try {
                     Job job = sj.findByID(8);
                       System.out.println(job);
                 sj.jobDisable(job);
                     System.out.println(job);
                     sj.jobActivation(job);
                     System.out.println(job);
                 } catch (ObjectNotFoundException ex) {
                     Logger.getLogger(TestHabib.class.getName()).log(Level.SEVERE, null, ex);
                 }
               
             
                 
        
        
        
 }

}
