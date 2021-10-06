/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;
import domain.User;
import java.util.Collection;
import java.util.Date;

public interface ArticleDAO {
    
    
    public void addArticle(Article article);
    public void deleteArticle(Integer id);
    
    public void updateArticle(Article article);
    public void flagArticle(Article article);
    public void addContributor(User user);
    //public void loadFile (String path);
   
    Collection<Article> filterByAuthor(String author);
//    Collection<Article> filterByDate(Date date);
//    Collection<Article> filterByKeyword(String keywords);
//    Collection<Article> filterByDepartment(String deptName);
    //Collection<Article> filterByField(String fieldResearch);
 
    public Article getArticleById(Integer articleId);
    Collection<Article> getArticles();
}
