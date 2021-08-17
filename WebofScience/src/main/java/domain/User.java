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
    private String roleId;
    private String deptId;

    public User() {
    }

    public User(Integer userId, String username, String firstName, String email, String password, Date dob, String gender, String institution, String deptName, String fieldResearch, String role, String roleId, String deptId) {
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}

    
