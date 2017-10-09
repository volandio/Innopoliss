package October2017.Date_02_10_17.AlienChat2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server{

    public static final int PORT = 1234;
    public static Clients clients;
    public static LastMessage lastMessage;

    public static void main(String[] args)  throws IOException {
        ServerSocket s = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
        clients = new Clients();
        lastMessage = new LastMessage();
        System.out.println("Started: " + s);
        try{
            while(true){
                Socket socket = s.accept();
                try{
                    System.out.println("Connected: " + socket);///
                    clients.addUser(new ServerOne(socket));
                }
                catch(IOException e){
                    System.out.println("Closing: " + socket);
                    socket.close();
                }
            }
        }finally{
            s.close();
        }
    }
}

class ServerOne extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectInputStream ois;
    private String username;

    public ServerOne(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        ois = new ObjectInputStream(socket.getInputStream());
        Server.lastMessage.send(out);
        start();
    }

    public void run(){
        try{
            username = in.readLine();
            Server.clients.distribution(socket, "Joined: " + username);

            while(true){
                Message message = (Message) ois.readObject();
                Server.lastMessage.add(message.getMessage());
                System.out.println("Socket: " + socket + " Message: " + message.getMessage());
                DateFormat dateFormat = new SimpleDateFormat("hh:mm");
                String complite = message.getName() + " (" + dateFormat.format(message.gerDate())
                    + ") " +": " + message.getMessage();
                Server.clients.distribution(socket, complite);
            }
        } catch (IOException e) {
            System.err.println("Error I/O");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found");
        }
        finally{
            System.out.println("Closing: " + socket);
            Server.clients.distribution(socket, "Leave: " + username);
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }

    public void sendMsg(String message){
        out.println(message);
    }

    public Socket getSocket(){
        return socket;
    }
}

class Clients{

    private ArrayList<ServerOne> list = new ArrayList<>();
    private int count = 0;

    public void addUser(ServerOne client){
        list.add(client);
        count++;
    }

    public void distribution(Socket s, String message){
        Iterator<ServerOne> iter = list.iterator();
        while(iter.hasNext()){
            ServerOne elem = iter.next();
            //if(!((elem.getSocket()).equals(s))){ //рассылать всем, кроме самого себя
            elem.sendMsg(message);
            //	}
        }
    }
}

class LastMessage{
    private LinkedList<String> list = new LinkedList<>();

    public void add(String msg){
        if(list.size() < 10){
            list.add(msg);
        }
        else{
            list.addLast(msg);
            list.removeFirst();
        }

    }

    public void send(PrintWriter out){
        for(String str : list){
            out.println(str);
        }
    }
}
