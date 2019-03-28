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
import tn.esprit.dao.implementation.JobDaoImpl;
import tn.esprit.entities.Category;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
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
                IServiceUser serviceUser = new ServiceUserImpl();

         
           
                
                
                
               
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                /*User user;
                
        try {
            user = serviceUser.authentication("habib", "azerty");
                Company company = new Company.Builder()
                    .recruiter(user)
                    .name("vermeg")
                    .description("good")
                    .adress("lac 1")
                    .domain("dev")
                    .image("img.png")
                    .phone("555")
                    .build();
                
                
            Category category = new Category.Builder()
                    .id(1)
                    .label("dev info")
                    .description("good")
                    .moderator(user)
                    .build();
              Job job = new Job.Builder()
                    .id(1)
                    
                    .title("developerNEW").
                      company(company)
                    .description("job descriptionNEW")
                    .category(category)
                    .location("mouroujNEW")
                    .creationDate(new Date())
                    .expireDate(new Date())
                    .salary(1500d)
                    .status(JobStatus.PENDING)
                    .build();
              
              JobDaoImpl jdi = new JobDaoImpl();
                    try {
                        jdi.delete(job);
                    } catch (DataBaseException ex) {
                    }
        
        } catch (ObjectNotFoundException ex) {


        }*/

      
    }
}
