package http.server;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ServletContext {
    //为每个servlet取个别名
    //login --> LoginServlet
   private Map<String,String> servlet;
   // url --> login

   // log --> login        /login --> login
   private Map<String,String> mapping;

   ServletContext(){
       servlet = new HashMap<>();
       mapping = new HashMap<>();
   }


    public Map<String, String> getServlet() {
        return servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

}
