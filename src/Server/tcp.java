package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class tcp {

    public static void main(String[] argv) throws IOException {
        ServerSocket serverSocket = new ServerSocket(65000);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(16);
        while(true)
        {
            Socket socket = serverSocket.accept();
            fixedThreadPool.execute(new Server(socket));
        }
    }
}

