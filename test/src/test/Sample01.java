package test;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		
//pro04 - Sample07		
		Scanner sc = new Scanner(System.in);
		System.out.print("총 입력 횟수 : " );
		int count = sc.nextInt(); 
		int[] arr1 = new int[count];
		int tot =0;
		double avg;
		//int num1;			//count써도됨
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d 번째 정수값 입력 : \n", i+1);
			arr1[i] = sc.nextInt();//입력받으면서 배열 arr1에 저장
			tot += arr1[i]; //arr1에 저장하면서 총합 tot 계산
			//num1 = sc.nextInt();
		}					//count 써도됨
		avg = (double)tot / arr1.length; // 평균계산
		System.out.printf("총 합 : %d\n", tot);
		System.out.printf("평 균 : %.1f\n", avg);
	}
}

			
			


	
