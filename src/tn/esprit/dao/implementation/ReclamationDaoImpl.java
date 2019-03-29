/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sun.plugin.dom.core.Comment;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.interfaces.ICommentDao;
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Company;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;

/**
 *
 * @author mghozzi
 */
public class ReclamationDaoImpl extends GenericDaoImpl implements IReclamationDao {

    private ICommentDao cammentDao;
    private IUserDao userDao;

    public ReclamationDaoImpl() {
        super();
        userDao = new UserDaoImpl();
    }

    @Override
    public Reclamation findById(int id) throws DataBaseException {
        Reclamation reclamation = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from("reclamation")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":id"), id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reclamation = new Reclamation.Builder()
                        .id(resultSet.getInt("id"))
                        .feedback(resultSet.getString("feedback"))
                        .details(resultSet.getString("details"))
                        .staff(userDao.findByID(resultSet.getInt("staff")))
                        .claimer(userDao.findByID(resultSet.getInt("claimer")))
                        .comment(cammentDao.findByID(resultSet.getInt("comment")))
                        .status(Enum.valueOf(ReclamationStatus.class, resultSet.getString("status")))
                        .type(Enum.valueOf(ReclamationType.class, resultSet.getString("type")))
                        // job

                        .build();

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return reclamation;

    }

    @Override
    public List<Reclamation> findAll() throws DataBaseException {
        List<Reclamation> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Reclamation.class.getSimpleName().toLowerCase());
        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new Reclamation.Builder()
                        .id(resultSet.getInt("id"))
                        .feedback(resultSet.getString("feedback"))
                        .details(resultSet.getString("details"))
                        .staff(userDao.findByID(resultSet.getInt("staff")))
                        .claimer(userDao.findByID(resultSet.getInt("claimer")))
                        .comment(cammentDao.findByID(resultSet.getInt("comment")))
                        .type(Enum.valueOf(ReclamationType.class, resultSet.getString("type")))
                        .status(Enum.valueOf(ReclamationStatus.class, resultSet.getString("status")))
                        // job

                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public Integer create(Reclamation entity) throws DataBaseException {
        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery
                .set(queriesFactory.newStdField("type"), ":type")
                .set(queriesFactory.newStdField("details"), ":details")
                .set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("comment"), ":comment")
                .set(queriesFactory.newStdField("staff"), ":staff")
                .set(queriesFactory.newStdField("feedback"), ":feedback")
                .set(queriesFactory.newStdField("status"), ":status")
                .inTable(Reclamation.class.getSimpleName().toLowerCase());
        try {
            preparedStatement = cnx.prepareStatement(insertQuery.getQueryString());

            preparedStatement.setString(insertQuery.getPlaceholderIndex(":type"), entity.getType());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":details"), entity.getDetails());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":comment"), entity.getComment().getId());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":staff"), entity.getStaff().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":feedback"), entity.getFeedback());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":status"), entity.getStatus());
            
            rowsCreated = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;
    }

    @Override
    public Integer edit(Reclamation entity) throws DataBaseException {

        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("id"), ":id")
                .set(queriesFactory.newStdField("type"), ":type")
                .set(queriesFactory.newStdField("details"), ":details")
                .set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("comment"), ":comment")
                .set(queriesFactory.newStdField("staff"), ":staff")
                .set(queriesFactory.newStdField("feedback"), ":feedback")
                .set(queriesFactory.newStdField("status"), ":status")
                .inTable(Company.class.getClass().getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("recruiter"), ":idrecruiter");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement = cnx.prepareStatement(insertQuery.getQueryString());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":type"), entity.getType());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":details"), entity.getDetails());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":job"), entity.getJob());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":comment"), entity.getComment());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":staff"), entity.getStaff());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":feedback"), entity.getFeedback());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":status"), entity.getStatus());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public Integer delete(Reclamation entity) throws DataBaseException {
        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("reclamation")
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
