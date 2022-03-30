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
					
				System.out.println("\n"+sessionName+"'S TURN!\n");
				
				int hp = fromServer.readInt();
				int score = fromServer.readInt();
				
				System.out.println("HP: "+hp);
				System.out.println("Score: "+score);
				
				System.out.println("\nChoose a number:");
				System.out.println("1. Rock");
				System.out.println("2. Paper");
				System.out.println("3. Scissor\n");
				System.out.print(">");
				int choose1 = s.nextInt();
				
				

				toServer.writeInt(choose1);
				
				
				
				System.out.print("Result: ");
				String result=fromServer.readUTF();
				System.out.println(result);
				
				String infoRest=fromServer.readUTF();
				System.out.print(infoRest);
				
				Boolean ending = fromServer.readBoolean();
				if (ending==true) {
					System.out.println(fromServer.readUTF());
					System.out.println("\nCurrent HP is less than 0");
					System.out.println("\nProgram ending..");
					System.out.println("Thank you for using the Rock Paper Scissor Client Side.");
					break;
				}
				boolean programEnd = fromServer.readBoolean();
				if (programEnd = true) {
					System.out.println("\nYou have won the game!!! Your opponent hp has reached 0.");
					System.out.println("Program ending...");
					System.out.println("\nThank you for using the Rock Paper Scissor Client Side.");
					System.out.println("Exitting...");
					break;
				}
				System.out.println("\nContinue? y/n");
				String yn = s.next();
				
				if (yn.equalsIgnoreCase("y")) {
					toServer.writeBoolean(true);
				}else {
					toServer.writeBoolean(false);
					System.out.println("Thank you for using the Rock Paper Scissor Client Side.");
					System.out.println("Exitting...");
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
			s.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
