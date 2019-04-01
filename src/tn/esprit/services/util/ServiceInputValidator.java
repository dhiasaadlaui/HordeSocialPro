/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import java.util.Date;
import tn.esprit.services.exceptions.ConstraintViolationException;

/**
 *
 * @author mdsaadlaoui
 */
public class ServiceInputValidator {

    /**
     *
     * @param text
     * @throws ConstraintViolationException
     */
    public static void string(String text) throws ConstraintViolationException {
        if ((text == null)||!text.matches("^[a-zA-Z]+$")) {
            throw new ConstraintViolationException("Invalid String");
        }
    }

    /**
     *
     * @param text
     * @throws ConstraintViolationException
     */
    public static void username(String text) throws ConstraintViolationException {
        if ( (text == null)|| !text.matches("^[A-Za-z0-9]+$")) {
            throw new ConstraintViolationException("Invalid Username");
        }

    }

    /**
     *
     * @param text
     * @throws ConstraintViolationException
     */
    public static void mail(String text) throws ConstraintViolationException {
        if ( (text == null)||(!text.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" )) ) {
            throw new ConstraintViolationException("Invalid mail");
        }

    }

    /**
     *
     * @param date
     * @throws ConstraintViolationException
     */
    public static void isValidDate(Date date) throws ConstraintViolationException {
        if (!date.after(new Date())) {
            throw new ConstraintViolationException("Invalid date");
        }
    }

}
