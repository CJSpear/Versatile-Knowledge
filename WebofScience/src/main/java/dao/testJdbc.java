/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Test;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Sayyed
 */
public class testJdbc implements testDAO{
        String uri = DbConnection.getDefaultConnectionUri();
	
	public testJdbc(){
	
	}
	
	public testJdbc(String uri){
		this.uri = uri;
	}
    
    public Collection<Test> getTests(){
        String sql = "select * from users";
        
        try(
            Connection connect = sqliteDbConnection.connect();
            PreparedStatement stmt = connect.prepareStatement(sql)
                ){
            
            ResultSet rs = stmt.executeQuery();
            
            List<Test> tests = new ArrayList<>();
            while(rs.next()){
                String name = rs.getString("name");
                Integer number = rs.getInt("number");
                
                Test t = new Test();
                t.setName(name);
                t.setNumber(number);
               
                
                tests.add(t);
            }
            return tests;   
        }catch(SQLException e){
            throw new DAOException(e.getMessage(), e);
        }
    }
}
