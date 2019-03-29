/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.interfaces.ICategoryDao;
import tn.esprit.entities.Category;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.entities.UserAccountStatus;
import tn.esprit.entities.UserRole;

/**
 *
 * @author Alai Zid
 */
public class CategoryDaoImpl extends GenericDaoImpl implements ICategoryDao{ 
  private Category category ;
  User moderator = null;
    @Override
    public List<Category> findAll() throws DataBaseException {
   List<Category> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Category.class.getSimpleName().toLowerCase());
        try 
        {
           resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                
                
                
                category= new Category.Builder().build();
                category.setId(resultSet.getInt("moderateur")) ;
               
                
                
                list.add(new Category.Builder()
                        .id(resultSet.getInt("id"))
                        
                        .label(resultSet.getString("label"))
                        .description(resultSet.getString("description"))
                        .moderator(moderator).build());
                        
                        

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        
        
        return list;
           
    }

    @Override
    public Integer create(Category entity) throws DataBaseException {
         Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("label"), ":label")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("moderator"), ":moderator")
                .inTable("Category");
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":label"),entity.getLabel());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":moderator"), entity.getModerator().toString());
            rowsCreated = preparedStatement.executeUpdate();
            
            resultSet = preparedStatement.getGeneratedKeys();

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;
    }

    @Override
    public Integer edit(Category entity) throws DataBaseException {
 Integer rowUpdated = 0;
        updateQuery=queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("label"), ":label")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("moderator"), ":moderator")
                .inTable("comment")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":label"),entity.getLabel());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":moderator"), entity.getModerator().toString());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } 

        return rowUpdated;
    }

    @Override
    public Integer delete(Category entity) throws DataBaseException {
       Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("Category")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(deleteQuery.getQueryString());
            preparedStatement.setInt(deleteQuery.getPlaceholderIndex(":id"), entity.getId());
            rowDeleted = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } 

        return rowDeleted;
    }
    
}
