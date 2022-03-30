package assignment1;

public class Score {

	int score=0,maxScore=0,scoreGain=0;
	
	
	public Score() {}
	
	
	public void setScoreGain(int scoreGain) {
		this.scoreGain=scoreGain;
	}
	public void setMaxScore(int score) {
		maxScore=score;
	}
	
	public void addScore(int score) {
		this.score+=score;
	}
	
	public void addScoreGain(int scoreGain) {
		this.scoreGain+=scoreGain;
	}
	public void minusScore(int score) {
		this.score-=score;
	}
	
	public int showScore() {
		return score;
	}
	public int showScoreGain() {
		return scoreGain;
	}
	public int scoreMultiplier(int a) {
		int ans = scoreGain*a;
		return ans;
	}
	
	public boolean scoreOverLimit() {
		boolean outcome=false;
		if(score>=maxScore) {
			outcome=true;
		}
		
		return outcome;
	}
}
