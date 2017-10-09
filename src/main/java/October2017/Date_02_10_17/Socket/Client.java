package October2017.Date_02_10_17.Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.next();
            dos.writeUTF(message);
            dos.flush();
        }
    }
}
