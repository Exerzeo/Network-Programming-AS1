package assignment1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main (String[]args) {
	
		Socket socket = null;	
		DataOutputStream toServer = null;
		DataInputStream fromServer = null;
		Scanner s = new Scanner(System.in);
		String sessionName="";
		
		try {
			socket = new Socket("127.0.0.1", 12345);
			toServer = new DataOutputStream(socket.getOutputStream());
			fromServer = new DataInputStream(socket.getInputStream());
			
				
				System.out.println("Welcome To Rock Paper Scissor client side!");
				System.out.println("Please enter your Username:");
				sessionName=s.next();
				toServer.writeUTF(sessionName);
				while(true) {
				System.out.println(sessionName+"'S TURN!");
				
				System.out.println("Choose a number:");
				System.out.println("1. Rock");
				System.out.println("2. Paper");
				System.out.println("3. Scissor\n");
				System.out.print(">");
				int choose1 = s.nextInt();
				
				

				toServer.writeInt(choose1);
				
				
				
				System.out.print("Result: ");
				String reslt=fromServer.readUTF();
				System.out.println(reslt);
				System.out.println("\nContinue? y/n");
				String yn = s.next();
				
				if (yn.equalsIgnoreCase("y")) {
					toServer.writeBoolean(true);
				}else {
					toServer.writeBoolean(false);
					break;
				}
				
				}
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			try {
			if(socket !=null) {
				socket.close();
				}
			if (toServer !=null) {
				toServer.close();
			}
			if (fromServer !=null) {
				fromServer.close();
			}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
