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
public interface userDAO {
    public void addArticle(Article article);
    public void addContributer(User user);
    public void addAccount(User user);
    public void flagArticle(Article article);
    public void deleteAccount(User user);
}