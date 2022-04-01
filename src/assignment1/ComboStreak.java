package assignment1;

public class ComboStreak {
int win = 0, lose = 0, punish = 0, rewards =0;

public ComboStreak() {}

public void setPunish(int a) {
	punish=a;
}

public void setRewards(int a) {
	rewards=a;
}

public void addWin(int a) {
	win+=a;
}

public void addLose(int a) {
	win+=a;
}

public int intWin() {
	
	return win;
}

public int intLose() {
	
	return lose;
}


//a is the number of rounds won and b is the targeted counts
public boolean isDivisible(int a, int b) {
	boolean outc=false;
	
	int divisible = a%b;
	if (divisible == 0) {
		outc = true;
	}
	return outc;
}





}
