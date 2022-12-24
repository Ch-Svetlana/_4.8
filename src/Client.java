import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8085;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Sveta");
            String resp = in.readLine();
            System.out.println(resp);
        }

        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println(host + ", ip address: " + inetAddress.getHostAddress());
    }
}

