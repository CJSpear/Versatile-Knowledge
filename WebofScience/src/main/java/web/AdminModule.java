package web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.AdminDAO;
import dao.AdminJdbcDAO;
import domain.Article;
import domain.Verifier;
import java.io.ObjectInputFilter.Status;
import org.jooby.Jooby;

/**
 *
 * @author ryanl
 */
public class AdminModule extends Jooby {

    public AdminModule(AdminDAO adminDao) {

        //add verifier
        post("/api/user", (req, rsp) -> {
            Verifier verifier = req.body().to(Verifier.class);
            adminDao.addVerifier(verifier);
            rsp.status(org.jooby.Status.CREATED);
        });

        //delete verifier
        delete("/api/user/:id", (req, rsp) -> {
            Verifier verifier = req.body().to(Verifier.class);
            adminDao.deleteVerifier(verifier);
            rsp.status(org.jooby.Status.NO_CONTENT);

        });

        //update verifier
        put("/api/updateVerifier/:id", (req, rsp) -> {
            Verifier verifier = req.body().to(Verifier.class);
            adminDao.upgradeVerifier(verifier);
            rsp.status(org.jooby.Status.CREATED);
        });

    }
}
