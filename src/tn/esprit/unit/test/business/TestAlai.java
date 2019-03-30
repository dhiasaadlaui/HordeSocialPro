/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class TestAlai {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
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
    