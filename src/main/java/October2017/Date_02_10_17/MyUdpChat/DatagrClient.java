package October2017.Date_02_10_17.MyUdpChat;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagrClient {
    private static String IPAddres = "127.0.0.1";
    private static int serverPort = 5555;


    public static void main(String[] args) throws IOException {
        System.out.println("Клиент начал работу...");

        DatagramSocket ds = new DatagramSocket(); // 2 потока обращаются к нему и все норм?

        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                InetAddress ip = null;
                try {
                    ip = InetAddress.getByName(IPAddres);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

                System.out.println("Введите свой Ник: ");
                String nickName = scanner.next();
                String HelloMessage = nickName+" connected to chat...";

                try {

                    DatagramPacket dp1 = new DatagramPacket(HelloMessage.getBytes(), 0, HelloMessage.length(), ip, serverPort);
                    ds.send(dp1);
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Welcome to chat.... ");

                while (true) {
                    try {

                        String message =nickName +" wrote: " + scanner.nextLine();
                        DatagramPacket dp = new DatagramPacket(message.getBytes(), 0, message.length(), ip, serverPort);
                        ds.send(dp);

                    } catch (SocketException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //  ds.close(); почему нельзя здесь???

            }
        });

        writer.start();

        Thread reciever = new Thread(new Runnable() {
            @Override
            public void run() {
             while(true) {
                 byte[] mass = new byte[1024];
                 DatagramPacket packet = new DatagramPacket(mass, 0, mass.length);

                 try {
                     ds.receive(packet);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 String message = new String(packet.getData(), 0, packet.getLength());
                 System.out.println(message);
             }
            }
        });
        reciever.start();

    }
}
