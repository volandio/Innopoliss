package October2017.Date_02_10_17.Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("We got client!!");
        InputStream inputStream = socket.getInputStream();
        DataInputStream das = new DataInputStream(inputStream);

        while (true) {
            String message = das.readUTF();
            System.out.println(message);
        }
    }
}
