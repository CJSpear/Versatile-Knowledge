package dao;

import domain.User;
import domain.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import domain.Role;
import domain.Verifier;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VerifierJdbcDAO extends UserJdbcDAO implements VerifierDAO {
    private String url = DbConnection.getDefaultConnectionUri();

    public VerifierJdbcDAO() {
    }

    public VerifierJdbcDAO(String uri) {
        this.url = uri;
    }

	 
    @Override
    public void verifyArticle(Article article) {
String sql = "update article set verified = true where article_id = ?";
        try (
            Connection dbCon = DbConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setInt(1, article.getArticleId());
            
            

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void archiveArticle (Article article){



    }

    @Override
    public void deleteArticle (Integer id){
        String sql = "DELETE FROM ARTICLE WHERE ARTICLE_ID = ? ";

        try (
            
            Connection dbCon = DbConnection.getConnection(url);
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
               
               stmt.setInt(1, id);
               stmt.executeUpdate();
    
           } catch (SQLException ex) {
               throw new DAOException(ex.getMessage(), ex);
           }    
           

    }
    
     @Override
    public Collection<Verifier> getVerifiers() {
        String sql = "select * from user where roleid = (select role_id from role where name='Verifier')";

        try (
                 Connection con = DbConnection.getConnection(url);  PreparedStatement stmt = con.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            List<Verifier> verifiers = new ArrayList<Verifier>();
            while (rs.next()) {
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


                Verifier verifier = new Verifier();
                verifier.setUserId(id);
                verifier.setUsername(user_name);
               verifier.setPassword(pass_word);
                verifier.setFirstName(firstname);
                verifier.setLastName(lastname);
                verifier.setEmail(Email);
                verifier.setDob(dob.toString());
                verifier.setGender(gender);
                verifier.setDeptName(department);
                verifier.setFieldResearch(fos);
                verifier.setRoleId(roleid);
//             

                verifiers.add(verifier);
            }
            return verifiers;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

}

//    @Override
//    public void addAccount(User verifier) {
//        String sql = "insert into User (username, fname, lname, email, password, dob, gender, institute, department, field_of_research, roleId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (select role_id from role where name='Verifier'))";
//
//        try (
//                 Connection dbCon = DbConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
//
//            stmt.setString(1, verifier.getUsername());
//            stmt.setString(2, verifier.getFirstName());
//            stmt.setString(3, verifier.getLastName());
//            stmt.setString(4, verifier.getEmail());
//            stmt.setString(5, verifier.getPassword());
//            stmt.setString(6, verifier.getDob().toString());
//            stmt.setString(7, verifier.getGender());
//            stmt.setString(8, verifier.getInstitution());
//            stmt.setString(9, verifier.getDeptName());
//            stmt.setString(10, verifier.getFieldResearch());
//
//            //not needed since nested query will get it for us.
//            //stmt.setInt(11, user.getRole().getRoleID());
//            stmt.executeUpdate();
//
//        } catch (SQLException ex) {
//            throw new DAOException(ex.getMessage(), ex);
//        }
//
//    }
//
//    @Override
//    public void deleteAccount(User verifier) {
//        String sql = "delete from user where user_ID = ?";
//
//        try (
//                 Connection dbCon = DbConnection.getConnection(url);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
//            stmt.setInt(1, verifier.getUserId());
//            stmt.executeUpdate();
//
//        } catch (SQLException ex) {
//            throw new DAOException(ex.getMessage(), ex);
//        }
//    }
//
//    @Override
//    public User signin(String username, String password) {
//        String sql = "select * from user u, role r where username=? and password=? and u.roleid = r.role_id";
//        try (
//                 Connection con = DbConnection.getConnection(url);  PreparedStatement stmt = con.prepareStatement(sql);) {
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                Integer id = rs.getInt("User_Id");
//                String user_name = rs.getString("Username");
//                String pass_word = rs.getString("Password");
//                String firstname = rs.getString("Fname");
//                String lastname = rs.getString("Lname");
//                String Email = rs.getString("Email");
//                Date d = rs.getDate("DOB");
//                LocalDate dob = d.toLocalDate();
//                String gender = rs.getString("Gender");
//                String department = rs.getString("Department");
//                String institute = rs.getString("Institute");
//                String fos = rs.getString("Field_Of_Research");
//                Integer roleid = rs.getInt("RoleId");
//
//                Role role = new Role();
//                role.setRoleID(rs.getInt("Role_Id"));
//                role.setRoleName(rs.getString("Name"));
//
//                User verifier = new User();
//                verifier.setUserId(id);
//                verifier.setUsername(user_name);
//                verifier.setPassword(pass_word);
//                verifier.setFirstName(firstname);
//                verifier.setLastName(lastname);
//                verifier.setEmail(Email);
//                verifier.setDob(dob.toString());
//                verifier.setInstitution(institute);
//                verifier.setDeptName(department);
//                verifier.setFieldResearch(fos);
//                verifier.setRoleId(roleid);
//                verifier.setRole(role);
//
//                if(pass_word.equals(password)){
//                    return verifier;
//                }else{
//                    return null;
//                }
//
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            throw new DAOException(e.getMessage(), e);
//        }
//    }

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
    




