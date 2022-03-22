package exam09;

public class Circle {
	public static final double PI = 3.14; //대문자이니 명시안되어있어도 암묵적으로 상수로 취급한다.
	private double radius;
//	private double diamiter;
//	private double area;
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	//setter
	public double getRadius() { //setter getter는 하나씩만 할당해서만들어라 나처럼 여러개하면안된다.규칙이다.		 	
		  return radius;
		  
		  //간접적으로 은닉된 정보(멤버변수)에 접근시키기 위해 만들어 주는 접근 메서드
	  }
	  public void setRadius(double radius) { // getter
		  this.radius = radius;
	  }
	  public static double getPi() {
		  return PI;
	  }
	  
	  public void draw() {
		  System.out.println("반지름" + radius + "cm인 원을 그립니다.");
	  }
	  
}
