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
import tn.esprit.dao.interfaces.IReclamationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Job;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.ReclamationStatus;
import tn.esprit.entities.ReclamationType;

/**
 *
 * @author mghozzi
 */
public final class ReclamationDaoImpl extends GenericDaoImpl implements IReclamationDao {

    private final ICommentDao cammentDao;
    private final IUserDao userDao;
    private final IJobDao jobDao;

    /**
     *
     */
    public ReclamationDaoImpl() {
        super();
        userDao = new UserDaoImpl();
        cammentDao = new CommentDaoImpl();
        jobDao = new JobDaoImpl();
    }

    /**
     *
     * @param id
     * @return
     * @throws DataBaseException
     */
    @Override
    public Reclamation findById(int id) throws DataBaseException {
        Reclamation reclamation = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from(Reclamation.class.getSimpleName().toLowerCase())
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
                        .comment(cammentDao.findByID(resultSet.getInt(Comment.class.getSimpleName().toLowerCase())))
                        .status(Enum.valueOf(ReclamationStatus.class, resultSet.getString("status")))
                        .type(Enum.valueOf(ReclamationType.class, resultSet.getString("type")))
                        .job(jobDao.findByID(resultSet.getInt(Job.class.getSimpleName().toLowerCase())))
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
                        .comment(cammentDao.findByID(resultSet.getInt(Comment.class.getSimpleName().toLowerCase())))
                        .type(Enum.valueOf(ReclamationType.class, resultSet.getString("type")))
                        .status(Enum.valueOf(ReclamationStatus.class, resultSet.getString("status")))
                        .job(jobDao.findByID(resultSet.getInt(Job.class.getSimpleName().toLowerCase())))
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
                .set(queriesFactory.newStdField(Job.class.getSimpleName().toLowerCase()), ":job")
                .set(queriesFactory.newStdField("claimer"), ":claimer")
                .set(queriesFactory.newStdField(Comment.class.getSimpleName().toLowerCase()), ":comment")
                .set(queriesFactory.newStdField("staff"), ":staff")
                .set(queriesFactory.newStdField("feedback"), ":feedback")
                .set(queriesFactory.newStdField("status"), ":status")
                .inTable(Reclamation.class.getSimpleName().toLowerCase());
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":claimer"), entity.getClaimer() != null ? entity.getClaimer().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":type"), entity.getType());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":details"), entity.getDetails());
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":job"), entity.getJob() != null ? entity.getJob().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":comment"), entity.getComment() != null ? entity.getComment().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":staff"), entity.getStaff() != null ? entity.getStaff().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":feedback"), entity.getFeedback());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":status"), entity.getStatus());

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
    public Integer edit(Reclamation entity) throws DataBaseException {

        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery
                .set(queriesFactory.newStdField("type"), ":type")
                .set(queriesFactory.newStdField("details"), ":details")
                .set(queriesFactory.newStdField(Job.class.getSimpleName().toLowerCase()), ":job")
                .set(queriesFactory.newStdField("claimer"), ":claimer")
                .set(queriesFactory.newStdField(Comment.class.getSimpleName().toLowerCase()), ":comment")
                .set(queriesFactory.newStdField("staff"), ":staff")
                .set(queriesFactory.newStdField("feedback"), ":feedback")
                .set(queriesFactory.newStdField("status"), ":status")
                .inTable(Reclamation.class.getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":claimer"), entity.getClaimer() != null ? entity.getClaimer().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":type"), entity.getType());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":details"), entity.getDetails());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":job"), entity.getJob() != null ? entity.getJob().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":comment"), entity.getComment() != null ? entity.getComment().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":staff"), entity.getStaff() != null ? entity.getStaff().getId() : null, java.sql.Types.INTEGER);
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
        deleteQuery.from(Reclamation.class.getSimpleName().toLowerCase())
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
