/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.util.*;

/**
 *
 * @author boydb
 */
public interface userDAO {
    public void addAccount(User user);
    public void deleteAccount(User user);
    public User signin(String username, String password);
	 public Collection<User> getUsers();
	 public Collection<String> allRoles();
}
