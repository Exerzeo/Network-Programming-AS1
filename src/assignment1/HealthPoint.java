package assignment1;

public class HealthPoint {
int hp;

public HealthPoint() {}

public void setHP(int hp) {
	this.hp=hp;
}

public void addHP(int a) {
	hp+=a;
}

public void minusHP(int a) {
	hp-=a;
}

public int showHP() {
	return hp;
}

public boolean isHPZero() {
	boolean outc=false;
	
	if (hp<=0) {
		outc=true;
	}
	
	return outc;
	
}


public boolean isRoundDivisible(int a, int b) {
	boolean outc=false;
	
	int divisible = a%b;
	if (divisible == 0) {
		outc = true;
	}
	return outc;
}


}
