/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import java.lang.reflect.Field;
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
import tn.esprit.services.exceptions.ConstraintViolationException;

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

        Field[] fields = User.class.getDeclaredFields();
        for (Field f : fields) {
            Class t = f.getType();
            System.out.println(t);

        }

        //       try {
        //        String[] adrs = {"dhiasaadlaui@gmail.com","mohameddhia.saadlaui@esprit.tn"};
//
//        try {
//            ServiceMail.sendMailToAll(adrs, "masstest", "masstest");
//
        IServiceUser serviceUser = new ServiceUserImpl();
        try {
            User user = serviceUser.findByID(5);
            serviceUser.accountActivation(user, "Zy7DAJXH6k");
        } catch (ConstraintViolationException ex) {
            System.out.println(ex.getMessage());
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(TestDhia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
