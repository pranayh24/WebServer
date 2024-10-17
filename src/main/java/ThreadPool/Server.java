package ThreadPool;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final ExecutorService threadPool;

    public Server(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket clientSocket){
        try(PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)){
            toClient.println("Hello from Multi-Threaded(thread-pool) Server");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        int port = 8080;
        int poolSize =50;
        Server server = new Server(poolSize);

        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(100000);
            System.out.println("Server is running on port " + port);

            while(true){
                Socket clientSocket = serverSocket.accept();
                server.threadPool.execute(()-> server.handleClient(clientSocket));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
