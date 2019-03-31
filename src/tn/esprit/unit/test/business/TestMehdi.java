/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.Notification;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceCommentImpl;
import tn.esprit.services.implementation.ServiceNotificationImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceComment;
import tn.esprit.services.interfaces.IServiceNotification;
import tn.esprit.services.interfaces.IServiceUser;
import tn.esprit.services.util.ServiceNotification;

/**
 *
 * @author Dhia
 */
public class TestMehdi {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        IServiceComment serv0 = new ServiceCommentImpl();
        IServiceNotification serv1 = new ServiceNotificationImpl() ;
        IServiceUser serv2 = new ServiceUserImpl(); 
        ServiceNotification sn = new ServiceNotification() ;
        IServiceNotification serv3 = new ServiceNotificationImpl();
//        
//      //  CREATE COMMENT 
        User user1 = new User.Builder().id(1).build() ;
        user1.setId(4);
        System.out.println(user1);
        Job  job1 = new Job.Builder().id(2).build() ;
        System.out.println(job1.getId());
//        
//        
        Comment com1 = new Comment.Builder().job(job1).content("TESTING hugug").build() ;
//        
        com1.setUser(user1);
        System.out.println(com1.getUser().getId());
        
     
        
        System.out.println(com1);
        try {
            System.out.println(serv0.create(com1))  ;
            
            Company ny = serv0.getJobPoster(com1) ;
            System.out.println(ny.getName());
            System.out.println(ny.getRecruiter().getId());
//            serv1.craftNotification(ny, com1);
            /** FRIST SCENARIO CREATUBG THE NOTIFICATION **/ /////////////////////<<<<<<<<<<<<<<
            
            
        } catch (DataBaseException ex) {
            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        // FINDALL TEST
//        
//        List<Comment> ls = new ArrayList<>() ;
//        
//        try {
//            ls = serv0.findAll() ;
//        } catch (DataBaseException ex) {
//            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for(Comment c : ls )
//        {
//            System.out.println(c);
//       }
//       //  UPDATE TEST
//        Comment mc = new Comment.Builder().build();
//        try {
//            mc = serv0.findByID(10);
//            System.out.println(mc);
//            mc.setContent("WORKING");
//            mc.setUser(new User.Builder().id(2).build());
//            mc.setJob(new Job.Builder().id(1).build());
//            System.out.println(serv0.edit(mc));
//        } catch (DataBaseException ex) {
//            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(mc);

//            // DELETE TEST
//        
//        Comment mc = new Comment.Builder().id(2).build() ;
//        try {
//            serv0.delete(mc) ;
//        } catch (DataBaseException ex) {
//            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
        
        
        
        
        // Thread TESTING NOTIFICATION 
         //CREATE NOTIF
      //  List<User>  listus = new ArrayList<>() ;
        
     //   listus = serv2.getLoggedInUsers() ; Suppose we have a list of loggedin users 
        
//        Company cm = new Company.Builder().recruiter(new User.Builder().id(2).build()).build() ;
//        sn.startJob(cm);
//      
//        System.out.println("GOING THROUGH THIIIS");
//        List<Notification> ns = new ArrayList<>(); 
//        
//         Company ny =new Company.Builder().recruiter(new User.Builder().id(2).build()).build() ;
//       
//       ns =  serv3.getNotificationByUser(ny) ;
//         
//         for(Notification nf  : ns)
//             System.out.println(nf.getId()+" "+nf.getIs_read()+" "+nf.getDate());
//         
//         
//         System.out.println(ns.size());
    }
}
