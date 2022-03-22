package exam07;

public class Initialize {
	//명시적 초기값
	public int n1 = 10;
	public static int n2 = 20;
	
	public String s1 = "빈값";
	public static String s2 = "정적";
	
	public boolean b1 = true;
	public double d1 = 1.0;
	{//인스턴스 초기화 블록 초기값 - 위에 명시적 초기값 설정후에 중괄호 사용해서 블록 초기값 다시지정 //인스턴스 변수 사용가능
		n1 = 20;
		s1 = s1 + "입니다.";
		b1 = !b1;
		d1 += 9;
		s2 = s2 + "~~~";
	}
	static {//스태틱 필드에는 변수앞에 스태틱이 들어간 변수만 쓸 수 있다. //인스턴스 변수도 못쓴다.
		 n2 = 30;
		 s2 = s2 + "!!!";
	}
}
