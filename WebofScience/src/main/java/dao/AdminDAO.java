/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import domain.Verifier;
import java.util.Collection;

/**
 *
 * @author boydb
 */
public interface AdminDAO extends VerifierDAO {
    public void addVerifier(Verifier verifier);
    public void demoteVerifier(User user);
    public void upgradeVerifier(User user);
	 public Collection<User> getUsers();
	 public Collection<String> allRoles();
    
    
}
