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
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Company;
import tn.esprit.entities.User;

/**
 *
 * @author mghozzi
 */
public class CompanyDaoImpl extends GenericDaoImpl implements ICompanyDao {

    private IUserDao userDao ;
    
    public CompanyDaoImpl ( ) {
        super() ;
        userDao = new UserDaoImpl() ;
    }
    @Override
    public Company findByRecruter(User recruiter) throws DataBaseException {
        Company company = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from("company")
                .where()
                .where(queriesFactory.newStdField("recruiter"), ":recruiter");
        
        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":recruiter"), recruiter.getId() );
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                company = new Company.Builder()
                        .recruiter(userDao.findByID(resultSet.getInt("recruiter")))
                        .name(resultSet.getString("name"))
                        .adress(resultSet.getString("adress"))
                        .domain(resultSet.getString("domain"))
                        .phone(resultSet.getString("phone"))
                        .description(resultSet.getString("description"))
                        .image(resultSet.getString("image"))
                    
                        .build();

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return company;
    }

    
    
    
    
    @Override
    public List<Company> findAll() throws DataBaseException {
        List<Company> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Company.class.getSimpleName().toLowerCase());
        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new Company.Builder()
                        .recruiter(userDao.findByID(resultSet.getInt("recruiter")))
                        .name(resultSet.getString("name"))
                        .adress(resultSet.getString("adress"))
                        .domain(resultSet.getString("domain"))
                        .phone(resultSet.getString("phone"))
                        .description(resultSet.getString("description"))
                        .image(resultSet.getString("image"))
                      
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }


    
    

    @Override
    public Integer create(Company entity) throws DataBaseException {
        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("name"), ":name")
                .set(queriesFactory.newStdField("recruiter"), ":recruiter")
                .set(queriesFactory.newStdField("adress"), ":adress")
                .set(queriesFactory.newStdField("domain"), ":domain")
                .set(queriesFactory.newStdField("phone"), ":phone")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("image"), ":image")
                .inTable(Company.class.getSimpleName().toLowerCase());
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

 
    @Override
    public Integer edit(Company entity) throws DataBaseException {

        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("name"), ":name")
                .set(queriesFactory.newStdField("recruiter"), ":recruiter")
                .set(queriesFactory.newStdField("adress"), ":adress")
                .set(queriesFactory.newStdField("domain"), ":domain")
                .set(queriesFactory.newStdField("phone"), ":phone")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("image"), ":image")
                .inTable(Company.class.getClass().getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("recruiter"), ":idrecruiter");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":name"), entity.getName());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":recruiter"), entity.getRecruiter().getId());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":adress"), entity.getAdress());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":domain"), entity.getDomain());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":phone"), entity.getPhone());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":image"), entity.getImage());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":idrecruiter"), entity.getRecruiter().getId());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return rowUpdated;
    }

    
    
    
    @Override
    public Integer delete(Company entity) throws DataBaseException {

        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("company")
                .where()
                .where(queriesFactory.newStdField("recruiter"), ":recruiter");
        try {
            preparedStatement = cnx.prepareStatement(deleteQuery.getQueryString());
            preparedStatement.setInt(deleteQuery.getPlaceholderIndex(":recruiter"), entity.getRecruiter().getId());
            rowDeleted = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowDeleted;
    }

}
