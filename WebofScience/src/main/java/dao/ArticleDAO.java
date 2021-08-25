/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;
import domain.User;

/**
 *
 * @author boydb
 */
public interface ArticleDAO {
    public void addArticle(Article article);
    
    public void deleteArticle(Article article);
      
    public void updateArticle(Article article);
        
    public void addContributer(User user);
    public void flagArticle(Article article);
        
    
    
}
