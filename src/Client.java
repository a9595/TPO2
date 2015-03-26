import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket; //kind of address in network
    private PrintWriter out; // formatted stream for output to client
    private BufferedReader in; // stream from client to

    public Client() throws IOException {
        socket = new Socket("localhost", ServerMain.PORT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        run();
    }

    private void run() throws IOException {
        String message;
        Scanner scanner = new Scanner(System.in);
        out.println(scanner.nextLine()); //send to server

        while ((message = in.readLine()) != null) {
            System.out.println("client: " + message);


        }
    }
}
