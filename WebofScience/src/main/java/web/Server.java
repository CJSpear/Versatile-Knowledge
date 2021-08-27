/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;
//import dao.testDAO;
//import dao.testJdbc;
//import web.auth.BasicHttpAuthenticator;

/**
 *
 * @author Sayyed
 */
public class Server extends Jooby {
    
    // use H2 database server (default)
   // CustomerDAO customerDao = new CustomerJdbcDAO();
   // SubscriptionDAO subscriptionDao = new SubscriptionJdbcDAO();
    //testDAO testdao = new testJdbc();
    
    // use embedded database file (SubTrack.mv.db in project root directory)
//    CustomerDAO customerDao = new CustomerJdbcDAO("jdbc:h2:./SubTrack");
//    SubscriptionDAO subscriptionDao = new SubscriptionJdbcDAO("jdbc:h2:./SubTrack");

    public Server() {
        port(8080);
        use(new Gzon());
        use(new AssetModule());
        //use(new testModule(testdao));
        /*List<String> noAuth = Arrays.asList("/api/register");
        use(new BasicHttpAuthenticator(customerDao, noAuth));
        use(new CustomerModule(customerDao));
        use(new SubscriptionModule(subscriptionDao));
*/
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");

        Server server = new Server();

        CompletableFuture.runAsync(() -> {
            server.start();
        });

        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });

        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }
}
