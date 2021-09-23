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
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

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
        String sql = "insert into User (username, fname, lname, email, password, dob, gender, institute, department, field_of_research, roleId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (select role_id from role where name='Contributor'))";

        try (
                 Connection dbCon = DbConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

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

    @Override
    public User signin(String username, String password) {
        String sql = "select * from user u, role r where username=? and password=? and u.roleid = r.role_id";
        try (
                 Connection con = DbConnection.getConnection(url);  PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt("User_Id");
                String user_name = rs.getString("Username");
                String pass_word = rs.getString("Password");
                String firstname = rs.getString("Fname");
                String lastname = rs.getString("Lname");
                String Email = rs.getString("Email");
                Date d = rs.getDate("DOB");
                LocalDate dob = d.toLocalDate();
                String gender = rs.getString("Gender");
                String department = rs.getString("Department");
                String institute = rs.getString("Institute");
                String fos = rs.getString("Field_Of_Research");
                Integer roleid = rs.getInt("RoleId");

                Role role = new Role();
                role.setRoleID(rs.getInt("Role_Id"));
                role.setRoleName(rs.getString("Name"));

                User user = new User();
                user.setUserId(id);
                user.setUsername(user_name);
                user.setPassword(pass_word);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setEmail(Email);
                user.setDob(dob.toString());
					 user.setGender(gender);
                user.setInstitution(institute);
                user.setDeptName(department);
                user.setFieldResearch(fos);
                user.setRoleId(roleid);
                user.setRole(role);
               
              // System.out.println(id + " " + user_name + " " + firstname + " " + lastname + " " + roleid + " " + user.getRole().getRoleName());
                if(pass_word.equals(password)){
                    return user;
                }else{
                    return null;
                }

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }
	 
	 @Override
	 public Collection<User> getUsers(){
		 String sql = "select * from user where roleid = (select role_id from role where name='Contributor'";
		 
		 try(
			Connection con = DbConnection.getConnection(url);
			 PreparedStatement stmt = con.prepareStatement(sql);
			 ){
			 ResultSet rs = stmt.executeQuery();
			 
			 List<User> users = new ArrayList<>();
			 while(rs.next()){
				 Integer id = rs.getInt("User_Id");
                String user_name = rs.getString("Username");
                String pass_word = rs.getString("Password");
                String firstname = rs.getString("Fname");
                String lastname = rs.getString("Lname");
                String Email = rs.getString("Email");
                Date d = rs.getDate("DOB");
                LocalDate dob = d.toLocalDate();
                String gender = rs.getString("Gender");
                String department = rs.getString("Department");
                String institute = rs.getString("Institute");
                String fos = rs.getString("Field_Of_Research");
                Integer roleid = rs.getInt("RoleId");

                Role role = new Role();
                role.setRoleID(rs.getInt("Role_Id"));
                role.setRoleName(rs.getString("Name"));

                User user = new User();
                user.setUserId(id);
                user.setUsername(user_name);
                user.setPassword(pass_word);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setEmail(Email);
                user.setDob(dob.toString());
					 user.setGender(gender);
                user.setInstitution(institute);
                user.setDeptName(department);
                user.setFieldResearch(fos);
                user.setRoleId(roleid);
                user.setRole(role);
					 
					 users.add(user);
			 }
			 return users;
		 }catch(SQLException e){
			 throw new DAOException(e.getMessage(), e);
		 }
	 }
	 
	 @Override
	 public Collection<String> allRoles(){
		 String sql = "select * from roles where not (name = 'Contributor'";
		 
		 try(
				Connection con = DbConnection.getConnection(url);
				PreparedStatement stmt = con.prepareStatement(sql);
			 ){
			 ResultSet rs = stmt.executeQuery();
			 
			 List<String> roles = new ArrayList<>();
			 while(rs.next()){
				 String name = rs.getString("name");
				 
				 roles.add(name);
			 }
			 return roles;
		 }catch(SQLException e){
			 throw new DAOException(e.getMessage(), e);
		 }
	 }
    /*
    public Boolean validateCredentials(String username, String password) {
        String sql = "select password from user where username=?";

        try (
                // get connection to database
                 Connection connection = DbConnection.getConnection(url); // create the statement
                  PreparedStatement stmt = connection.prepareStatement(sql);) {
            // set the parameter
            stmt.setString(1, username);
            stmt.setString(2, password);

            // execute the query
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String pass = rs.getString("password");

                return pass.equals(password);
            } else {
                return false;
            }
        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);

        }

    }*/

}
