package test;

import java.util.Arrays;
import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tot = 0;
		double avg;
		
		int[] arr1 = new int[0];
		
		int i = 0;
		for(;;) {
			System.out.printf("%d 번째 정수값 입력 : \n", i+1);
			int num = 0;
			String other = "";
			if(sc.hasNextInt()) {
				num = sc.nextInt(); sc.nextLine();
			}else {
				other = sc.nextLine();
				if(other.equals("exit")) {
					break;
				}else {
					System.out.println("정수 값 또는 exit를 입력하세요.");
					continue;
				}
				
			}
			
			int[] temp = Arrays.copyOf(arr1, arr1.length+1);
			arr1 = temp;
			
			arr1[i] = num;
			tot += arr1[i];
			i++;
		}
		avg = (double)tot / arr1.length; // 평균계산
		System.out.printf("총 합 : %d\n", tot);
		System.out.printf("평 균 : %.1f\n", avg);

	}

}
