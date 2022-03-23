package exam01;

public class Grade {
	private String name; // 과목명
	private double score; // 점수 0~100
	private char rank; // A~F 까지의 등급
	private char[] rankArr = new char[] {'F', 'F', 'F', 'F', 'F', 'E', 'D', 'C', 'B', 'A', 'A'};
	
	public Grade(String name) {
		this.name = name;
	}
	
	public Grade(String name, double score) {
		this.name = name;
		this.setScore(score);
	}
	public String getName () {
		return this.name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public double getScore () {
			return this.score;
	}
	
	public void setScore (double score) {
		this.score = score;
		this._setRank(score);
	}
	
	public char getRank () {
		return rank;
	}
	
	private void _setRank (double score) {
		this.rank = this.rankArr[(int)(this.score / 10)];
		
		/*
		switch((int)(this.score / 10)) {
		case 10: case 9:
			this.rank = 'A'; break;
		case 8:
			this.rank = 'B'; break;
		case 7:
			this.rank = 'C'; break;
		case 6:
			this.rank = 'D'; break;
		case 5:
			this.rank = 'E'; break;
		case 4: case 3: case 2: case 1: case 0:;
			this.rank = 'F'; 
		}
		*/
	}
}
