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
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.User;
import tn.esprit.entities.UserAccountStatus;
import tn.esprit.entities.UserRole;

/**
 *
 * @author Dhia
 */
public class UserDaoImpl extends GenericDaoImpl implements IUserDao {

    /**
     *
     * @param id
     * @return
     * @throws DataBaseException
     */
    @Override
    public User findByID(Integer id) throws DataBaseException {
        User user = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from("user")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":id"), id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User.Builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("firstname"))
                        .lastName(resultSet.getString("lastname"))
                        .userName(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .email(resultSet.getString("email"))
                        .adress(resultSet.getString("adress"))
                        .authorization(Enum.valueOf(UserRole.class, resultSet.getString("authorization")))
                        .photo(resultSet.getString("photo"))
                        .accountStatus(Enum.valueOf(UserAccountStatus.class, resultSet.getString("accountstatus")))
                        .activationCode(resultSet.getString("activationcode"))
                        .photo(resultSet.getString("activationcode"))
                        .build();

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return user;
    }

    /**
     *
     * @return @throws DataBaseException
     */
    @Override
    public List<User> findAll() throws DataBaseException {
        List<User> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(User.class.getSimpleName().toLowerCase());
        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(new User.Builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("firstname"))
                        .lastName(resultSet.getString("lastname"))
                        .userName(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .email(resultSet.getString("email"))
                        .adress(resultSet.getString("adress"))
                        .authorization(Enum.valueOf(UserRole.class, resultSet.getString("authorization")))
                        .photo(resultSet.getString("photo"))
                        .accountStatus(Enum.valueOf(UserAccountStatus.class, resultSet.getString("accountstatus")))
                        .activationCode(resultSet.getString("activationcode"))
                        .photo(resultSet.getString("activationcode"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer create(User entity) throws DataBaseException {

        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("firstname"), ":firstname")
                .set(queriesFactory.newStdField("lastname"), ":lastname")
                .set(queriesFactory.newStdField("username"), ":username")
                .set(queriesFactory.newStdField("password"), ":password")
                .set(queriesFactory.newStdField("email"), ":email")
                .set(queriesFactory.newStdField("adress"), ":adress")
                .set(queriesFactory.newStdField("authorization"), ":authorization")
                .set(queriesFactory.newStdField("accountstatus"), ":accountstatus")
                .set(queriesFactory.newStdField("activationcode"), ":activationcode")
                .set(queriesFactory.newStdField("photo"), ":photo")
                .inTable("user");
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":firstname"), entity.getFirstName());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":lastname"), entity.getLastName());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":username"), entity.getUserName());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":password"), entity.getPassword());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":email"), entity.getEmail());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":adress"), entity.getAdress());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":authorization"), entity.getAuthorization());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":photo"), entity.getPhoto());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":accountstatus"), entity.getAccountStatus());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":activationcode"), entity.getActivationCode());
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

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer edit(User entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("firstname"), ":firstname")
                .set(queriesFactory.newStdField("lastname"), ":lastname")
                .set(queriesFactory.newStdField("username"), ":username")
                .set(queriesFactory.newStdField("password"), ":password")
                .set(queriesFactory.newStdField("email"), ":email")
                .set(queriesFactory.newStdField("adress"), ":adress")
                .set(queriesFactory.newStdField("authorization"), ":authorization")
                .set(queriesFactory.newStdField("photo"), ":photo")
                .set(queriesFactory.newStdField("accountstatus"), ":accountstatus")
                .set(queriesFactory.newStdField("activationcode"), ":activationcode")
                .inTable("user")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":firstname"), entity.getFirstName());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":lastname"), entity.getLastName());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":username"), entity.getUserName());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":password"), entity.getPassword());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":email"), entity.getEmail());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":adress"), entity.getAdress());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":authorization"), entity.getAuthorization());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":photo"), entity.getPhoto());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":accountstatus"), entity.getAccountStatus());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":activationcode"), entity.getActivationCode());
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return rowUpdated;
    }

    /**
     *
     * @param entity
     * @return
     * @throws DataBaseException
     */
    @Override
    public Integer delete(User entity) throws DataBaseException {
        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("user")
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
