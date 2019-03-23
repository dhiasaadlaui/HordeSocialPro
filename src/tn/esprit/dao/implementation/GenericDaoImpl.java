/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import tn.esprit.querybuilder.implementations.QueriesFactoryImpl;
import tn.esprit.querybuilder.interfaces.DeleteQuery;
import tn.esprit.querybuilder.interfaces.InsertQuery;
import tn.esprit.querybuilder.interfaces.QueriesFactory;
import tn.esprit.querybuilder.interfaces.SelectQuery;
import tn.esprit.querybuilder.interfaces.UpdateQuery;

/**
 *
 * @author Dhia
 */
public class GenericDaoImpl {

    /**
     *
     */
    protected QueriesFactory queriesFactory = new QueriesFactoryImpl();

    /**
     *
     */
    protected Statement statement = null;

    /**
     *
     */
    protected PreparedStatement preparedStatement = null;

    /**
     *
     */
    protected ResultSet resultSet = null;

    /**
     *
     */
    protected Connexion cnx;

    /**
     *
     */
    protected SelectQuery selectQuery;

    /**
     *
     */
    protected UpdateQuery updateQuery;

    /**
     *
     */
    protected DeleteQuery deleteQuery;

    /**
     *
     */
    protected InsertQuery insertQuery;

    /**
     *
     */
    public GenericDaoImpl() {
        // TODO Auto-generated constructor stub

        cnx = Connexion.getInstance();

    }

}
