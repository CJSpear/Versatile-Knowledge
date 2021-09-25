/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
 
/**
 *
 * @author sarahaverill
 */
public class User {
    
    private Integer  userId;
    private String  username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dob = LocalDate.now().toString();
    private String gender;
    private String institution;
    private String deptName;
    private String fieldResearch;
    private Integer roleId;
    private Collection<Article> articles = new ArrayList<Article>();
    
    private Role role;

    public User() {
    }

    public User(Integer userId, String username, String password, String firstName, String lastName, String email,  String dob, String gender, String institution, String deptName, String fieldResearch, Integer roleId) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.institution = institution;
        this.deptName = deptName;
        this.fieldResearch = fieldResearch;
        this.roleId = role.getRoleID();
    }
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
 
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", institution=" + institution + ", deptName=" + deptName + ", fieldResearch=" + fieldResearch + ", role=" + role + ", roleId=" + roleId + ", articles=" + articles + '}';
    }
    
    
    
   
}

    
