package exam04;

public class Sample02 {
 //출력 메소드 내용
	public static void main(String[] args) {
		
		System.out.println("안녕하세요");
		System.out.println(123);
		System.out.println(456);
		System.out.print("안녕하세요");
		System.out.print(123);
		System.out.print(456);
		
		// 출력 형식을 지정하는 메서드
		System.out.printf("", 1);
		// f =format의 약자
		int i1 = 30;
		System.out.printf("당신의 나이는 %d 세 입니다.\n", i1);
		System.out.printf("당신의 나이는 %o 세 입니다.\n", i1);
		System.out.printf("당신의 나이는 %x 세 입니다.\n", i1);
		System.out.printf("당신의 나이는 %c 세 입니다.\n", i1+3);
		System.out.println("당신의 나이는"+ i1 + "세 입니다.");
		
		double d1 = 1234.5678;
		System.out.printf("실수 표기 형식 : %f\n", d1);//주로
		System.out.printf("실수 표기 형식 : %.2f\n", d1); //이거도주로 /원하는 소수점 자리까지 표기 .3이면 소수점 3자리까지
		System.out.printf("실수 표기 형식 : %e\n", d1);
		System.out.printf("실수 표기 형식 : %g\n", d1);
		System.out.printf("실수 표기 형식 : %A\n", d1);
		
	}

}
