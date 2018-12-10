package http.server;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request req,Response response) {
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        if (login(name,pwd)){
            response.println("登陆成功！");
        }else {
            response.println("账号密码输入错误！");
        }


    }

    public boolean login(String name,String pwd){
        return name.equals("wintershii") && pwd.equals("123123");
    }


    @Override
    public void doPost(Request req,Response response) throws Exception {

    }
}
