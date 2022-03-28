package assignment1;

public class Rounds {
public int rounds =0,won=0,lost=0;

public Rounds() {}

public void addRounds(int a) {
	
	this.rounds += a;
	
}


//a is the number of rounds and b is the number of targeted rounds

public void addWon(int a) {
	won+=a;
}
public void addlost(int a) {
	won+=a;
}
public int intRounds() {
	
	return rounds;
}
public int intWon() {
	
	return won;
}
public int intLost() {
	
	return lost;
}
public boolean isDivisible(int a, int b) {
	boolean outc=false;
	
	int divisible = a%b;
	if (divisible == 0) {
		outc = true;
	}
	return outc;
}

}
