/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        String sql = "insert into User (userId, username, firstName, email, password, dob, gender, institution, deptName, fieldResearch, role, roleId, deptId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection dbCon = DbConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setDate(6, (Date) user.getDob());
            stmt.setString(7, user.getGender());
            stmt.setString(8, user.getInstitution());
            stmt.setString(9, user.getDeptName());
            stmt.setString(10, user.getFieldResearch());
            stmt.setString (11, user.getRole());
            stmt.setInt(12, user.getRoleId());
            stmt.setInt(13, user.getDeptId());
            

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
