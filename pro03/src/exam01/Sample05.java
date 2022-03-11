package exam01;

import java.util.Scanner; 

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * 사용자가 입력한 정수값 까지 반복 출력하는 코드를 작성한다.
		 * (1 ~ 사용자 입력 값 까지 출력)
		 */
		
		/*
		 * 사용자가 입력한 정수값 부터 1까지 반복출력
		 */
		
		/*
		 * 위 문제에서 반복 출력할 때 한 줄에 7개의 정수 값이 출력되도록 코드를 작성한다.
		 */
		
		//1번 문제
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("정수값 입력 : ");
		for(int i = 1; i <= num; i++) {
			System.out.println(i);
		}
		
		//2번 문제
		for(int i = num; i >= 1; i--) {
			System.out.println(i);
	}
		int cnt = 0; // <- 플레그
		for(int i = 1; i <= num; i++) {					 				
				System.out.print(i+1+ " ");
				cnt++;
				if(cnt == 7) {
				  System.out.println();
				  cnt =0;
			}
		}
		for(int i = 1; i < num; i++) {
			System.out.print(i+" ");
			if(i % 7 == 0) {
				System.out.println();
			}
		}
			
		
	}
}
