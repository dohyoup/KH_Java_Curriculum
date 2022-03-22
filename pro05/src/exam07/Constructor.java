package exam07;

public class Constructor {
	public int num1;
	public int num2;
	public int num3;
	public int num4;
	
	public Constructor() {
	//기본 생성자 생성자명은 메서드명이고 이는 클래스명과 같아야한다	
		//기본생성자는 JVM이 기본값을 지정해준다.
	}
	
	public Constructor(int num1) { //메서드 오버로딩 - 같은 이름의 생성자를 여러개 만들 수 있다. 조건 : 메서드에 대해서는 매개변수의 타입이나 갯수가 달라야한다.
		//매개변수 있는 생성자
		//JVM이 기본값을 지정해주지 않음
		this.num1  = num1; //두 num1은 의미가 다름.
		//this는 인스턴스객체에 자기자신을 의미 즉 클래스안에 정의되어있는 매개변수를 지칭하는것
	}
	public Constructor(int num1, int num2) { //반복되는 코드들은 재사용이 진리이다.
		this.num1  = num1;
		this.num2  = num2;
	}
	public Constructor(int num1, int num2, int num3) {
		this(num1, num2);
		this.num3  = num3;
	}
	public Constructor(int num1, int num2, int num3, int num4) {
		this(num1,num2,num3); // this로 묶어서 재사용시 규칙 = 반드시 첫줄에 작성해야한다.
		this.num4 = num4;
	}

}


