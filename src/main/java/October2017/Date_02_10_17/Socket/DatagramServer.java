package October2017.Date_02_10_17.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import static October2017.Date_02_10_17.Socket.ServerConsts.PORT;

public class DatagramServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(PORT);
        byte[] packetMas = new byte[1024];
        DatagramPacket packet = new DatagramPacket(packetMas, 1024);

        ds.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println(message);
        ds.close();
    }
}
