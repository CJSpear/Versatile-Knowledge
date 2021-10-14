/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import dao.VerifierDAO;
import domain.Article;

/**
 *
 * @author boydb
 */
public class VerifierModule extends Jooby{

    public VerifierModule(VerifierDAO verifierDAO){ 
        //verify an article
        put("/api/VerifyArticle/:id", (req, rsp) -> {
            String id = req.param("id").value();
            Article article = req.body().to(Article.class);
            verifierDAO.verifyArticle(article);
            rsp.status(org.jooby.Status.CREATED);
        });
 
        //delete article
        delete("/api/deleteArticle/:id", (req, rsp) -> {
            String id = req.param("id").value();
            verifierDAO.deleteArticle(Integer.parseInt(id));
            rsp.status(org.jooby.Status.NO_CONTENT);
 
        });
        

    
    } 
}

