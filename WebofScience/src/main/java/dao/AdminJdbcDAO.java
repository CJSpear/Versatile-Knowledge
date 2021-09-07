/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import domain.Verifier;
import domain.Admin;
import domain.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import domain.Role;
/**
 *
 * @author boydb
 */
public class AdminJdbcDAO implements AdminDAO {
    private String url = DbConnection.getDefaultConnectionUri();
    
 
    public AdminJdbcDAO() {
    }
 
    //this may be wrong - check
    public AdminJdbcDAO(String uri) {
        this.url = uri;
    }
    
    public void addVerifier(Verifier verifier) {
        
    }
    
     
    public void deleteVerifier(Verifier user) {
    
    }
    
     
    public void upgradeVerifier(Verifier user) {
    
    }
}
    

