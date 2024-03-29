package exam01;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * 		- 프로그램 코드의 실행을 제어하기 위한 제어문 중 하나이다.
		 * 		- 조건에 따라 코드를 실행하거나 실행하지 않게 제어를 한다.	
		 * 		  (true : 실행, false : 실행x 다음 코드 진행)
		 * 		- 조건문의 종류는 if 문, switch 문이 있다.
		 */
		
		/*
		 * if문
		 * 		if(조건식) {
		 * 			조건식의 결과가 참일 떄 실행할 코드는 여기에 작성한다.
		 *      } else {
		 *      	저건식의 결과가 거짓일 때 실행할 코드는 여기에 작성한다.
		 *      }
		 * 
		 */
		
		int num1 = 9;
		
		if (num1 > 10) {
			System.out.println("num1에 저장된 값은 10 보다 큽니다.");
			} else {
			System.out.println("num1에 저장된 값은 10 보다 작습니다.");
			}
		
		int num2 = 121;
		
		if(num2 % 2 == 0) {
			System.out.println("num2의 값은 짝수 있니다.");
		}else {
			System.out.println("num2의 값은 홀수 있니다.");
		}
		/*
		 * if...else if
		 *     if(조건식1) {
		 *     
		 *     } else if(조건식2) {
		 *     
		 *     } else if(조건식3) {
		 *     
		 *     } else(옵션 : 써도되고 안써도됌) {
		 *     
		 *     }
		 * 
		 * 
		 */
		int num3 = 100;
		
		if(num3 <= 40) {//참이면 바로 멈추고 거짓이면 다음 코드로 넘어가는 형식
			System.out.println("과락입니다.");
		}else if(num3 <= 60) {
			System.out.println("재시험입니다.");	
		}else if(num3 >= 70) {
			System.out.println("합격입니다.");		
		}
		
		/*
		 * 중첩 if 문
		 *  	- 문장 안에 또 다른 문장이 중첩되어 작성되는 형태
		 * 		- 중첩은 원하는 만큼 반복해서 쓸 수 있다.
		 *  
		 */
		
		if(num3 <= 40) {//참이면 바로 멈추고 거짓이면 다음 코드로 넘어가는 형식
			System.out.println("과락입니다.");
		}else if(num3 <= 60) {
			System.out.println("재시험입니다.");	
		}else if(num3 <= 70) {
			System.out.println("합격입니다.");		
		}else {
			if(num3 == 100) {
				System.out.println("만점입니다.");
			}
		}
		
	}
  
}
