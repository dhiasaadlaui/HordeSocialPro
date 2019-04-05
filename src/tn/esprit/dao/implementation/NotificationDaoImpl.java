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
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.dao.interfaces.INotificationDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.Notification;
import tn.esprit.entities.User;

/**
 *
 * @author Mehdi Sarray
 */
public class NotificationDaoImpl extends GenericDaoImpl implements INotificationDao {

    private final IJobDao jobDao;
    private final IUserDao userDao;
    private final ICompanyDao companyDao;

    public NotificationDaoImpl() {
        jobDao = new JobDaoImpl();
        userDao = new UserDaoImpl();
        companyDao = new CompanyDaoImpl();

    }

    @Override
    public List<Notification> findAll() throws DataBaseException {
        List<Notification> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Notification.class.getSimpleName().toLowerCase());
        try {

            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new Notification.Builder().id(resultSet.getInt("id"))
                        .is_read(resultSet.getInt("is_read"))
                        .date(resultSet.getTimestamp("date_notif").toLocalDateTime())
                        .job(jobDao.findByID(resultSet.getInt(Job.class.getSimpleName().toLowerCase())))
                        .company(companyDao.findByRecruter(userDao.findByID(resultSet.getInt("recruiter"))))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public Integer create(Notification entity) throws DataBaseException {

        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("recruiter"), ":recruiter")
                .set(queriesFactory.newStdField("is_read"), ":is_read")
                .set(queriesFactory.newStdField("date_notif"), ":date_notif")
                .set(queriesFactory.newStdField(Job.class.getSimpleName().toLowerCase()), ":job")
                .inTable(Notification.class.getSimpleName().toLowerCase());
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":recruiter"), entity.getCompany().getRecruiter().getId());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":is_read"), entity.getIs_read());
            preparedStatement.setTimestamp(insertQuery.getPlaceholderIndex(":date_notif"), java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":job"), entity.getJob().getId());
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
    public Integer edit(Notification entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("is_read"), ":is_read") // only turning this from 1 to 0
                .inTable(Notification.class.getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":is_read"), entity.getIs_read());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public Integer delete(Notification entity) throws DataBaseException {
        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from(Notification.class.getSimpleName().toLowerCase())
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
    public void craftNotification(Company entity, Comment comEntity) throws DataBaseException {
        Notification notif = new Notification.Builder().company(entity).is_read(0).job(comEntity.getJob()).build();
        create(notif);
    }

    @Override
    public List<Notification> getNotificationByUser(Company entity) throws DataBaseException {

        List<Notification> notif = new ArrayList<>();

        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from(Notification.class.getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("recruiter"), ":recruiter");
        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":recruiter"), entity.getRecruiter().getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Notification nf = new Notification.Builder().id(resultSet.getInt("id"))
                        .company(new Company.Builder().recruiter(new User.Builder().id(resultSet.getInt("recruiter")).build()).build())
                        .date(resultSet.getTimestamp("date_notif").toLocalDateTime())
                        .is_read(resultSet.getInt("is_read"))
                        .build();
                notif.add(nf);
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return notif;
    }

}
