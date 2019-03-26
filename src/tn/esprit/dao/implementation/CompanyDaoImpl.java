/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.implementation;

import java.sql.SQLException;
import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Company;

/**
 *
 * @author mghozzi
 */
public class CompanyDaoImpl extends GenericDaoImpl implements ICompanyDao {

    @Override
    public List<Company> findAll() throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  Integer create(Company entity) throws DataBaseException { 
          Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("name"), ":name")
                .set(queriesFactory.newStdField("recruiter"), ":recruiter")
                .set(queriesFactory.newStdField("adress"), ":adress")
                .set(queriesFactory.newStdField("domain"), ":domain")
                .set(queriesFactory.newStdField("phone"), ":phone")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("image"), ":image")
           
                .inTable("company");
        try {
            preparedStatement = cnx.prepareStatement(insertQuery.getQueryString());
             preparedStatement.setObject(insertQuery.getPlaceholderIndex(":recruiter"), entity.getRecruiter().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":name"), entity.getName());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":adress"), entity.getAdress());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":domain"), entity.getDomain());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":phone"), entity.getPhone());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":image"), entity.getImage());
            rowsCreated = preparedStatement.executeUpdate();
       
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  

    @Override
    public Integer edit(Company entity) throws DataBaseException {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Company entity) throws DataBaseException {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
