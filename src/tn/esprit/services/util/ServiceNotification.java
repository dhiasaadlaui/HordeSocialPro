/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javafx.concurrent.Task;
import tn.esprit.entities.Company;
import tn.esprit.entities.Notification;
import tn.esprit.services.implementation.ServiceCommentImpl;
import tn.esprit.services.implementation.ServiceNotificationImpl;
import tn.esprit.services.interfaces.IServiceComment;
import tn.esprit.services.interfaces.IServiceNotification;

/**
 *
 * @author Mehdi Sarray
 */
public class ServiceNotification {
    
    
    IServiceComment serv0 = new ServiceCommentImpl();
    IServiceNotification serv1 = new ServiceNotificationImpl();
    List<Notification> listNotif = new ArrayList<>() ;
    
    private Executor exec ; //provides a pool of threads...

//    public void startJob(Company cm )
//    {
//         Task<Void> task = new Task<Void>() {
//        @Override
//        protected Void call() throws Exception {
//            while(true) { 
//                
//             listNotif= serv1.getNotificationByUser(cm) ;
//           
//                 //serv1.edit(nf) ; // JUST SETTING THE IS READ VALUE TO 1 
//                 System.out.println("Thread is doing the JOB");
//          
//           
//             Thread.sleep(3000); //risky but we don't give a shit
//            
//                System.out.println("i ve slept for 3s");
//            }
//            
//        }
//          };
//        new Thread(task).start();
//    }

    /**
     *
     * @param cm
     * @throws Exception
     */
    
    public void initialize(Company cm) throws Exception {
        listNotif= serv1.getNotificationByUser(cm) ;

        // create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t ;
        });
    }
    
    
    
    
    
}
