package assignment1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

	Socket socket, socket2;
	DataInputStream fromClient,fromClient2;
	DataOutputStream toClient,toClient2;
	
	public ClientHandler (Socket socket,Socket socket2) {
		this.socket=socket;
		this.socket2=socket2;
	}
	
	@Override
	public void run() {
		try {
			fromClient = new DataInputStream(socket.getInputStream());
			fromClient2 = new DataInputStream(socket2.getInputStream());
			
			toClient =new DataOutputStream(socket.getOutputStream());
			toClient2 =new DataOutputStream(socket2.getOutputStream());
			
			String playerOne = null, playerTwo=null;
			LogicalOutcome owl =new LogicalOutcome();
			boolean loop = true,loop2=true;
			while(true) {
				
				String sessionName=fromClient.readUTF(),sessionName2=fromClient2.readUTF();
				
				System.out.println("First client named themselves as: "+sessionName);
				
				System.out.println("Second client named themselves as: "+sessionName2);
				
				int rpsChoice1 = fromClient.readInt();
				playerOne = owl.chosenRPS(rpsChoice1);
				int rpsChoice2 = fromClient2.readInt();
				playerTwo = owl.chosenRPS(rpsChoice2);
				
				System.out.println("\n"+sessionName+" Choose: "+playerOne);
				System.out.println(sessionName2+" Choose: "+playerTwo);
				
				
				String outcome1=owl.resultRPS2(rpsChoice1, rpsChoice2);
				String outcome2=owl.resultRPS2(rpsChoice2, rpsChoice1);
				
				toClient.writeUTF(outcome1);
				toClient2.writeUTF(outcome2);
				
				String outcServer=owl.resultRPS1(rpsChoice1, rpsChoice2);
				System.out.println("\n"+sessionName+" vs "+sessionName2+" Result: "+outcServer);
				
				
				
				
				
				
				loop=fromClient.readBoolean();
				loop2=fromClient2.readBoolean();
				if (loop == false||loop2 == false) {
					System.out.println("Thank you for playing Rock Paper Scissor Server side.");
					break;
				}
			}
		}catch (IOException e) {
			System.out.println("Error Occured!");
			
			
		}finally {
			try {
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

