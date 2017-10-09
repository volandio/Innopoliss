package October2017.Date_02_10_17.AlienChat2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Client {

    private static InetAddress addr;
    private static String username;

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //консоль
        System.out.print("Your name: ");
        try {
            username = br.readLine();
            System.out.println("Welcome, " + username + ".");
        } catch (IOException e2) {
            System.err.println("Error I/O");
        }

        try {
            addr = InetAddress.getByName("localhost");
        } catch (UnknownHostException e1) {
            System.err.println("Unknow adress");
        }
        System.out.println("Address: " + addr);
        try{
            int j;
            Socket socket = new Socket(addr, Server.PORT);

            try{
                System.out.println("Socket: " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                out.println(username);

                Thread thread = new Thread(new ReadMessage(in)); //поток чтения входящих сообщений
                thread.start();

                while(true){ //поток ввода сообщения
                    String msg = br.readLine();
                    Message message = new Message(username, msg, new Date());
                    oos.writeObject(message);
                }
            }
            finally{
                System.out.println("Closing: " + socket);
                socket.close();
            }
        }
        catch(IOException e){
            System.err.println("Can't conect to server");
        }
    }

}

class ReadMessage implements Runnable{

    BufferedReader in;

    public ReadMessage(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            while(true){
                String s = in.readLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            System.err.println("Error I/O");
        }
    }
}
