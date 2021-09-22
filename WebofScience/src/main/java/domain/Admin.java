/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author sarahaverill
 */
public class Admin extends Verifier {
 
    public Admin() {
    }

    
    public Admin(Integer userId, String username, String firstName, String lastName,String email, String password, String dob, 
            String gender, String institution, String deptName, String fieldResearch, Integer roleId) {
        super(userId, username, firstName, lastName, email, password, dob, gender, institution, deptName, fieldResearch, roleId);
    }
  
}
