/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.ArticleDAO;
import domain.Article;
import org.jooby.Jooby;
import org.jooby.Status;


/**
 *
 * @author Saverill
 */
public class ArticleModule extends Jooby{
  public ArticleModule(ArticleDAO articleDao) {
    
    //upload (POST) article 
     post("/api/articles", (req, rsp) -> {
            Article article = req.body().to(Article.class);
            articleDao.addArticle(article);
            rsp.status(Status.CREATED);
        });
            
   //Delete article 
    delete("/api/articles/:id", (req, rsp) -> {
            String id = req.param("id").value();
            //Article article = articleDao.deleteArticle(Article article);
            articleDao.deleteArticle(Integer.parseInt(id));
            rsp.status(Status.NO_CONTENT);
            
        });
    
   //edit article 
   put("/api/updateArt/:id", (req, rsp) -> {
            Article article = req.body().to(Article.class);
            articleDao.updateArticle(article);
            rsp.status(Status.CREATED);
        });
   
   //flag artcile
   
   
   //add contributor
     
                 
       
 }  
}

