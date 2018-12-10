package http.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应信息
 */

public class Response {
    //存储头信息
    private  StringBuilder headInfo;
    //正文长度
    private int len = 0;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    //正文
    private StringBuilder content;

    private BufferedWriter bw;

    public Response(){
        headInfo = new StringBuilder();
        content = new StringBuilder();
        len = 0;
    }

    public Response(OutputStream os){
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    public Response(Socket client){
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            headInfo = null;
        }
    }

    /**
     * 构建正文
     */
    public Response print(String info){
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        len += (info + CRLF).getBytes().length;
        return this;
    }

    /**
     *构建响应头
     */
    private void creatHeadInfo(int code){
        //HTTP协议版本，状态代码，描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
                switch(code){
                    case 200 : headInfo.append("OK");
                            break;
                    case 404 : headInfo.append("NOT FOUND");
                            break;
                    case 500 : headInfo.append("Server Error");
                            break;
                }
                headInfo.append(CRLF);
        //响应头
        headInfo.append("Server: shi Tomcat/6.0.12").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=utf-8").append(CRLF);
        //正文长度
        headInfo.append("Content-Length:").append(len).append(CRLF);
        //正文之前
        headInfo.append(CRLF);
    }

    //推送到客户端
    void pushToClient(int code){
        if (headInfo == null){
            code = 500;
        }
        //头信息+分隔符
        creatHeadInfo(code);
        try {
            bw.append(headInfo.toString());
            bw.append(content.toString());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //正文

    }
}
