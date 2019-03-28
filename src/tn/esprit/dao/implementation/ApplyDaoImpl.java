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
import tn.esprit.dao.interfaces.IApplyDao;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;

/**
 *
 * @author ali
 */
public class ApplyDaoImpl extends GenericDaoImpl implements IApplyDao {

    @Override
    public List<Apply> findAll() throws DataBaseException {
        List<Apply> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Apply.class.getSimpleName().toLowerCase());
        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new Apply.Builder()
                        .job (new Job.Builder().id(resultSet.getInt("job")).build())
                        .candidate(new User.Builder().id(resultSet.getInt("candidate")).build())
                        .letter(resultSet.getString("lastname"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
        
    }

    @Override
    public Integer create(Apply entity) throws DataBaseException {
        

        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("candidate"), ":candidate")
                .set(queriesFactory.newStdField("letter"), ":letter")
                
                .inTable("apply");
        
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":candidate"), entity.getCandidate().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":letter"), entity.getLetter());
           
            rowsCreated = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;
    
        
    }

    @Override
    public Integer edit(Apply entity) throws DataBaseException {
    Integer rowUpdated = 0;
        updateQuery=queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("candidate"), ":candidate")
                .set(queriesFactory.newStdField("letter"), ":letter")
                .inTable("apply")
                .where()
                .where(queriesFactory.newStdField("job"), ":job")
                .where(queriesFactory.newStdField("candidate"), ":candidate");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":candidate"), entity.getCandidate().getId());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":letter"), entity.getLetter());
            
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } 

        return rowUpdated;    
    }

    @Override
    public Integer delete(Apply entity) throws DataBaseException {
    
    Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        /*deleteQuery.from("apply")
                .where()
                .where(queriesFactory.newStdField("job"), ":job")
                .where(queriesFactory.newStdField("candidate"), ":candidate");
*/      
deleteQuery.from("apply")
   .where()
   .where(queriesFactory.newStdField("job"), ":job")
        .where(queriesFactory.newStdField("candidate"), ":candidate");
        
        try {
            preparedStatement = cnx.prepareStatement(deleteQuery.getQueryString());
            preparedStatement.setInt(deleteQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setInt(deleteQuery.getPlaceholderIndex(":candidate"), entity.getCandidate().getId());
            rowDeleted = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } 

        return rowDeleted;
    }
    
}
