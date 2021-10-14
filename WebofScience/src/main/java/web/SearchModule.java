package web;

import domain.callPython;
// import dao.pythonDAO;
import java.time.LocalDate;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;


public class SearchModule extends Jooby{

  public SearchModule(callPython callPython){
//    System.out.println("Made it to SearchModule");

    get("/api/search/:type/:val", (req) -> { 
      System.out.println("Made it to SearchModule");
      Object val = req.param("val").value();
      Object type = req.param("type").value();
      
      
//      String[] Array = type.split("");
      
      return callPython.getSearch(type, val);

      });
//    
//      System.out.println("Made it to SearchModule val");
//      get("/api/search/:val", (req) -> {
//       String val = req.param("val").value();
//       System.out.println(val);
//        return callPython.getVal(val);
//
//      });


//    System.out.println("Sent Data");

  }
}








