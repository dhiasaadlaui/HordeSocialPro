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
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Category;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;
import tn.esprit.entities.User;

import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceUserImpl;
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

//        String[] adrs = {"dhiasaadlaui@gmail.com","mohameddhia.saadlaui@esprit.tn"};
//        
//        try {
//            ServiceMail.sendMailToAll(adrs, "masstest", "masstest");
//            
        IServiceUser serviceUser = new ServiceUserImpl();

        try {
            User user = serviceUser.authentication("vansword", "abcd1234");
            System.out.println(user.toString());

            Category category = new Category.Builder()
                    .id(55)
                    .label("Java")
                    .description("Programming language")
                    .moderator(user)
                    .build();
            System.out.println(category);

            Company company = new Company.Builder()
                    .recruiter(user)
                    .name("company name")
                    .description("desc company")
                    .adress("240 ghazela technopole")
                    .domain("IT")
                    .image("img44.png")
                    .phone("55 666 777")
                    .build();
            System.out.println(company);

            Job job = new Job.Builder()
                    .id(66)
                    .company(company)
                    .title("developer")
                    .description("job description")
                    .category(category)
                    .location("mourouj")
                    .creationDate(new Date())
                    .expireDate(new Date())
                    .salary(1200d)
                    .status(JobStatus.PENDING)
                    .build();
            System.out.println(job);

            Apply apply = new Apply.Builder()
                    .candidate(user)
                    .job(job)
                    .letter("im java developer and interested in this job")
                    .build();
            System.out.println(apply);

            Comment comment = new Comment.Builder()
                    .id(300)
                    .user(user)
                    .job(job)
                    .content("nice opportunity")
                    .build();
            System.out.println(comment);
            
            Reclamation reclamation = new Reclamation.Builder()
                    .id(624)
                    .type(ReclamationType.SCAM)
                    .details("this guy is scaming people asking for money")
                    .job(job)
                    .comment(comment)
                    .claimer(user)
                    .staff(user)
                    .feedback("we are investigating")
                    .status(ReclamationStatus.OPEN)
                    .build();
            System.out.println(reclamation);

        } catch (ObjectNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
//testing commit
        IUserDao userDao = new UserDaoImpl();
        try {
            System.out.println(userDao.findByID(1));
//                        .firstName("mokhtar")
//                        .lastName("chaouech")
//                        .userName("usernameee")
//                        .password("passssss")
//                        .email("mokhtar@gmail.com")
//                        .adress("20 rue istambul mourouj 4")
//                        .authorization("officer")
//                        .build();
//
//            System.out.println("number of rows created: "+userDao.create(user1));
//            System.out.println(user1);
//            user1.setFirstName("Sonya");
//            System.out.println("number of rows updated: "+userDao.edit(user1));
//            System.out.println(user1);
//           System.out.println("number of rows deleted: "+userDao.delete(user1));
//            System.out.println(user1);
//            List<User> allUsers = userDao.findAll();
//            for(User user : allUsers){
//                System.out.println(user.toString());
//           
//        } catch (MessagingException ex) {
//            Logger.getLogger(TestDhia.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (DataBaseException ex) {
            Logger.getLogger(TestDhia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
