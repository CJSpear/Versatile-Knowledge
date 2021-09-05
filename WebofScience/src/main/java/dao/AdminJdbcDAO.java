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
import java.sql.Date;
import domain.Role;
/**
 *
 * @author boydb
 */
public class AdminJdbcDAO implements userDAO {
    private String url = DbConnection.getDefaultConnectionUri();
    
 
    public AdminJdbcDAO() {
    }
 
    //this may be wrong - check
    public AdminJdbcDAO(String uri) {
        this.url = uri;
    }
    @Override
    public void addAccount(User user) {
        String sql = "insert into User (username, fname, lname, email, password, dob, gender, institute, department, field_of_research, roleId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (select role_id from role where name='Contributor'))";
 
        try (
                Connection dbCon = DbConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
 
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getDob().toString());
            stmt.setString(7, user.getGender());
            stmt.setString(8, user.getInstitution());
            stmt.setString(9, user.getDeptName());
            stmt.setString(10, user.getFieldResearch());
            
            //not needed since nested query will get it for us.
            //stmt.setInt(11, user.getRole().getRoleID());
 
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
    

