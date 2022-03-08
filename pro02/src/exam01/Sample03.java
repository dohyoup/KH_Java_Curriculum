package exam01;
import java.util.Scanner;
public class Sample03 {

	public static void main(String[] args) {
		/*
		 * Scanner 를 사용하여 사용자 입력을 받고 다음의 결과가 나오도록 하시오.
		 * 			1. 사용자 입력을 통해 국어, 영어, 수학 점수를 입력 받는다. (정수 데이터를 입력 받는다.)
		 *  		2. 입력 받은 정수 데이터의 값에 대해 총점과 평균을 구한다.
		 * 			3. 평균 점수가 60 점 이상인 경우에만 다음의 메시지를 출력한다.
		 * 				축하 합니다. 합격입니다.
		 * 					총점 : 213
		 * 					국어 : 75점
		 *					영어 : 70점
		 *					수학 : 68점
		 *					평균 : 71.0점
		 *			4. 평균 점수가 60 점 미만인 경우에는 다음의 메시지를 출력한다.
		 *				평균 점수가 미달하였습니다.
		 *			5. 국어, 영어, 수학 과목중 40 점 미만의 과목이 있는 겨우 다음의 메시지를 출력한다.
		 *				과락된 과목이 있어 불합격 되었습니다.
		 */			
		
		int first, second, third;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요.");
		first = sc.nextInt();
		System.out.println("영어 점수를 입력하세요.");
		second = sc.nextInt();
		System.out.println("수학 점수를 입력하세요.");
		third = sc.nextInt();
		
		double avg = (first+second+third)/3.0;
		int sum = first+second+third;
		
		if(avg>=60) {
			System.out.println("축하 합니다. 합격입니다.");
			System.out.println("   총점 : " + sum );
			System.out.println("   국어 : " + first);
			System.out.println("   영어 : " + second);
			System.out.println("   수학 : " + third);
			System.out.println("   평균 : " + avg);
		}else { 
			System.out.println("평균 점수가 미달하였습니다.");
			if(first<40 ||second<40 ||third<40) {
				System.out.println("과락된 과목이 있어 불합격 되었습니다.");
			}
		}
		
		
		
	}

}
