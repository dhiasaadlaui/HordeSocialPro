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
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;

/**
 *
 * @author Mehdi Sarray
 */
public final class CommentDaoImpl extends GenericDaoImpl implements ICommentDao {

    IUserDao userDao;
    IJobDao jobDao;

    public CommentDaoImpl() {
        userDao = new UserDaoImpl();
        jobDao = new JobDaoImpl();
    }

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
                list.add(new Comment.Builder()
                        .id(resultSet.getInt("id"))
                        .user(userDao.findByID(resultSet.getInt(User.class.getSimpleName().toLowerCase())))
                        .job(jobDao.findByID(resultSet.getInt(Job.class.getSimpleName().toLowerCase())))
                        .content(resultSet.getString("content"))
                        .date(resultSet.getTimestamp("datecom").toLocalDateTime())
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
        insertQuery.set(queriesFactory.newStdField(User.class.getSimpleName().toLowerCase()), ":user")
                .set(queriesFactory.newStdField(Job.class.getSimpleName().toLowerCase()), ":job")
                .set(queriesFactory.newStdField("content"), ":content")
                .set(queriesFactory.newStdField("datecom"), ":datecom")
                .inTable(Comment.class.getSimpleName().toLowerCase());
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":user"), entity.getUser().getId());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":content"), entity.getContent());
            preparedStatement.setTimestamp(insertQuery.getPlaceholderIndex(":datecom"), java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            rowsCreated = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;
    }

    @Override
    public Integer edit(Comment entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField(User.class.getSimpleName().toLowerCase()), ":user")
                .set(queriesFactory.newStdField(Job.class.getSimpleName().toLowerCase()), ":job")
                .set(queriesFactory.newStdField("content"), ":content")
                .set(queriesFactory.newStdField("datecom"), ":datecom")
                .inTable(Comment.class.getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":user"), entity.getUser().getId());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":content"), entity.getContent());
            preparedStatement.setTimestamp(updateQuery.getPlaceholderIndex(":datecom"), java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
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
        deleteQuery.from(Comment.class.getSimpleName().toLowerCase())
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

    /**
     *
     * @param id
     * @return
     * @throws DataBaseException
     */
    @Override
    public Comment findByID(Integer id) throws DataBaseException {
        Comment comment = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from(Comment.class.getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":id"), id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comment = new Comment.Builder()
                        .id(resultSet.getInt("id"))
                        .user(userDao.findByID(resultSet.getInt(User.class.getSimpleName().toLowerCase())))
                        .job(jobDao.findByID(resultSet.getInt(Job.class.getSimpleName().toLowerCase())))
                        .content(resultSet.getString("content"))
                        .date(resultSet.getTimestamp("datecom").toLocalDateTime())
                        .build();
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return comment;
    }

}
