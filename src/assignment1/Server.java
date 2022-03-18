package assignment1;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(12345);
			System.out.println("Server has started");
			serverSocket.accept();
			System.out.println("Client has connected");
		} catch (IOException e) {
			System.out.println("Error Occured!");
		}finally {
			try {
			if (serverSocket != null) {
				
					serverSocket.close();
			}
			} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

