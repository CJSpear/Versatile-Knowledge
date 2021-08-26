/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;
import domain.Verifier;

/**
 *
 * @author boydb
 */
public interface AdminDAO {
    public void deleteArticle(Article article);
    public void archiveArticle (Article article);
    public void verifyArticle(Article article);
    public void addVerifier(Verifier verifier);
    public void deleteVerifier(Verifier user);
    public void upgradeVerifier(Verifier user);
    
    
}
