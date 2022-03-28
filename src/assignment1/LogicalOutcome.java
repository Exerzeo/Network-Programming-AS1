package assignment1;

public class LogicalOutcome {
public boolean outc = false;
public String rps="", result="";

public LogicalOutcome(){}

public String chosenRPS(int a) {
	if(a==1) {
		
		rps = "Rock";
		
	}else if(a==2) {
		
		rps = "Paper";
		
	}else if(a==3) {
		
		rps= "Scissor";
		
	}
	return rps;
}

public String resultRPS1(int a,int b) {
	if (a==b) {
		result="Draw";
	}else if(a==1&b==2) {
		result="Player 2 Wins. Rock vs Paper";
	}else if(a==1&b==3) {
		result="Player 1 Wins. Rock vs Scissor";
	}else if(a==3&b==2) {
		result="Player 1 Wins. Scissor vs Paper";
	}else if(a==3&b==1) {
		result="Player 2 Wins. Scissor vs Rock";
	}else if(a==2&b==1) {
		result="Player 1 Wins. Paper vs Rock";
	}else if(a==2&b==3) {
		result="Player 2 Wins. Scissor vs Paper";
	}
	return result;
}
public String resultRPS2(int a,int b) {
	if (a==b) {
		result="Draw";
	}else if(a==1&b==2) {
		result="You lose. Rock vs Paper";
	}else if(a==1&b==3) {
		result="You Win. Rock vs Scissor";
	}else if(a==3&b==2) {
		result="You Win. Scissor vs Paper";
	}else if(a==3&b==1) {
		result="You lose. Scissor vs Rock";
	}else if(a==2&b==1) {
		result="You Win. Paper vs Rock";
	}else if(a==2&b==3) {
		result="You lose. Paper vs Scissor";
	}
	return result;
}

public boolean booleanResultRPS(int a,int b) {
	if(a==1&b==2) {
		outc=false;
	}else if(a==1&b==3) {
		outc=true;
	}else if(a==3&b==2) {
		outc=true;
	}else if(a==3&b==1) {
		outc=false;
	}else if(a==2&b==1) {
		outc=true;
	}else if(a==2&b==3) {
		outc=false;
	}else if(a==b) {
		System.out.println("!Result is not in boolean!");
	}
	return outc;
}

}
