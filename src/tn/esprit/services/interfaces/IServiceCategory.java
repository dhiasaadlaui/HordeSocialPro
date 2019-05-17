/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.interfaces;

import tn.esprit.entities.Category;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author habib
 */
public interface IServiceCategory extends IGenericService<Category> {

    Category findByLabel(String label) throws ObjectNotFoundException;

}
