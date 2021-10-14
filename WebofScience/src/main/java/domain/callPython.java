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
    @SuppressWarnings("empty-statement")
    public Object getSearch(Object type, Object val){
        
//      String types = String.join(",", type);
        String types = String.valueOf(type);
        String var = String.valueOf(val);
        String nothing = " ";
        System.out.println(var);
        
        String BB = " Nothing";
        
        
        
//        System.out.println("search input is :" + type + " catagory is :" + val);
//    public void main(String type[]) throws Exception {
//         System.out.println("Blah");
//         String Val = val;
////         String TypeS = type;
//         System.out.println(type);

     try{
         
//  
//                 System.out.println(var);
         ProcessBuilder pb = new ProcessBuilder("python3","/home/caleb/Desktop/Bigfile/WebOfScience/WebofScience/Python/Python_to_Database.py", types, var);
         Map<String, String> environment = pb.environment();
         environment.put("CLASSPATH", "h2-latest.jar");
         Process p = pb.start();
 
     
 
             BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
             String lines= " ";
             
             while ((lines = in.readLine()) != null) {
                 System.out.println("output " + lines);
                 
                BB = lines;
                
              } 
//              Gson g = new Gson(); 
//              BB = g.toJson(BB);
//            obj = BB;
            Object[] obj = {BB};
              
            System.out.print(BB);
//             String[] Array = BB.split("");
//             String[] Arr = BB.split("");
//             System.out.println(BB);
//             System.out.println(Array);
//            System.out.println(Arrays.toString(Array));

             return obj;
            }
      catch(Exception e){
         System.out.println(e);
      e.printStackTrace();
      }
      System.out.println(BB);   
      
       Object[] send = {BB};
             System.out.println(send);   


    // System.in.read();
    return send;
    }

    

    
}
