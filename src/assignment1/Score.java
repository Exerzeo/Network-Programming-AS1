package assignment1;

public class Score {

	int score=0,maxScore=0;
	
	
	public Score() {}
	
	public void setScore(int score) {
		this.score=score;
	}
	public void setMaxScore(int score) {
		maxScore=score;
	}
	
	public void addScore(int score) {
		this.score+=score;
	}
	
	public void minusScore(int score) {
		this.score= this.score-score;
	}
	
	public int showScore() {
		return score;
	}
	
	public boolean scoreOverLimit() {
		boolean outcome=false;
		if(score>=maxScore) {
			outcome=true;
		}
		
		return outcome;
	}
}
