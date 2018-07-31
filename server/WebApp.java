package http.server;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;
import java.util.Map;

public class WebApp {
    private static ServletContext context;
    static {
        try {
            //获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //获取解析器
            SAXParser sax = factory.newSAXParser();
            //指定xml+处理器
            WebHandler web = new WebHandler();

            sax.parse(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("http/server/web.xml"), web);

            context = new ServletContext();

            Map<String,String> servlet =  context.getServlet();

            //存 servlet-name 和 servlet-class
            for (Entity entity:web.getEntityList()){
                servlet.put(entity.getName(), entity.getClz());
            }

            //urlPattern  servlet-name
            Map<String,String> mapping = context.getMapping();
            for (Mapping mapp:web.getMappingList() ){
                List<String> urls = mapp.getUrlPattern();
                for (String url: urls){
                    mapping.put(url,mapp.getName());
                }
            }


        }catch(Exception e){

        }

    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if ((url == null) || url.trim().equals("")){
            return null;
        }
        //根据字符串(完整路径)创建对象
            String name = context.getServlet().get(context.getMapping().get(url));
            return (Servlet) Class.forName(name).newInstance();
    }
}
