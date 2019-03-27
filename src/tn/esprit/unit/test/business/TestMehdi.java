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
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceCommentImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceComment;
import tn.esprit.services.interfaces.IServiceUser;

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
        IServiceComment serv0  = new ServiceCommentImpl();
        
        
//        
//        CREATE COMMENT 
        
//        User user1 = new User.Builder().id(1).build() ;
//        user1.setId(1);
//        System.out.println(user1);
//        Job  job1 = new Job.Builder().id(2).build() ;
//        System.out.println(job1.getId());
//        
//        
//        Comment com1 = new Comment.Builder().job(job1).content("TESTING one").build() ;
//        
//        com1.setUser(user1);
//        System.out.println(com1.getUser().getId());
//        
//        
//        System.out.println(com1);
//        try {
//            System.out.println(serv0.create(com1))  ;
//        } catch (DataBaseException ex) {
//            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
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
            
            // UPDATE TEST
            
            Comment mc = new Comment.Builder().build() ;
             try {
             mc = serv0.findByID(1) ;
              } catch (DataBaseException ex) {
            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(mc);
        
     
        
       mc.setContent("WORKING");
        
        try {
           int c = serv0.edit(mc) ;
            
            } catch (DataBaseException ex) {
            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
//            // DELETE TEST
//        
//        Comment mc = new Comment.Builder().id(2).build() ;
//        try {
//            serv0.delete(mc) ;
//        } catch (DataBaseException ex) {
//            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
        
      
        
        
    }
}
