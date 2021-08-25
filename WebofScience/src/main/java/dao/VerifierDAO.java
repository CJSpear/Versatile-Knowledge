/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;

/**
 *
 * @author boydb
 */
public interface VerifierDAO extends userDAO {
    public void deleteArticle(Article article);
    public void archiveArticle (Article article);
    public void verifyArticle(Article article);
    
}
