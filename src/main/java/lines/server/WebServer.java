package lines.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    private static final int DEFAULT_PORT = 8080;
    private static final int DEFAULT_THREAD_POOL_NUMBER = 8;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_NUMBER);

    public static void main(String[] args) throws Exception {
        int port = 0;

        if ( args == null || args.length == 0){
            port = DEFAULT_PORT;
        }else {
            port = Integer.parseInt(args[0]);
        }

        // Creating Server Socket
        try(ServerSocket listenSocket = new ServerSocket(port)){

            // Waiting for accepting client request
            Socket connection;

            while((connection = listenSocket.accept()) != null){
                executorService.submit(() -> {
                    // TODO - Receiving Request Implementation
                });
            }
        }
    }
}
