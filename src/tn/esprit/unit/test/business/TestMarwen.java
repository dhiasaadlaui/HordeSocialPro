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
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.implementation.UserDaoImpl;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Company;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceUserImpl;
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
    public static void main(String[] args) throws ObjectNotFoundException {

        IServiceUser serviceUser = new ServiceUserImpl();
        ICompanyDao companyDao = new CompanyDaoImpl();
        
        try {
          //  System.out.println(companyDao.findByRecruter(serviceUser.findByID(1)));
            
            System.out.println(companyDao.findAll());
            
            
            
            
            
            
            
            
            
            
            /* try {
            User user = serviceUser.authentication("vansword", "abcd1234");

            try {
            
            companyDao.edit(
            new Company.Builder()
            .recruiter(user)
            .name("Vermeg edited")
            .description("it company edited")
            .adress("lac 1 edited")
            .domain("java jee edited")
            .image("/img_8.jpg edited")
            .phone("+22 222 222 edited")
            .build()
            );
            
            
            
            
            } catch (DataBaseException ex) {
            System.out.println("marwen error" + ex.getMessage());
            }
            } catch (ObjectNotFoundException ex) {
            System.out.println("authentification error" + ex.getMessage());
            }*/
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
       
       
       
       
    }
    
    
    
    
    
    
}
