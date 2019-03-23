package tn.esprit.dao.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import tn.esprit.gui.login.LanguageToolBar;

/*
 * 
 */

/**
 *
 * @author Dhia
 */

public class Connexion {

    /**
     *
     */
    private String PROPERTIES_URL="src/resources/database/db.properties";

    /**
     *
     */
    private String DB_URL;

    /**
     *
     */
    private String DB_USER;

    /**
     *
     */
    private String DB_PASSWORD;

    /**
     *
     */
    private String DRIVER;

    /**
     *
     */
    private Connection cn;

    /**
     *
     */
    private static final Logger LOGGER = Logger.getLogger(Connexion.class.getName());

    /**
     *
     */
    private static Connexion instance = null;
	
    /**
     *
     * @return
     */
    public static Connexion getInstance() {
		if (instance == null) {
			synchronized (Connexion.class) {
				if (instance == null)
					instance = new Connexion();
			}

		}

		return instance;
	}

    /**
     *
     */
    private Connexion() {
		try {

			FileInputStream fis = new FileInputStream(PROPERTIES_URL);
			Properties p = new Properties();
			p.load(fis);
			DB_URL = (String) p.get("url");
			DB_USER = (String) p.get("user");
			DB_PASSWORD = (String) p.get("password");
			DRIVER = (String) p.get("driver");
			LOGGER.info("The class (" + LOGGER.getName() + ") attempting to connect database ..");

		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
                        
		}
	}

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection connect() throws SQLException{
		try {
		
                       Class.forName(DRIVER);
			cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		} catch (SQLException e) {
			LOGGER.warning("The class (" + LOGGER.getName() + ") failed to connected  database ..");
                        throw new SQLException(LanguageToolBar.BUNDLE.getString("dberror"));
                        
		} catch (ClassNotFoundException ex) {
                LOGGER.warning("Driver not found: "+DRIVER);
            }
		return cn;
	}

    /**
     *
     * @param query
     * execute given querie via a new statement and return a ResultSet
     * @return ReultSet
     * @throws SQLException
     */
    public ResultSet getResult(String query) throws  SQLException {

           
            try {
                return getInstance().connect().createStatement().executeQuery(query);
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
         
        
            
	}

    /**
     *
     * @param query
     * @return PreparedStatement from given query, 
     * @throws SQLException
     */
    public PreparedStatement prepareStatement(String query) throws SQLException {

		return getInstance().connect().prepareStatement(query);
	}

    /**
     *
     * @param query
     * @return PreparedStement from given query and return autogenerated key from the given query in a ResultSet
     * @throws SQLException
     */
    public PreparedStatement prepareStatementWithGeneratedKey(String query) throws SQLException {

		return getInstance().connect().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	}
    /**
     * close connection object at Singleton Class "Connexion"
     * @throws java.sql.SQLException
     */
    public void disconnect() throws SQLException {
		try {
			if (cn != null)
				cn.close();
		} catch (SQLException e) {
                    throw new SQLException("Unable to close connection");
		}
	}
}