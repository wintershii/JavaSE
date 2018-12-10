package http.server;

/**
 *  抽象为一个父类
 */
public abstract class Servlet {
    public void service(Request req,Response response) throws Exception {
            this.doGet(req,response);
            this.doPost(req,response);
    }

    public abstract void doGet(Request req,Response response) throws Exception;
    public abstract void doPost(Request req,Response response) throws Exception;

}
