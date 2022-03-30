package assignment1;

public class Rounds {
public int rounds =0,maxRound=0;

public Rounds() {}

public void addRounds(int a) {
	
	this.rounds += a;
	
}

public void setMaxRounds(int a) {
	maxRound=a;
}

public int getMaxRounds(int a) {
	return maxRound;
}



public int intRounds() {
	
	return rounds;
}



}
