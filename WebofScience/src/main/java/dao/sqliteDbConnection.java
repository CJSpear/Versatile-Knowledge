/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Sayyed
 */
import java.sql.*;
//import org.sqlite.SQLiteConnectionPoolDataSource;
//import org.sqlite.SQLitePooledConnection;



public class sqliteDbConnection {

    private static final String DEFAULT_URL = "jdbc:sqlite:test.db";
    
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception exception) {
            System.out.println("first exception " + exception);
        }
       // SQLiteConnectionPoolDataSource kl = new SQLiteConnectionPoolDataSource(); 
//        SQLiteConnectionPoolDataSource datasource = new SQLiteConnectionPoolDataSource();
//        datasource.setUrl(DEFAULT_URL);
        
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DEFAULT_URL);

            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        String sql = "SELECT * FROM Users";
//        try (
//            PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            String name;
//            int number;
//            
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()){
//                name = rs.getString("name");
//                number = rs.getInt("number");
//                
//                System.out.println(name + " " + number);
//            }
//            
//        } catch (Exception query) {
//            System.out.println("problem with query " + query);
//        }
    //return;
    return conn;
    }
}
