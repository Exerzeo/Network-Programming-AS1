package assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket= null,socket2=null;
		DataInputStream fromClient=null;
		DataOutputStream toClient =null;
		try {
			
			serverSocket = new ServerSocket(12345);
			
			System.out.println("Welcome to Rock Paper Scissor server side!");
			System.out.println("\nWaiting for clients to connect...");
			
			while(true) {
				
				
				socket = serverSocket.accept();
				System.out.println("\nFirst client connected");
					
					
				
				socket2 = serverSocket.accept();
				System.out.println("Second client connected\n");
				
			
				
				new Thread(new ClientHandler(socket,socket2)).start();
			}
			
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("Error Occured!");
			
			
		}finally {
			try {
			if (serverSocket != null) {
				serverSocket.close();
			}
			if (socket !=null) {
				socket.close();
			}
			if(fromClient!=null) {
				fromClient.close();
			}
			if(toClient !=null) {
				toClient.close();
			}
			} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


