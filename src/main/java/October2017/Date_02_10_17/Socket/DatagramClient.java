package October2017.Date_02_10_17.Socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import static October2017.Date_02_10_17.Socket.ServerConsts.PORT;

public class DatagramClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), ip, PORT);
        ds.send(packet);
        ds.close();
    }
}
