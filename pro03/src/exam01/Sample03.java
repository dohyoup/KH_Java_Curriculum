package exam01;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		for(int i = 0; i < 3; i++) {
			System.out.print("1~5 사이의 정수값 입력 : ");
			num = sc.nextInt();
			if(i==2) {
				System.out.println("입력 횟수를 초과하였습니다.");
			}
			if(num >= 1 && num <= 5) {
				break;
			}
			
		 }
		
		
 }

}
