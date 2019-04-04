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
import static jdk.nashorn.internal.objects.NativeFunction.apply;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.ApplyDaoImpl;
import tn.esprit.dao.interfaces.IApplyDao;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.services.implementation.ServiceApplyImpl;
import tn.esprit.services.implementation.ServiceCommentImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceApply;
import tn.esprit.services.interfaces.IServiceComment;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class TestTarek {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
      /*  IApplyDao hh= new ApplyDaoImpl();
        
        User user1 = new User.Builder().id(1).build() ;
   user1.setId(1);
        System.out.println(user1.toString());
       Job  job1 = new Job.Builder().id(2).build() ;
        System.out.println(job1.getId().toString());
        
        
        Apply capp1 = new Apply.Builder().job(job1).build() ;
        
        capp1.setCandidate(user1);
        System.out.println(capp1.getCandidate().getId());
        
        
        System.out.println(capp1);
        try {
            System.out.println(hh.create(capp1))  ;
        } catch (DataBaseException ex) {
            Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
        
        
//    List<Apply> apply = new ArrayList<>() ;
        
   //     try {
       //     apply = hh.findAll() ;
        //} catch (DataBaseException ex) {
       //     Logger.getLogger(TestMehdi.class.getName()).log(Level.SEVERE, null, ex);
       // }
        
      //  for(Apply c : apply )
      //  {
      //      System.out.println(c);
     //  }
        
     
            
     
    }
}*/
        IApplyDao apply = new ApplyDaoImpl();
        IServiceApply apply1 = new ServiceApplyImpl();
        User us = new User.Builder().build();
        us.setId(2);
        Apply app1 = new Apply.Builder().build();
        Job j1 = new Job.Builder().build();
        j1.setId(1);
        app1.setJob(j1);
        app1.setCandidate(us);
    
    //try {
      //  System.out.println(apply1.advancedsearch("aa","java",102,454510));
    //}catch (DataBaseException ex){
      //  System.out.println(ex.getMessage());
    //}
    //try {
      //  System.out.println(apply1.create(app1));
    //}catch (DataBaseException ex){
      //  System.out.println(ex.getMessage());
    //}
  //  try {
    //    System.out.println(apply1.delete(app1));
    //}catch (DataBaseException ex){
      //  System.out.println(ex.getMessage());
   // }
   try {
        System.out.println(apply1.findAll());
    }catch (DataBaseException ex){
        System.out.println(ex.getMessage());
    }
        
    
    
    }}

