/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Comment;
/**
 *
 * @author Mehdi Sarray
 */
public interface IServiceComment extends IGenericService<Comment>{
    
      public Comment findByID(Integer id)throws DataBaseException;
}
