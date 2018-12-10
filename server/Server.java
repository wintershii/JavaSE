package http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private boolean isShutDown = false;

    public static void main(String[] args){
            Server server = new Server();
            server.start();
    }

    public void start(){
        start(8989);
    }

    /**
     * 指定端口
     * @param port
     */
    public void start(int port){
        try {
            server = new ServerSocket(port);
            receive();
        } catch (IOException e) {
            stop();
        }

    }

    public void receive() {

            Socket client = null;
            try {
                while (! isShutDown) {
                    client = server.accept();
                    new Thread(new Dispather(client)).start();
                }
            } catch (IOException e) {
                stop();
            }

    }

    public void stop(){
        isShutDown = true;
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
