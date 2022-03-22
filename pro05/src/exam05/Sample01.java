package exam05;

import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		//지역변수는 초기화가필요 //멤버변수는 초기화 안해도됨. 기본값 들어가있음 0.0
		
		c1.radius = 1.5;
		c2.radius = 3.5;
		c1.diamiter = c1.radius * 2 ;
		c2.diamiter = c2.radius * 2 ;
		c1.area = (Circle.PI *(c1.radius*c1.radius));
		c1.area = (Circle.PI *(c2.radius*c2.radius));
		
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		
		r1.width = c1.diamiter;
		r2.width = c2.diamiter;
		System.out.println(r1.width + "|" + r2.width);
		
		Random rand = new Random();
		
		r1.height = rand.nextInt(7) + 3 ;
		r2.height = rand.nextInt(7) + 3 ;
		System.out.println(r1.height + "|" + r2.height);
		r1.area = r1.width * r1.height;
		r2.area = r2.width * r2.height;
		System.out.println(r1.area + "|" + r2.area);
		
		
		
		
		
		
	}

}
