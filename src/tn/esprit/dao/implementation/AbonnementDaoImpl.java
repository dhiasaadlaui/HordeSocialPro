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
import tn.esprit.dao.interfaces.IAbonnementDao;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.dao.interfaces.IUserDao;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Company;
import tn.esprit.entities.User;

/**
 *
 * @author Alai Zid
 */
public final class AbonnementDaoImpl extends GenericDaoImpl implements IAbonnementDao {

    private final ICompanyDao companyDao;
    private final IUserDao userDao;

    /**
     *
     */
    public AbonnementDaoImpl() {
        companyDao = new CompanyDaoImpl();
        userDao = new UserDaoImpl();
    }

    /**
     *
     * @param candidate
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Abonnement> findByCandidate(User candidate) throws DataBaseException {

        List<Abonnement> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Abonnement.class.getSimpleName().toLowerCase())
                .where()
                .where(queriesFactory.newStdField("candidate"), ":candidate");
        try {
            preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
            preparedStatement.setInt(selectQuery.getPlaceholderIndex(":candidate"), candidate.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Abonnement.Builder()
                        .candidate(userDao.findByID(resultSet.getInt("candidate")))
                        .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt(Company.class.getSimpleName().toLowerCase())).build()))
                        .dateAbonnement(resultSet.getDate("dateabonnement"))
                        .build());

            }

        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }

        return list;
    }

    /**
     *
     * @param company
     * @return
     * @throws DataBaseException
     */
    @Override
    public List<Abonnement> findByCompany(Company company) throws DataBaseException {

        List<Abonnement> list = new ArrayList<>();
        selectQuery = queriesFactory.newSelectQuery();
        selectQuery
                .select(queriesFactory.newAllField())
                .from(Abonnement.class.getSimpleName().toLowerCase())
                    .where()
                    .where(queriesFactory.newStdField(Company.class.getSimpleName().toLowerCase()), ":company");
            try {
                preparedStatement = cnx.prepareStatement(selectQuery.getQueryString());
                preparedStatement.setInt(selectQuery.getPlaceholderIndex(":company"), company.getRecruiter().getId());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    list.add(new Abonnement.Builder()
                            .candidate(userDao.findByID(resultSet.getInt("candidate")))
                            .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt(Company.class.getSimpleName().toLowerCase())).build()))
                            .dateAbonnement(resultSet.getDate("dateabonnement"))
                            .build());

                }

            } catch (SQLException ex) {
                throw new DataBaseException(ex.getMessage());
            }

            return list;

        }

        @Override
        public List<Abonnement> findAll() throws DataBaseException {
            List<Abonnement> list = new ArrayList<>();
            selectQuery = queriesFactory.newSelectQuery();
            selectQuery
                    .select(queriesFactory.newAllField())
                    .from(Abonnement.class.getSimpleName().toLowerCase());
            try {

                resultSet = cnx.getResult(selectQuery.getQueryString());
                while (resultSet.next()) {
                    list.add(new Abonnement.Builder()
                            .candidate(userDao.findByID(resultSet.getInt("candidate")))
                            .company(companyDao.findByRecruter(new User.Builder().id(resultSet.getInt(Company.class.getSimpleName().toLowerCase())).build()))
                            .dateAbonnement(resultSet.getDate("dateabonnement"))
                            .build());

                }

            } catch (SQLException ex) {
                throw new DataBaseException(ex.getMessage());
            }

            return list;
        }

        @Override
        public Integer create(Abonnement entity) throws DataBaseException {

            Integer rowsCreated = 0;
            insertQuery = queriesFactory.newInsertQuery();
            insertQuery.set(queriesFactory.newStdField("candidate"), ":candidate")
                    .set(queriesFactory.newStdField(Company.class.getSimpleName().toLowerCase()), ":company")
                    .set(queriesFactory.newStdField("dateabonnement"), ":dateabonnement")
                    .inTable(Abonnement.class.getSimpleName().toLowerCase());

            try {
                preparedStatement = cnx.prepareStatement(insertQuery.getQueryString());
                preparedStatement.setObject(insertQuery.getPlaceholderIndex(":candidate"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
                preparedStatement.setObject(insertQuery.getPlaceholderIndex(":company"), entity.getCompany() != null ? entity.getCompany().getRecruiter().getId() : null, java.sql.Types.INTEGER);
                preparedStatement.setDate(insertQuery.getPlaceholderIndex(":dateabonnement"), new java.sql.Date(entity.getDateAbonnement().getTime()));
                rowsCreated = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                throw new DataBaseException(ex.getMessage());
            }

            return rowsCreated;

        }

        @Override
      public Integer edit(Abonnement entity) throws DataBaseException {
            Integer rowUpdated = 0;
            updateQuery = queriesFactory.newUpdateQuery();
            updateQuery
                    .set(queriesFactory.newStdField("candidate"), ":candidate")
                    .set(queriesFactory.newStdField(Company.class.getSimpleName().toLowerCase()), ":company")
                    .set(queriesFactory.newStdField("dateabonnement"), ":dateabonnement")
                    .inTable(Abonnement.class.getSimpleName().toLowerCase())
                    .where()
                    .where(queriesFactory.newStdField("candidate"), ":candidateid")
                    .where(queriesFactory.newStdField(Company.class.getSimpleName().toLowerCase()), ":companyid");
            try {
                preparedStatement = cnx.prepareStatement(updateQuery.getQueryString());
                preparedStatement.setObject(updateQuery.getPlaceholderIndex(":candidate"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
                preparedStatement.setObject(updateQuery.getPlaceholderIndex(":company"), entity.getCompany() != null ? entity.getCompany().getRecruiter().getId() : null, java.sql.Types.INTEGER);
                preparedStatement.setDate(updateQuery.getPlaceholderIndex(":dateabonnement"), new java.sql.Date(entity.getDateAbonnement().getTime()));
                preparedStatement.setObject(updateQuery.getPlaceholderIndex(":candidateid"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
                preparedStatement.setObject(updateQuery.getPlaceholderIndex(":companyid"), entity.getCompany() != null ? entity.getCompany().getRecruiter().getId() : null, java.sql.Types.INTEGER);

                rowUpdated = preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new DataBaseException(ex.getMessage());
            }

            return rowUpdated;
        }

        @Override
        public Integer delete(Abonnement entity) throws DataBaseException {

            Integer rowDeleted = 1;
            deleteQuery = queriesFactory.newDeleteQuery();
            deleteQuery.from(Abonnement.class.getSimpleName().toLowerCase())
                    .where()
                    .where(queriesFactory.newStdField("candidate"), ":candidateid")
                    .where(queriesFactory.newStdField(Company.class.getSimpleName().toLowerCase()), ":companyid");

            try {
                preparedStatement = cnx.prepareStatement(deleteQuery.getQueryString());
                preparedStatement.setObject(deleteQuery.getPlaceholderIndex(":candidateid"), entity.getCandidate() != null ? entity.getCandidate().getId() : null, java.sql.Types.INTEGER);
                preparedStatement.setObject(deleteQuery.getPlaceholderIndex(":companyid"), entity.getCompany() != null ? entity.getCompany().getRecruiter().getId() : null, java.sql.Types.INTEGER);

                rowDeleted = preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new DataBaseException(ex.getMessage());
            }

            return rowDeleted;
    }

}
