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
public class AdminJdbcDAO extends VerifierJdbcDAO implements AdminDAO {
    
 
    public AdminJdbcDAO() {
    }
 
    private String uri = DbConnection.getDefaultConnectionUri();
    
    public AdminJdbcDAO(String uri) {
        this.uri = uri;
    }
    
    @Override
    public void demoteVerifier(User user) {
        String sql = "update user set roleid=(select role_id from role where name='Contributor') where user_id=?";
 
        try (
            
         Connection dbCon = DbConnection.getConnection(uri);
         PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            
            stmt.setInt(1, user.getUserId());
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }  
    
    }
    
    @Override
    public void upgradeVerifier(User user) {
        String sql = "update User set roleId = (select role_id from role where name='Verifier') where User_Id = ?";
        
        try (
            
         Connection dbCon = DbConnection.getConnection(uri);
         PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            
            stmt.setInt(1, user.getUserId());
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }  
    }
}
    

