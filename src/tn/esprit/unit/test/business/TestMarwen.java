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
    public static void main(String[] args)  {
     
           
           IServiceUser serviceUser = new ServiceUserImpl();
            try {
           ICompanyDao companyDao = new CompanyDaoImpl() ;
           User user = serviceUser.authentication("vansword", "abcd1234");
           
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
        
        companyDao.create(company) ;
        System.out.println("created");
        } catch (ObjectNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (DataBaseException ex) {
            Logger.getLogger(TestMarwen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
