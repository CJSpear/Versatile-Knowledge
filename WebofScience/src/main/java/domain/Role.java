/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author boydb
 */
public class Role {
    private Integer RoleID=1;
    private String RoleName;

    public Integer getRoleID() {
        return RoleID;
    }

    public void setRoleID(Integer RoleID) {
        this.RoleID = RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }
    
    
    
}
