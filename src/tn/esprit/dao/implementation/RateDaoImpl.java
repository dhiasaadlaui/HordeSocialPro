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
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.IRateDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Job;
import tn.esprit.entities.Rate;
import tn.esprit.entities.User;

/**
 *
 * @author Mehdi Sarray
 */
public class RateDaoImpl extends GenericDaoImpl implements IRateDao {

    IUserDao userDao;
    IJobDao jobDao;

    /**
     *
     */
    public RateDaoImpl() {
        this.userDao = new UserDaoImpl();
        this.jobDao = new JobDaoImpl();
    }

    /**
     *
     * @param job
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Rate> findByJob(Job job) throws DataBaseException {
        List<Rate> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from("rate")
                .where()
                .where(queriesFactory.newStdField("job"), ":job");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":job"), job.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Rate.Builder()
                        .candidate(userDao.findByID(resultSet.getInt("candidate")))
                        .job(jobDao.findByID(resultSet.getInt("job")))
                        .note(resultSet.getDouble("note"))
                        .feedback(resultSet.getString("feedback"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    /**
     *
     * @param candidate
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Rate> findByCandidate(User candidate) throws DataBaseException {

        List<Rate> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from("rate")
                .where()
                .where(queriesFactory.newStdField("candidate"), ":candidate");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":candidate"), candidate.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Rate.Builder()
                        .candidate(userDao.findByID(resultSet.getInt("candidate")))
                        .job(jobDao.findByID(resultSet.getInt("job")))
                        .note(resultSet.getDouble("note"))
                        .feedback(resultSet.getString("feedback"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Rate> findAll() throws DataBaseException {
        List<Rate> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from("rate");
        try {

            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new Rate.Builder()
                        .candidate(userDao.findByID(resultSet.getInt("candidate")))
                        .job(jobDao.findByID(resultSet.getInt("job")))
                        .note(resultSet.getDouble("note"))
                        .feedback(resultSet.getString("feedback"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public Integer create(Rate entity) throws DataBaseException {

        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("candidate"), ":candidate")
                .set(queriesFactory.newStdField("job"), ":job")
                .set(queriesFactory.newStdField("note"), ":note")
                .set(queriesFactory.newStdField("feedback"), ":feedback")
                .inTable("rate");

        try {
            preparedStatement = cnx.prepareStatement(insertQuery.getQueryString());
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":candidate"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":job"), entity.getJob() != null ? entity.getJob().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setDouble(insertQuery.getPlaceholderIndex(":note"), entity.getNote());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":feedback"), entity.getFeedback());
            rowsCreated = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowsCreated;

    }

    @Override
    public Integer edit(Rate entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery
                .set(queriesFactory.newStdField("note"), ":note")
                .set(queriesFactory.newStdField("feedback"), ":feedback")
                .inTable("rate")
                .where()
                .where(queriesFactory.newStdField("candidate"), ":candidate")
                .where(queriesFactory.newStdField("job"), ":job");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":candidate"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":job"), entity.getJob() != null ? entity.getJob().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setDouble(updateQuery.getPlaceholderIndex(":note"), entity.getNote());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":feedback"), entity.getFeedback());

            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowUpdated;
    }

    @Override
    public Integer delete(Rate entity) throws DataBaseException {

        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("rate")
                .where()
                .where(queriesFactory.newStdField("candidate"), ":candidate")
                .where(queriesFactory.newStdField("job"), ":job");
        try {
            preparedStatement = cnx.prepareStatement(deleteQuery.getQueryString());
            preparedStatement.setObject(deleteQuery.getPlaceholderIndex(":candidate"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setObject(deleteQuery.getPlaceholderIndex(":job"), entity.getJob() != null ? entity.getJob().getId() : null, java.sql.Types.INTEGER);

            rowDeleted = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowDeleted;

    }

}
