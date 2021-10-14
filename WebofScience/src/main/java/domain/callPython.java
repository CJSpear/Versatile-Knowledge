package domain;

import java.io.*;
import java.util.Map;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import org.h2.util.json.JSONObject;  



public class callPython{
    


    
    
//    public String getSearch(String type, String val) {
//        System.out.println("Call Python - Made it");
//        return getSearch(type, val);
//    };
//    
    public String getSearch(String type, String val){
        
//      String types = String.join(",", type);
        String var = String.join("", val);
//        
//    System.out.println("VOID");
        System.out.println("search input is :" + type + " catagory is :" + val);
//    public void main(String type[]) throws Exception {
//         System.out.println("Blah");
//         String Val = val;
////         String TypeS = type;
//         System.out.println(type);

     try{
         
//  
 
         ProcessBuilder pb = new ProcessBuilder("python3","/home/caleb/Desktop/dddddd/WebOfScience/WebofScience/Python/Python_to_Database.py", type, var);
         Map<String, String> environment = pb.environment();
         environment.put("CLASSPATH", "h2-latest.jar");
         Process p = pb.start();
 
     
 
             BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
             String lines= " ";
             String BB = " ";
             
             while ((lines = in.readLine()) != null) {
                 System.out.println("output " + lines);
                 BB = lines;
              } 
//              Gson g = new Gson(); 
//              BB = g.toJson(BB);
             String[] Array = BB.split("");
             String[] Arr = BB.split(",");
             System.out.println(BB);
             return (BB + BB);
 
 
            }
      catch(Exception e){
         System.out.println(e);
      e.printStackTrace();
      }
      
    System.out.println("HERE");
    System.out.println(type);
    // System.in.read();
    return getSearch(type, val);
    }

    

    
}
