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
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;

/**
 *
 * @author Mehdi Sarray
 */
public class CommentDaoImpl extends GenericDaoImpl implements ICommentDao{

    
    private Job job ;
    private User user ;
    
    @Override
    public List<Comment> findAll() throws DataBaseException {
        
        List<Comment> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Comment.class.getSimpleName().toLowerCase());
        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                
                job= new Job.Builder().build();
                user= new User.Builder().build();
                
                user.setId(resultSet.getInt("user")) ;
                job.setId(resultSet.getInt("job"));
                
                list.add(new Comment.Builder()
                        .id(resultSet.getInt("id"))
                        .user(user) 
                        .job(job)
                        .content(resultSet.getString("content"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        
        
        return list;
        
        
    }

    @Override
    public Integer create(Comment entity) throws DataBaseException {

        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("user"), ":user")
                .set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("content"), ":content")
                .inTable("Comment");
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":user"), entity.getUser().getId());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":content"), entity.getContent());
            rowsCreated = preparedStatement.executeUpdate();
            
            resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                entity.setId(resultSet.getInt(1));
//            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;
    }

    @Override
    public Integer edit(Comment entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery=queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("user"), ":user")
                .set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("content"), ":content")
                .inTable("comment")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":user"), entity.getUser() != null ? entity.getUser().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":job"), entity.getJob() != null ? entity.getJob().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":content"), entity.getContent());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } 

        return rowUpdated;
    }

    
   @Override 
   public Integer delete(Comment entity) throws DataBaseException {
        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("Comment")
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
   
    @Override
   public Comment findByID(Integer id) throws DataBaseException {
         Comment comment = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from("Comment")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":id"), id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comment = new Comment.Builder()
                        .id(resultSet.getInt("id"))
                        .user(new User.Builder().id(resultSet.getInt("user")).build())
                        .job(new Job.Builder().id(resultSet.getInt("job")).build())
                        .content(resultSet.getString("content"))
                        .build();

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return comment;
   }
}
