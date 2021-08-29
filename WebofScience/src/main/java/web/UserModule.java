/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author Sayyed
 */
import dao.userDAO;
import domain.User;
import java.time.LocalDate;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

public class UserModule extends Jooby {

    public UserModule(userDAO userDao) {

        post("/api/register", (req, rsp) -> {
            User user = req.body().to(User.class);
            
            // perform date conversion to avoid errors when storing in database
            LocalDate dob = LocalDate.parse(user.getDob().substring(0, 10));
            System.out.println(dob);
            user.setDob(dob.toString());
            
            userDao.addAccount(user);
            rsp.status(Status.CREATED);
        });
    }
}
