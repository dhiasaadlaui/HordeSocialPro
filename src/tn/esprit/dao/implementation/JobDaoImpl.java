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
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IJobDao;
import tn.esprit.entities.Category;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author habib
 */
public class JobDaoImpl extends GenericDaoImpl implements IJobDao {

    private ICompanyDao companyDao;
    private ICategoryDao categoryDao;

    @Override
    public Job findByID(Integer id) throws DataBaseException {
    
                Job job = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from("job")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":id"), id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                job = new Job.Builder()
                        .id(resultSet.getInt("id"))
                        .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt("company")).build()))
                        .title(resultSet.getString("title"))
                        .description(resultSet.getString("description"))
                        .category(categoryDao.findByID(resultSet.getInt("category")))
                        .location(resultSet.getString("location"))
                        .creationDate(resultSet.getDate("creationdate"))
                        .expireDate(resultSet.getDate("expiredate"))
                        .salary(resultSet.getDouble("salary"))
                        .status(Enum.valueOf(JobStatus.class, resultSet.getString("status")))
                        .build();

            }

        } catch (SQLException | ObjectNotFoundException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return job;
        
    }

    public JobDaoImpl() {
        companyDao = new CompanyDaoImpl();
        categoryDao = new CategoryDaoImpl();
    }

    @Override
    public List<Job> findByCompany(Company company) throws DataBaseException {

        List<Job> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from("job")
                .where()
                .where(queriesFactory.newStdField("company"), ":idcompany");
        ;
        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":idcompany"), company.getRecruiter().getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Job.Builder()
                        .id(resultSet.getInt("id"))
                        .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt("company")).build()))
                        .title(resultSet.getString("title"))
                        .description(resultSet.getString("description"))
                        .category(categoryDao.findByID(resultSet.getInt("category")))
                        .location(resultSet.getString("location"))
                        .creationDate(resultSet.getDate("creationdate"))
                        .expireDate(resultSet.getDate("expiredate"))
                        .salary(resultSet.getDouble("salary"))
                        .status(Enum.valueOf(JobStatus.class, resultSet.getString("status")))
                        .build()
                );

            }

        } catch (SQLException | ObjectNotFoundException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Job> findByCategory(Category category) throws DataBaseException {

        List<Job> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from("job")
                .where()
                .where(queriesFactory.newStdField("category"), ":idcategory");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":idcategory"), category.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Job.Builder()
                        .id(resultSet.getInt("id"))
                        .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt("company")).build()))
                        .title(resultSet.getString("title"))
                        .description(resultSet.getString("description"))
                        .category(categoryDao.findByID(resultSet.getInt("category")))
                        .location(resultSet.getString("location"))
                        .creationDate(resultSet.getDate("creationdate"))
                        .expireDate(resultSet.getDate("expiredate"))
                        .salary(resultSet.getDouble("salary"))
                        .status(Enum.valueOf(JobStatus.class, resultSet.getString("status")))
                        .build()
                );

            }

        } catch (SQLException | ObjectNotFoundException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Job> findAll() throws DataBaseException {
        List<Job> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from("job");
        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new Job.Builder()
                        .id(resultSet.getInt("id"))
                        .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt("company")).build()))
                        .title(resultSet.getString("title"))
                        .description(resultSet.getString("description"))
                        .category(categoryDao.findByID(resultSet.getInt("category")))
                        .location(resultSet.getString("location"))
                        .creationDate(resultSet.getDate("creationdate"))
                        .expireDate(resultSet.getDate("expiredate"))
                        .salary(resultSet.getDouble("salary"))
                        .status(Enum.valueOf(JobStatus.class, resultSet.getString("status")))
                        .build()
                );

            }

        } catch (SQLException | ObjectNotFoundException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    @Override
    public Integer create(Job entity) throws DataBaseException {
        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("company"), ":company")
                .set(queriesFactory.newStdField("title"), ":title")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("category"), ":category")
                .set(queriesFactory.newStdField("location"), ":location")
                .set(queriesFactory.newStdField("creationDate"), ":creationDate")
                .set(queriesFactory.newStdField("expireDate"), ":expireDate")
                .set(queriesFactory.newStdField("salary"), ":salary")
                .set(queriesFactory.newStdField("status"), ":status")
                .inTable("job");
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":company"), entity.getCompany().getRecruiter().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":title"), entity.getTitle());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setInt(insertQuery.getPlaceholderIndex(":category"), entity.getCategory().getId());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":location"), entity.getLocation());
            preparedStatement.setDate(insertQuery.getPlaceholderIndex(":creationDate"), new java.sql.Date(entity.getCreationDate().getTime()));
            preparedStatement.setDate(insertQuery.getPlaceholderIndex(":expireDate"), new java.sql.Date(entity.getExpireDate().getTime()));
            preparedStatement.setDouble(insertQuery.getPlaceholderIndex(":salary"), entity.getSalary());
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
    public Integer edit(Job entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("company"), ":company")
                .set(queriesFactory.newStdField("title"), ":title")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("category"), ":category")
                .set(queriesFactory.newStdField("location"), ":location")
                .set(queriesFactory.newStdField("creationDate"), ":creationDate")
                .set(queriesFactory.newStdField("expireDate"), ":expireDate")
                .set(queriesFactory.newStdField("salary"), ":salary")
                .set(queriesFactory.newStdField("status"), ":status")
                .inTable("job")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());

            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":company"), entity.getCompany().getRecruiter().getId());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":title"), entity.getTitle());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":category"), entity.getCategory().getId());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":location"), entity.getLocation());
            preparedStatement.setDate(updateQuery.getPlaceholderIndex(":creationDate"), new java.sql.Date(entity.getCreationDate().getTime()));
            preparedStatement.setDate(updateQuery.getPlaceholderIndex(":expireDate"), new java.sql.Date(entity.getExpireDate().getTime()));
            preparedStatement.setDouble(updateQuery.getPlaceholderIndex(":salary"), entity.getSalary());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":status"), entity.getStatus());

            rowUpdated = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } finally {
            updateQuery = queriesFactory.newUpdateQuery();
        }
        return rowUpdated;
    }

    @Override
    public Integer delete(Job entity) throws DataBaseException {
        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("job")
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
