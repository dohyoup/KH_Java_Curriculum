package exam01;

public class Grade {

	private String name; // 과목명
	private double score; // 점수 0~100
	private char rank; // A~F 까지의 등급
	
	public void Grade(String name) {
		this.name = name;
		System.out.println(score);
	}
	
	public void Grade(String name, double score) {
		this.name = name;
		this.score = score;
		System.out.println(rank);
	}
	
	public void setName () {
		this.name  = name;
	}
	public String getName () {
		return name;
	}
	
	public void setScore () {
		this.score = score;
	}
	
	public double getScore () {
		if(score >= 90 && score <= 100 ) {
			System.out.println("A");	
		}else if (score >= 80 && score < 90) {
			System.out.println("B");	
		}else if (score >= 70 && score < 80) {
			System.out.println("C");
		}else if (score >= 60 && score < 70) {
			System.out.println("D");
		}else if (score >= 40 && score < 60) {
			System.out.println("E");
		}else if (score < 40)
			System.out.println("F");
			return rank;
	}
	
	public void getRank () {
		
	}
	
	
}
