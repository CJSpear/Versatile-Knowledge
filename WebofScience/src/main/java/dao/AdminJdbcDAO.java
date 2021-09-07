/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import domain.Verifier;
import domain.Admin;
import domain.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import domain.Role;
/**
 *
 * @author boydb
 */
public class AdminJdbcDAO implements AdminDAO {
    private String url = DbConnection.getDefaultConnectionUri();
    
 
    public AdminJdbcDAO() {
    }
 
    private String uri = DbConnection.getDefaultConnectionUri();
    
    public AdminJdbcDAO(String uri) {
        this.url = uri;
    }
    
    public void addVerifier(Verifier verifier) {
        
    }
    
     
    public void deleteVerifier(Verifier user) {
        String sql = "delete from verifier where UserId = ?";
 
        try (
            
         Connection dbCon = DbConnection.getConnection(uri);
         PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            
            stmt.setInt(1, verifier.getUserId());
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }  
    
    }
    
     
    public void upgradeVerifier(Verifier user) {
    
    }
}
    

