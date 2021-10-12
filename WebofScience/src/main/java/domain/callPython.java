
import java.io.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import java.io.IOException;


public class callPython{
      

    public static void main(String a[]) throws Exception {
    //    System.out.println("Blah");
    try{

        String TypeS = "title";
        String Val = "test";

        // System.out.println("BEFORE");
        ProcessBuilder pb = new ProcessBuilder("python3","/home/caleb/Desktop/University/WebOfScience/WebOfScience/WebofScience/Python/Python_to_Database.py", TypeS, Val);
        Map<String, String> environment = pb.environment();
        environment.put("CLASSPATH", "h2-latest.jar");
        Process p = pb.start();

    
            // System.out.println("DONE");

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String lines=null;
            
            while ((lines = in.readLine()) != null) {
                System.out.println("output " + lines);
                
             } 



    }
    catch(Exception e){
        System.out.println(e);
        e.printStackTrace();
    }


   //System.in.read();
}
    
}
