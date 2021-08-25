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
public class UserJdbcDAO implements userDAO {
    private String url = DbConnection.getDefaultConnectionUri();
    

    public UserJdbcDAO() {
    }

    //this may be wrong - check
    public UserJdbcDAO(String uri) {
        this.url = uri;
    }
    @Override
    public void addAccount(User user) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void deleteAccount(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void addContributer(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void flagArticle(Article article) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void addArticle(Article article) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
