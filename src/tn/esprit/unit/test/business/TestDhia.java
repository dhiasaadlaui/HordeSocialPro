/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.business;

import com.mysql.cj.protocol.Resultset;
import eu.hansolo.tilesfx.tools.Country;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.dao.implementation.Connexion;
import tn.esprit.entities.User;
import tn.esprit.querybuilder.implementations.QueriesFactoryImpl;
import tn.esprit.querybuilder.interfaces.QueriesFactory;
import tn.esprit.querybuilder.interfaces.SelectQuery;
import tn.esprit.querybuilder.interfaces.SelectQuery.JoinType;
import tn.esprit.services.exceptions.ConstraintViolationException;

import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class TestDhia {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    
        QueriesFactory f = new QueriesFactoryImpl();
        SelectQuery selectQuery = f.newSelectQuery();
        
        selectQuery = f.newSelectQuery();
	selectQuery.select(
	f.newQualifiedField("company", "recruiter"), 
	f.newQualifiedField("company", "name"), 
	f.newQualifiedField("company", "description"), 
	f.newQualifiedField("company", "adress"), 
	f.newQualifiedField("company", "domain"), 
	f.newQualifiedField("company", "image"), 
	f.newQualifiedField("company", "phone")
	)
	.from("company")
	.join("job", f.newQualifiedField("job", "company"), f.newQualifiedField("company", "recruiter"), JoinType.INNER)
	.where()
	.where(f.newStdField("recruiter"), ":recruiter");
        System.out.println(selectQuery.getQueryString());
        try {
            PreparedStatement ps = Connexion.getInstance().prepareStatement(selectQuery.getQueryString());
            ps.setInt(selectQuery.getPlaceholderIndex(":recruiter"), 4);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            
            while (rs.next()){
                System.out.println(rs.getString("domain"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        

    }

}
