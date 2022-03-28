package assignment1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	Socket socket, socket2;
	DataInputStream fromClient,fromClient2;
	DataOutputStream toClient,toClient2;
	Scanner s = new Scanner(System.in);
	
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
			
			String playerOne = "", playerTwo="";
			boolean loop = true,loop2=true;
			LogicalOutcome owl =new LogicalOutcome();
			Rounds rounds = new Rounds();
			HealthPoint health1 = new HealthPoint(),health2 = new HealthPoint();
			Score score1 = new Score(),score2 = new Score();
			
			
				health1.setHP(5);
				health2.setHP(5);
				
				String sessionName=fromClient.readUTF(),sessionName2=fromClient2.readUTF();
				
				System.out.println("First client named themselves as: "+sessionName);
				
				System.out.println("Second client named themselves as: "+sessionName2);
				
				while(true) {
				rounds.addRounds(1);
				int numRounds = rounds.intRounds();
				
				
				
				int hp1=health1.showHP();
				int hp2=health2.showHP();
				
				toClient.writeInt(hp1);
				toClient2.writeInt(hp2);
				
				int scorePoint1 = score1.showScore();
				int scorePoint2 = score2.showScore();
				
				toClient.writeInt(scorePoint1);
				toClient2.writeInt(scorePoint2);
				
				
				System.out.println("\nGame Started. Round: "+numRounds+"\nWaiting for players to pick their options.");
				
				
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
				
				boolean result1 = owl.booleanResultRPS(rpsChoice1, rpsChoice2);
				boolean result2  = owl.booleanResultRPS(rpsChoice2, rpsChoice1);
				
				if (result1 == true) {
					score1.addScore(100);
					toClient.writeUTF("Score added 100");
				}else {
					health1.minusHP(5);
					toClient.writeUTF("HP -1");
				}
				
				if (result2 ==true) {
					score2.addScore(100);
					toClient2.writeUTF("Score added 100");
				}else {
					health2.minusHP(5);
					toClient2.writeUTF("HP -1");
				}
				
				toClient.writeInt(hp1);
				toClient2.writeInt(hp2);
				
				boolean ending1 = false,ending2 = false;
				
				ending1 = health1.isHPZero();
				ending2 = health2.isHPZero();
				
				if (ending1 == true) {
					System.out.println("\nThe hp of "+ sessionName+" has reached 0 :) gg");
					System.out.println("\nFinal Result:");
					System.out.println("Winner of game: "+sessionName2);
					System.out.println("Total rounds played: "+numRounds);
					System.out.println("Score of "+sessionName2+": "+score2.showScore());
					
					toClient.writeUTF("You lost. Your HP has reached 0");
					
					toClient2.writeUTF(sessionName+" HP's has reached 0 You Won!!!");
					break;
				}
				if (ending2 == true) {
					System.out.println("\nThe hp of "+ sessionName2+" has reached 0 :) gg");
					System.out.println("\nFinal Result:");
					System.out.println("Winner of game: "+sessionName);
					System.out.println("Total rounds played: "+numRounds);
					System.out.println("Score of "+sessionName+": "+score1.showScore());
					
					toClient2.writeUTF("You lost. Your HP has reached 0");
					
					toClient.writeUTF(sessionName2+" HP's has reached 0 You Won!!!");
					break;
				}
				
				
				String outcServer=owl.resultRPS1(rpsChoice1, rpsChoice2,sessionName,sessionName2);
				System.out.println("\n"+sessionName+" vs "+sessionName2+"\nResult: "+outcServer);
				
				
				
				
				
				loop=fromClient.readBoolean();
				loop2=fromClient2.readBoolean();
				if (loop == false||loop2 == false) {
					System.out.println("User has decided to not continue. The program is ending..\n\n");
					break;
				}
			}
				System.out.println("\nThank you for playing Rock Paper Scissor Server side.");
				System.out.println("Input any key to end connection");
				System.out.print(">");
				s.next();
				
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

