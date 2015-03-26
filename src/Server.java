import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Server {
    private ServerSocket sock; //kind of address in network
    private PrintWriter out; // formatted stream for output to client
    private BufferedReader in; // stream from client to server

    public Server() throws IOException {
        sock = new ServerSocket(ServerMain.PORT);
        Socket socket = sock.accept();
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        serverIO();
    }

    public void serverIO() throws IOException {
        String input;
        Scanner scanner;


        while ((input = in.readLine()) != null) {
            int sum = 0;
            int[] array = Stream.of(input.split(" "))
                    .mapToInt(token -> Integer.parseInt(token))
                    .toArray();
            sum = IntStream.of(array).sum();

            System.out.println("input = " + input);
            out.println("server: echo " + input); // echo
            out.println("server: sum result = " + sum);


        }
    }


}
