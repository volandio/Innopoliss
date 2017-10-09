package October2017.Date_02_10_17.UDPChat3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

	private static InetAddress host; 
	 private static final int PORT = 1234; 
	 private static DatagramSocket datagramSocket; 
	 private static DatagramPacket inPacket, outPacket;
	 private static byte[] buffer;
	private static Scanner userEntry; 
	
	public static void main(String[] args) {


		try 
		  { 
		   host = InetAddress.getLocalHost(); 
		  } 
		  catch(UnknownHostException uhEx) 
		  { 
		   System.out.println("Host ID not found!"); 
		   System.exit(1); 
		  } 
		  accessServer(); 
		 } 
		 private static void accessServer() 
		 { 
		  try 
		  { 
		   //Step 1...
		   datagramSocket = new DatagramSocket();    
		   userEntry = new Scanner(System.in); 
		   String message="", response=""; 
		   do 
		   { 
		    System.out.print("Enter message: "); 
		    message = userEntry.nextLine(); 
		    if (!message.equals("***CLOSE***")) 
		    { 
		     outPacket = new DatagramPacket( 
		           message.getBytes(), 
		           message.length(), 
		         host,PORT); //Step 2.
		     //Step 3... 
		     datagramSocket.send(outPacket);  
		     buffer = new byte[256];   //Step 4.
		     inPacket = 
		       new DatagramPacket( 
		      buffer, buffer.length);//Step 5.
		     //Step 6... 
		     datagramSocket.receive(inPacket);  
		     response = 
		       new String(inPacket.getData(), 
		         0, inPacket.getLength()); //Step 7.
		     System.out.println( 
		        "\nSERVER> "+response); 
		    } 
		   }while (!message.equals("***CLOSE***")); 
		  } 
		  catch(IOException ioEx) 
		  { 
		   ioEx.printStackTrace(); 
		  } 
		  finally 
		  { 
		   System.out.println( 
				   
		      "\n* Closing connection... *"); 
		   datagramSocket.close();    //Step 8.
		  } 
		 } 
		} 
		     
		     
		     