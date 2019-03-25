/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.exceptions;



/**
 *
 * @author Dhia
 */
public class DataBaseException extends Exception{

    /**
     *
     * @param reason
     */
    public DataBaseException(String reason) {
        super(reason);
    }
    
    
}
