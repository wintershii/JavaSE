package http.server;

import java.io.IOException;
import java.net.Socket;

public class Dispather implements Runnable{
    private Socket client;
    private Request req;
    private Response response;
    private int code = 200;

    public Dispather(Socket client) {
        this.client = client;
        try {
            req = new Request(client.getInputStream());
            response = new Response(client.getOutputStream());
        } catch (IOException e) {
            code = 500;
            return;
        }
    }

    @Override
    public void run() {
        Servlet serv = null;
        try {
            serv = WebApp.getServlet(req.getUrl());
            serv.service(req, response);
            if (serv == null){
                this.code = 404;    //找不到处理
            }
        } catch (Exception e) {
            this.code = 500;
        }
        response.pushToClient(code);    //推送到客户端

    }
}
