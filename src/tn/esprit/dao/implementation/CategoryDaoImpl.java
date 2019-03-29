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
import tn.esprit.entities.Category;
import tn.esprit.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Alai Zid
 */
public class CategoryDaoImpl extends GenericDaoImpl implements ICategoryDao {

    private UserDaoImpl userDao;

    public CategoryDaoImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public Category findByID(Integer id) throws ObjectNotFoundException {
        Category category = null;
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery.select(queriesFactory.newAllField())
                .from("category")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");

        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":id"), id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category = new Category.Builder()
                        .id(resultSet.getInt("id"))
                        .label(resultSet.getString("label"))
                        .description(resultSet.getString("description"))
                        .moderator(userDao.findByID(resultSet.getInt("moderator")))
                        .build();

            }

        } catch (SQLException | DataBaseException ex) {
            throw new ObjectNotFoundException(ex.getMessage());
        }

        return category;
    }

    @Override
    public List<Category> findAll() throws DataBaseException {
        List<Category> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Category.class.getSimpleName().toLowerCase());

        try {
            resultSet = cnx.getResult(selectQuery.getQueryString());
            while (resultSet.next()) {
                list.add(this.findByID(resultSet.getInt("id")));
            }

        } catch (SQLException | ObjectNotFoundException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;

    }

    @Override
    public Integer create(Category entity) throws DataBaseException {
        Integer rowsCreated = 0;
        insertQuery = queriesFactory.newInsertQuery();
        insertQuery.set(queriesFactory.newStdField("label"), ":label")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("moderator"), ":moderator")
                .inTable("category");
        try {
            preparedStatement = cnx.prepareStatementWithGeneratedKey(insertQuery.getQueryString());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":label"), entity.getLabel());
            preparedStatement.setString(insertQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setObject(insertQuery.getPlaceholderIndex(":moderator"), entity.getModerator() != null ? entity.getModerator().getId() : null, java.sql.Types.INTEGER);
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
    public Integer edit(Category entity) throws DataBaseException {
        Integer rowUpdated = 0;
        updateQuery = queriesFactory.newUpdateQuery();
        updateQuery.set(queriesFactory.newStdField("label"), ":label")
                .set(queriesFactory.newStdField("description"), ":description")
                .set(queriesFactory.newStdField("moderator"), ":moderator")
                .inTable("category")
                .where()
                .where(queriesFactory.newStdField("id"), ":id");
        try {
            preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":label"), entity.getLabel());
            preparedStatement.setString(updateQuery.getPlaceholderIndex(":description"), entity.getDescription());
            preparedStatement.setObject(updateQuery.getPlaceholderIndex(":moderator"), entity.getModerator() != null ? entity.getModerator().getId() : null, java.sql.Types.INTEGER);
            preparedStatement.setInt(updateQuery.getPlaceholderIndex(":id"), entity.getId());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return rowUpdated;
    }

    @Override
    public Integer delete(Category entity) throws DataBaseException {
        Integer rowDeleted = 1;
        deleteQuery = queriesFactory.newDeleteQuery();
        deleteQuery.from("category")
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
