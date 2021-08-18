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
public class Verifier extends User {

    public Verifier() {
    }

    public Verifier(Integer userId, String username, String firstName, String email, String password, Date dob, String gender, String institution, String deptName, String fieldResearch, String role, Integer roleId, Integer deptId) {
        super(userId, username, firstName, email, password, dob, gender, institution, deptName, fieldResearch, role, roleId, deptId);
    }
    
    public void archiveArticle(){    
    }
    
      public void deleteArticle(){    
    }
      
        public void verifyArticle(){    
    }    
    
}
