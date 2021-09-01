/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sarahaverill
 */
public class ArticleJdbcDAO implements ArticleDAO{
    
    public ArticleJdbcDAO() {
       }
   
    private String databaseURI = DbConnection.getDefaultConnectionUri();

   
    public ArticleJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
   
    

    public void addArticle(Article article) {
        
            String sql = "insert into Article (articleId, title, articleAbstract, file, keywords, author, verified, publsihed, citedCount, contributedBy, verifiedBy, timesFlagged) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                
                Connection dbCon = DbConnection.getConnection(databaseURI);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
        
            stmt.setInt(1, article.getArticleId());
            stmt.setString(2, article.getTitle());
            stmt.setString(3, article.getArticleAbstract());
            stmt.setString(4, article.getFile());
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
    
  
    public void deleteArticle(Article article) {
    
        String sql = "delete from article where articleId = ?";
 
        try (
            
         Connection dbCon = DbConnection.getConnection(databaseURI);
         PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            
            stmt.setInt(1, article.getArticleId());
            stmt.executeUpdate();
 
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }    
        
        
        
    }
    
  
    public void updateArticle(Article article) {
    
         String sql = "merge into Article (articleId, title, articleAbstract, file, keywords, author, verified, publsihed, citedCount, contributedBy, verifiedBy, timesFlagged) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                
                Connection dbCon = DbConnection.getConnection(databaseURI);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
        
            stmt.setInt(1, article.getArticleId());
            stmt.setString(2, article.getTitle());
            stmt.setString(3, article.getArticleAbstract());
            stmt.setString(4, article.getFile());
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
    }
    
 
    public void addContributor(User user) {
        
       String sql = "insert into Article (userId) values (?)";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the renter domain object into the SQL parameters
            stmt.setInt(1, user.getUserId());
           
            stmt.executeUpdate(); 

        } catch (SQLException ex) {  
            throw new DAOException(ex.getMessage(), ex);
        }    
        
    }

    public void flatArticle(Article article) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
