package exam05;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 *  복합 대입 연산
		 * 		대입(할당) 연산자와 산술연산이 결합되어 사용되는 연산자
		 * 		산술연산 먼저 수행 한 후에 대입 연산이 수행되는 형태로 실행된다.
		 * 
		 */
		int num1 = 1;
		//1에 산술연산 +를 먼저 실행하여 값이1+1로 2가되고 그값을 num1에 대입연산하여 num1=2가 나온다. 
		num1 += 1; // num1 = num1 + 1; 
		    //=+ 이렇게 반대로쓰면 안댐
		System.out.println(num1);
		//복합대입 연산과 증갑대입연산은 코드를 간결하게 작성하기 위해 사용한다.
				
		int num2 = 10; // 개별진행이아니라 순차진행이다  10-1 = 9 -> 9*3 = 27 -> 27/3 = 9
		num2 -= 1;
		System.out.println(num2);
				
		num2 *= 3;
		System.out.println(num2);
		
		num2 /= 3;
		System.out.println(num2);
		
		/*
		 * 삼항 연산
		 * 		조건식 ? 식1 : 식2;
		 * 
		 * 조건식 : true, false 가 나올 수 있는 식을 작성해야 한다.
		 * 식1 : 조건식의 결과가 참(true)일 때 수행할 식을 작성 한다.
		 * 식2 : 조건식의 결과가 거짓(false)일 때 수행할 식을 작성 한다.
		 */
		int num3 = 15;
		//위에 이미 String으로 정희해줘서 result만 써도댐
		String number = num3 % 2 == 0 ? "짝수" : "홀수";
		
		System.out.printf("%d 는 %s 입니다.", num3, number);
		
			
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요. : ");
		int age = sc.nextInt();		
		//true		//false
		String result = age >= 20 ? "성인입니다." : "미성년자 입니다.";
		System.out.println(result);
		
		
			
	}

}
