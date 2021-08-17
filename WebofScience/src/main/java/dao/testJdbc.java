/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.test;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Sayyed
 */
public class testJdbc implements testDAO{
    public Collection<test> getTests(){
        String sql = "select * from Users";
        
        try(
            Connection connect = sqliteDbConnection.connect();
            PreparedStatement stmt = connect.prepareStatement(sql)
                ){
            
            ResultSet rs = stmt.executeQuery();
            
            List<test> tests = new ArrayList<test>();
            while(rs.next()){
                String name = rs.getString("name");
                Integer number = rs.getInt("number");
                
                test t = new test();
                t.setName(name);
                t.setNumber(number);
                
                tests.add(t);
            }
            return tests;   
        }catch(SQLException e){
            throw new DAOException(e.getMessage(), e);
        }
    }
    public void testing(){
        String sql = "select * from Users";
        
        try(
            Connection connect = sqliteDbConnection.connect();
            PreparedStatement stmt = connect.prepareStatement(sql)
                ){
            
            ResultSet rs = stmt.executeQuery();
            
            List<test> tests = new ArrayList<test>();
            while(rs.next()){
                String name = rs.getString("name");
                Integer number = rs.getInt("number");
                
                test t = new test();
                t.setName(name);
                t.setNumber(number);
                
                tests.add(t);
            }
            System.out.println(tests); 
        }catch(SQLException e){
            throw new DAOException(e.getMessage(), e);
        }
    }
    public void main(String[] args){
        testJdbc te = new testJdbc();
        te.testing();
    }
}
