package October2017.Date_02_10_17.UDPChat2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main (String[] args) throws InterruptedException {
        host = "localhost";
        port = 1095;
        try {
            InetAddress address = InetAddress.getByName(host); //получаем адрес для передачи информации
            DatagramSocket socket = new DatagramSocket();      //создаём сокет
            while(true)
            {
                int i = (int) (1000*Math.random());            //создаем случайное число для длины пакета
                byte [] buf = new byte[i];                     //передаем i, и определяем массив с данными
                System.out.println(buf.length);                //посмотрим между делом длину полученного массива
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
//создадим объект класса DatagramPacket и передадим ему массив, длину массива, адрес куда слать и порт
                socket.send(packet);                           //отправляем созданный UDP пакет
            }
        }
        catch (IOException e) {
            e.printStackTrace();                          //отлавливаем необходимые исключения
        }
    }
    private static String host;
    private static int port;
}
