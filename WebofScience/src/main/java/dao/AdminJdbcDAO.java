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
    
 
    public AdminJdbcDAO() {
    }
 
    private String uri = DbConnection.getDefaultConnectionUri();
    
    public AdminJdbcDAO(String uri) {
        this.uri = uri;
    }
    
    @Override
    public void addVerifier(Verifier verifier) {
        String sql = "insert into User (username, fname, lname, email, password, dob, gender, institute, department, field_of_research, roleId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (select role_id from role where name='Verifier'))";
 
        try (
                Connection dbCon = DbConnection.getConnection(uri);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
 
            stmt.setString(1, verifier.getUsername());
            stmt.setString(2, verifier.getFirstName());
            stmt.setString(3, verifier.getLastName());
            stmt.setString(4, verifier.getEmail());
            stmt.setString(5, verifier.getPassword());
            stmt.setString(6, verifier.getDob().toString());
            stmt.setString(7, verifier.getGender());
            stmt.setString(8, verifier.getInstitution());
            stmt.setString(9, verifier.getDeptName());
            stmt.setString(10, verifier.getFieldResearch());
            
            //not needed since nested query will get it for us.
            //stmt.setInt(11, user.getRole().getRoleID());
 
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        
    }
    
    @Override
    public void deleteVerifier(Verifier user) {
        String sql = "delete from User where UserId = ?";
 
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
    public void upgradeVerifier(Verifier user) {
        String sql = "update from User set roleId = (select role_id from role where name='Admin'), where UserId = ?";
        
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
    

