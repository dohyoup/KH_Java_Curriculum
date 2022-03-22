package exam09;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Circle 클래스, Rectangle 클래스, Triangle 클래스를 만든다.
		 * 
		 * 1. 위의 만들어진 클래스를 이용하여 각 도형의 넓이를 구하기 위한 메서드를
		 * 	  만들어 본다. (메서드명은 area 로 한다.)
		 * 
		 * 2. 위의 만들어진 클래스를 이용하여 각 도형의 둘레를 구하기 위한 메서드를 
		 * 	  만들어 본다. (메서드명은 round로 한다.)
		 * 	  Triangle 은 정삼각형으로 취급해서 둘레를 구한다.
		 */
		Circle c = new Circle();
		c.setRadius(5.1);
		c.draw();
	
	}

}
