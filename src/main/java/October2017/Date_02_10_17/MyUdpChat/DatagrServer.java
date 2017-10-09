package October2017.Date_02_10_17.MyUdpChat;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class DatagrServer { // клиент и сервер на должны быть на одной машине

    private  static int  port = 5555;
    private static Map<Integer, InetAddress> clientList = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Сервер начал работу...");


      while (true) {
          try {
              DatagramSocket ds = new DatagramSocket(port); // Надо ли 10 раз открывать порт??????????????
              byte[] mass = new byte[1024];
              DatagramPacket packet = new DatagramPacket(mass, 0, mass.length);

              ds.receive(packet);
              String message = new String(packet.getData(), 0, packet.getLength());

              if (clientList.containsKey(packet.getPort()) == false) {
                  clientList.put(packet.getPort(), packet.getAddress());
              }
              System.out.println(message);
              SendToAllOthers(ds, packet);
              ds.close();

          } catch (SocketException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }


      }
    }

private static void SendToAllOthers( DatagramSocket ds1, DatagramPacket packet) {
        Integer exceptPort = packet.getPort();
    for (Map.Entry entry: clientList.entrySet()
         ) { // меняем порт и отправляем дальше
        if (!entry.getKey().equals(exceptPort))
        {
            packet.setPort((Integer) entry.getKey());
            packet.setAddress((InetAddress) entry.getValue());
            try {
                ds1.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


}
