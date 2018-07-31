package http.server;

public class RegisterServlet extends Servlet{

    @Override
    public void doGet(Request req, Response response) throws Exception {

    }

    @Override
    public void doPost(Request req, Response response) throws Exception {
        response.println("<html><head><title> 返回注册</title>");
        response.println("</head><body>");
        response.println("你的用户名为：" + req.getParameter("uname"));
        response.println("</body></html>");
    }
}
