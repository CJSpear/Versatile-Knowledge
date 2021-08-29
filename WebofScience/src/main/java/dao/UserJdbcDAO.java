/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import domain.Role;
/**
 *
 * @author boydb
 */
public class UserJdbcDAO implements userDAO {
    private String url = DbConnection.getDefaultConnectionUri();
    
 
    public UserJdbcDAO() {
    }
 
    //this may be wrong - check
    public UserJdbcDAO(String uri) {
        this.url = uri;
    }
    @Override
    public void addAccount(User user) {
        String sql = "insert into User (username, firstName, email, password, dob, gender, institution, deptName, fieldResearch, roleId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, (select role_id from role where name='Contributor'))";
 
        try (
                Connection dbCon = DbConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
 
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setDate(5, (java.sql.Date) user.getDob());
            stmt.setString(6, user.getGender());
            stmt.setString(7, user.getInstitution());
            stmt.setString(8, user.getDeptName());
            stmt.setString(9, user.getFieldResearch());
            stmt.setInt(10, user.getRole.getRoleId());
 
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        
        
    }
    
    @Override
    public void deleteAccount(User user) {
        String sql = "delete from user where user_ID = ?";
 
        try (
                 Connection dbCon = DbConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, user.getUserId());
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
 
 
 
    
    
}
    

