/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;
import domain.User;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sarahaverill
 */
public class ArticleJdbcDAO implements ArticleDAO {

    public ArticleJdbcDAO() {
    }

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    public ArticleJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    public void addArticle(Article article) {

String sql = "insert into Article (file, title, abstract, keyword, author, verified, published, flags, cited_Count, contributed_By, verified_By) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                 Connection dbCon = DbConnection.getConnection(databaseURI);  PreparedStatement stmt = dbCon.prepareStatement(sql);
                                
                ) {

//            stmt.setInt(1, article.getArticleId());
            stmt.setBytes(1, article.getData());
            stmt.setString(2, article.getTitle());
            stmt.setString(3, article.getArticleAbstract());
            stmt.setString(4, article.getKeywords());
            stmt.setString(5, article.getAuthor());
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.setInt(8, 0);
            stmt.setInt(9, 0);
            stmt.setString(11, article.getVerifiedBy());
            stmt.setString(10, article.getContributedBy());

            stmt.executeUpdate();
            
           System.out.println(article.getTitle());
           String title = article.getTitle();
           String articleab = article.getArticleAbstract();
           
           try{
                   
                        ProcessBuilder pb = new ProcessBuilder("python","C:\\WebOfScience\\WebofScience\\Python\\Sentimental_Analysis",title, articleab);
                        Map<String, String> environment = pb.environment();
                        environment.put("CLASSPATH", "h2-latest.jar");
                        Process p = pb.start();        
                   
                       
                   }catch(Exception e){
                       System.out.println(e);
                       
                   }
           
           try{
               ProcessBuilder pb = new ProcessBuilder("python","C:\\WebOfScience\\WebofScience\\Python\\Sentimental_Analysis",title);
               Map<String, String> environment = pb.environment();
               environment.put("CLASSPATH", "h2-latest.jar");
               Process p = pb.start();
               
           }catch(Exception e){
                 System.out.println(e);
           }
           
       

        } catch (SQLException ex) 
            
            
       
        
        {

            throw new DAOException(ex.getMessage(), ex);
        }

        

        
    }

    public void deleteArticle(Integer id) {

        String sql = "delete from article where articleId = ?";

        try (
                 Connection dbCon = DbConnection.getConnection(databaseURI);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    public void updateArticle(Article article) {

        String sql = "merge into Article (articleId, title, abstract, file, keyword, author, verified, publsihed, citedCount, contributedBy, verifiedBy, flags) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                 Connection dbCon = DbConnection.getConnection(databaseURI);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, article.getArticleId());
            stmt.setString(2, article.getTitle());
            stmt.setString(3, article.getArticleAbstract());
            stmt.setBytes(4, article.getData());
            stmt.setString(5, article.getKeywords());
            stmt.setString(6, article.getAuthor());
            stmt.setBoolean(7, article.getVerified());
            stmt.setBoolean(8, article.getPublsihed());
            stmt.setInt(9, article.getCitedCount());
            stmt.setString(10, article.getContributedBy());
            stmt.setString(11, article.getVerifiedBy());
            stmt.setInt(12, article.getTimesFlagged());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            throw new DAOException(ex.getMessage(), ex);
        }

    }

    public void flagArticle(Article article) {
        String sql = "merge into Article (timesFlagged) values (?)";

        try (
                // get connection to database
                 Connection dbCon = DbConnection.getConnection(databaseURI); // create the statement
                  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, article.getTimesFlagged());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    public void addContributor(User user) {

        String sql = "insert into Article (userId) values (?)";

        try (
                // get connection to database
                 Connection dbCon = DbConnection.getConnection(databaseURI); // create the statement
                  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, user.getUserId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    public Collection<Article> filterByAuthor(String auth) {
        String sql = "Select * from Article where lower(author) like concat(‘%’, ?, ‘%’)";
        try (
                 Connection dbCon = DbConnection.getConnection(databaseURI);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setString(1, auth.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            List<Article> articles = new ArrayList<Article>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                Integer articleId = rs.getInt("Article_ID");
                String title = rs.getString("Title");
                String articleAbstract = rs.getString("Abstract");
                byte[] data = rs.getBytes("File");
                String keywords = rs.getString("Keyword");
                String author = rs.getString("Author");
                Boolean verified = rs.getBoolean("Verified");
                Boolean published = rs.getBoolean("Published");
                Integer citedCount = rs.getInt("Cited_Count");
                String contributedBy = rs.getString("Contribued_By");
                String verifiedBy = rs.getString("Verified_By");
                Integer timesFlagged = rs.getInt("Flags");
                Date date = rs.getDate("Date");

                Article s = new Article(articleId, title, articleAbstract, data, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);

                System.out.println(s);
                articles.add(s);

            }
            return articles;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

//    public Collection<Article> filterByDate(Date d){
//     String sql = "Select * from Article where lower(date) like concat(‘%’, ?, ‘%’)";
//     
//        try (
//                Connection dbCon = DbConnection.getConnection(databaseURI);
//                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
//
//            stmt.setDate(1, (java.sql.Date) d);
//            ResultSet rs = stmt.executeQuery();
//            List<Article> articles = new ArrayList<Article>();
//
//            // iterate through the query results
//            while (rs.next()) {
//
//                // get the data out of the query
//                Integer articleId = rs.getInt("Article_ID");
//                String title = rs.getString("Title");
//                String articleAbstract = rs.getString("Abstract");
//                String filee = rs.getString("File");
//                String keywords = rs.getString("Keyword");
//                String author = rs.getString("Author");
//                Boolean verified = rs.getBoolean("Verified");
//                Boolean published = rs.getBoolean("Published");
//                Integer citedCount = rs.getInt("Cited_Count");
//                String contributedBy = rs.getString("Contribued_By");
//                String verifiedBy = rs.getString("Verified_By");
//                Integer timesFlagged = rs.getInt("Flags");
//                Date date = rs.getDate("Date");
//       
//                Article s = new Article(articleId, title, articleAbstract, filee, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);
//  
//                System.out.println(s);
//                articles.add(s);
//
//            }
//            return articles;
//
//        } catch (SQLException ex) {  // we are forced to catch SQLException
//            // don't let the SQLException leak from our DAO encapsulation
//            throw new RuntimeException(ex);
//        }      
//    }
//    
//    public Collection<Article> filterByKeyword(String key){
//      String sql = "Select * from Article where lower(keyword) like concat(‘%’, ?, ‘%’)";
//        try (
//                Connection dbCon = DbConnection.getConnection(databaseURI);
//                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
//
//            stmt.setString(1, key.toLowerCase());
//           
//            ResultSet rs = stmt.executeQuery();
//            List<Article> articles = new ArrayList<Article>();
//
//            // iterate through the query results
//            while (rs.next()) {
//
//                // get the data out of the query
//                Integer articleId = rs.getInt("Article_ID");
//                String title = rs.getString("Title");
//                String articleAbstract = rs.getString("Abstract");
//                String filee = rs.getString("File");
//                String keywords = rs.getString("Keyword");
//                String author = rs.getString("Author");
//                Boolean verified = rs.getBoolean("Verified");
//                Boolean published = rs.getBoolean("Published");
//                Integer citedCount = rs.getInt("Cited_Count");
//                String contributedBy = rs.getString("Contribued_By");
//                String verifiedBy = rs.getString("Verified_By");
//                Integer timesFlagged = rs.getInt("Flags");
//                Date date = rs.getDate("Date");
//       
//                Article s = new Article(articleId, title, articleAbstract, filee, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);
//  
//                System.out.println(s);
//                articles.add(s);
//
//            }
//            return articles;
//
//        } catch (SQLException ex) {  // we are forced to catch SQLException
//            // don't let the SQLException leak from our DAO encapsulation
//            throw new RuntimeException(ex);
//        }     
//    }
//    
//    public Collection<Article> filterByDepartment(String dept){
//    String sql = "Select * from Article where lower(department) like concat(‘%’, ?, ‘%’)";
//        try (
//                Connection dbCon = DbConnection.getConnection(databaseURI);
//                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
//
//            stmt.setString(1, dept.toLowerCase());
//            ResultSet rs = stmt.executeQuery();
//            List<Article> articles = new ArrayList<Article>();
//
//            // iterate through the query results
//            while (rs.next()) {
//
//                // get the data out of the query
//                Integer articleId = rs.getInt("Article_ID");
//                String title = rs.getString("Title");
//                String articleAbstract = rs.getString("Abstract");
//                String filee = rs.getString("File");
//                String keywords = rs.getString("Keyword");
//                String author = rs.getString("Author");
//                Boolean verified = rs.getBoolean("Verified");
//                Boolean published = rs.getBoolean("Published");
//                Integer citedCount = rs.getInt("Cited_Count");
//                String contributedBy = rs.getString("Contribued_By");
//                String verifiedBy = rs.getString("Verified_By");
//                Integer timesFlagged = rs.getInt("Flags");
//                Date date = rs.getDate("Date");
//       
//                Article s = new Article(articleId, title, articleAbstract, filee, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);
//  
//                System.out.println(s);
//                articles.add(s);
//
//            }
//            return articles;
//
//        } catch (SQLException ex) {  // we are forced to catch SQLException
//            // don't let the SQLException leak from our DAO encapsulation
//            throw new RuntimeException(ex);
//        }       
//    }
//    
//    public Collection<Article> filterByField(String field){
//    String sql = "Select * from Article where lower(field) like concat(‘%’, ?, ‘%’)";
//        try (
//                Connection dbCon = DbConnection.getConnection(databaseURI);
//                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
//
//            stmt.setString(1, field.toLowerCase());
//            ResultSet rs = stmt.executeQuery();
//            List<Article> articles = new ArrayList<Article>();
//
//            // iterate through the query results
//            while (rs.next()) {
//
//                // get the data out of the query
//                Integer articleId = rs.getInt("Article_ID");
//                String title = rs.getString("Title");
//                String articleAbstract = rs.getString("Abstract");
//                String filee = rs.getString("File");
//                String keywords = rs.getString("Keyword");
//                String author = rs.getString("Author");
//                Boolean verified = rs.getBoolean("Verified");
//                Boolean published = rs.getBoolean("Published");
//                Integer citedCount = rs.getInt("Cited_Count");
//                String contributedBy = rs.getString("Contribued_By");
//                String verifiedBy = rs.getString("Verified_By");
//                Integer timesFlagged = rs.getInt("Flags");
//                Date date = rs.getDate("Date");
//       
//                Article s = new Article(articleId, title, articleAbstract, filee, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);
//  
//                System.out.println(s);
//                articles.add(s);
//
//            }
//            return articles;
//
//        } catch (SQLException ex) {  // we are forced to catch SQLException
//            // don't let the SQLException leak from our DAO encapsulation
//            throw new RuntimeException(ex);
//        }      
//    }
    public Article getArticleById(Integer artId) {
        String sql = "select * from Article where articleId = ?";

        try (
                // get a connection to the database
                 Connection dbCon = DbConnection.getConnection(databaseURI); // create the statement
                  PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            //copy the data from the property domain object into the SQL parameters
            stmt.setInt(1, artId);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                // get the data out of the query
                Integer articleId = rs.getInt("Article_ID");
                String title = rs.getString("Title");
                String articleAbstract = rs.getString("Abstract");
                byte[] data = rs.getBytes("File");
                String keywords = rs.getString("Keyword");
                String author = rs.getString("Author");
                Boolean verified = rs.getBoolean("Verified");
                Boolean published = rs.getBoolean("Published");
                Integer citedCount = rs.getInt("Cited_Count");
                String contributedBy = rs.getString("Contribued_By");
                String verifiedBy = rs.getString("Verified_By");
                Integer timesFlagged = rs.getInt("Flags");
                Date date = rs.getDate("Date");

                // use the data to create a property object
                Article s = new Article(articleId, title, articleAbstract, data, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);

                return s;

            } else {
                return null;
            }
        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    public Collection<Article> getArticles() {
        String sql = "select * from article order by Article_ID";

        try (
                 Connection dbCon = DbConnection.getConnection(databaseURI);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            List<Article> articles = new ArrayList<Article>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                Integer articleId = rs.getInt("Article_ID");
                String title = rs.getString("Title");
                String articleAbstract = rs.getString("Abstract");
                byte[] data = rs.getBytes("File");
                String keywords = rs.getString("Keyword");
                String author = rs.getString("Author");
                Boolean verified = rs.getBoolean("Verified");
                Boolean published = rs.getBoolean("Published");
                Integer citedCount = rs.getInt("Cited_Count");
                String contributedBy = rs.getString("Contribued_By");
                String verifiedBy = rs.getString("Verified_By");
                Integer timesFlagged = rs.getInt("Flags");
                Date date = rs.getDate("Date");

                // use the data to create a article object
                Article s = new Article(articleId, title, articleAbstract, data, keywords, author, verified, published, citedCount, contributedBy, verifiedBy, timesFlagged, date);

                // and put it in the collection
                articles.add(s);
            }

            return articles;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Collection<Article> getUnverifiedArticles() {
        String sql = "select * from article a, (select user_id from user u) where a.contributed_by = user_id and verified = false";
        try (
                 Connection con = DbConnection.getConnection(databaseURI);  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
 
            List<Article> unverifiedList = new ArrayList<>();
            while (rs.next()) {
 
                Integer articleId = rs.getInt("Article_ID");
                String title = rs.getString("Title");
                String articleAbstract = rs.getString("Abstract");
                byte[] data = rs.getBytes("File");
                String keywords = rs.getString("Keyword");
                String author = rs.getString("Author");
                Boolean verified = rs.getBoolean("Verified");
                Boolean published = rs.getBoolean("Published");
                Integer citedCount = rs.getInt("Cited_Count");
                String contributedBy = rs.getString("Contributed_By");
                String verifiedBy = rs.getString("Verified_By");
                Integer timesFlagged = rs.getInt("Flags");
                
                Article art = new Article();
                art.setArticleId(articleId);
                art.setArticleAbstract(articleAbstract);
                art.setAuthor(author);
                art.setCitedCount(citedCount);
                art.setContributedBy(contributedBy);
                art.setData(data);
                art.setKeywords(keywords);
                art.setPublsihed(published);
                art.setTimesFlagged(timesFlagged);
                art.setTitle(title);
                art.setVerified(verified);
                art.setVerifiedBy(verifiedBy);
                
                unverifiedList.add(art);
            }
            return unverifiedList;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

}
