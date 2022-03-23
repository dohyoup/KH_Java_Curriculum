package exam01;

public class Run {

	public static void main(String[] args) {
		Grade g =  new Grade("수학");
		g.setScore(90);
		
		System.out.println(g.getName());
		System.out.println(g.getScore());
		System.out.println(g.getRank());
		
		Grade g2 = new Grade("수학", 82.5);
		
		System.out.println(g.getName());
		System.out.println(g.getScore());
		System.out.println(g.getRank());
	}

}
