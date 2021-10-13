/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Article;
import domain.Verifier;
import java.util.Collection;

/**
 *
 * @author boydb
 */
public interface VerifierDAO  {
    public void deleteArticle(Integer id);
    public void archiveArticle (Article article);
    public void verifyArticle(Article article);
    public Collection<Verifier> getVerifiers();
}
