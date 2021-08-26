/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
<<<<<<< HEAD
 
=======

>>>>>>> parent of fa69c3c (Updated Domain class)
/**
 *
 * @author sarahaverill
 */
public class User {
    
    private Integer  userId;
    private String  username;
    private String firstName;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String institution;
    private String deptName;
    private String fieldResearch;
    private String role;
    private Integer roleId;
    private Integer deptId;
    private Collection<Article> articles = new ArrayList<>();

    public User() {
    }

    public User(Integer userId, String username, String firstName, String email, String password, Date dob, String gender, String institution, String deptName, String fieldResearch, String role, Integer roleId, Integer deptId) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.institution = institution;
        this.deptName = deptName;
        this.fieldResearch = fieldResearch;
        this.role = role;
        this.roleId = roleId;
        this.deptId = deptId;
    }
<<<<<<< HEAD
    
 
=======

>>>>>>> parent of fa69c3c (Updated Domain class)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getFieldResearch() {
        return fieldResearch;
    }

    public void setFieldResearch(String fieldResearch) {
        this.fieldResearch = fieldResearch;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
 
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", email=" + email + ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", institution=" + institution + ", deptName=" + deptName + ", fieldResearch=" + fieldResearch + ", role=" + role + ", roleId=" + roleId + ", deptId=" + deptId + ", articles=" + articles + '}';
    }
    
    
    
   
}

    
