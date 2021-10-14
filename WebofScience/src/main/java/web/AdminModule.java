package web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.AdminDAO;
import domain.User;
import domain.Verifier;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author ryanl
 */
public class AdminModule extends Jooby {

    public AdminModule(AdminDAO adminDao) {

        //delete verifier
        put("/api/demoteVerifier/:id", (req, rsp) -> {
            Integer id = Integer.valueOf(req.param("id").value());
            User user = req.body().to(User.class);
            adminDao.demoteVerifier(user);

            rsp.status(Status.NO_CONTENT);

        });

        //update verifier
        put("/api/updateVerifier/:id", (req, rsp) -> {
            Integer id = Integer.valueOf(req.param("id").value());
            User user = req.body().to(User.class);
            adminDao.upgradeVerifier(user);

            rsp.status(Status.NO_CONTENT);
        });

    }
}
