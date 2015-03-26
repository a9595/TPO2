import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket sock; //kind of address in network
    private PrintWriter out; // formatted stream for output to client
    private BufferedReader in; // stream from client to server

    public Server() throws IOException {
        sock = new ServerSocket(7777);
        Socket socket = sock.accept();
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


    }

    public void serverIO() {
        String input;
        while()
    }


}
