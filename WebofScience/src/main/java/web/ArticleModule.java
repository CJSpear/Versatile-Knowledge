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
import org.jooby.Upload;
import java.io.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import java.io.IOException;



/**
 *
 * @author Saverill
 */
public class ArticleModule extends Jooby {

    public ArticleModule(ArticleDAO articleDao) {

        //upload (POST) article object
        post("/api/articles", (req, rsp) -> {
            Article article = req.body().to(Article.class);
            System.out.println(article);
            articleDao.addArticle(article);
            rsp.status(Status.CREATED);
        });

        post("/api/articles/:id/file", (req, rsp) -> {
            Upload upload = req.file("myfile");
            System.out.println(upload.name());
            upload.close();
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
   
        get("/api/unverified", ()->articleDao.getUnverifiedArticles());
   //flag artcile
   
   
   //add contributor


   // Call Sentimental Analysis
   //NOT CANNOT WORK UNTILL THE FILE UPLOAD IS SOLVED< COMMENTED OUT FOR NOW
   /*
   public static void main(String a[]) throws Exception {
    //    System.out.println("Blah");
    try{
        //article_id goes here
        String article_id = " "

        // System.out.println("BEFORE");
        // Must call ABSOULTE PATHWAY
        ProcessBuilder pb = new ProcessBuilder("python3","/home/caleb/Desktop/University/WebOfScience/WebOfScience/WebofScience/Python/Sentimental_Analysis.py", article_id);
        Map<String, String> environment = pb.environment();
        environment.put("CLASSPATH", "h2-1.4.200.jar");
        Process p = pb.start();

     }
        */
     
                 
       
 }  
}
