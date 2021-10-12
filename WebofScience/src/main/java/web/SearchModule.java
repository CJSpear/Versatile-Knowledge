package web;


import dao.userDAO;
import domain.User;
import java.time.LocalDate;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;


public class SearchModule {

    get("/api/search/:type/:var", (req) -> {
        String id = req.param("id").value();
        return productDao.searchById(id);
      });
    
}


