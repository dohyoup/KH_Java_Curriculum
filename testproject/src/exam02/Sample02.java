package exam02;

import java.util.Arrays;
import java.util.Random;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 10인 정수 배열을 2개 생성 후 
		 * 각 배열에 10~99 사이의 난수값으로 초기화 시키고 출력한다.
		 */
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		Random rand = new Random();
		for(int i =0; i < arr1.length; i++) {
			int num = rand.nextInt(90)+10;
			arr1[i] = num;
			
			num = rand.nextInt(90)+10;
			arr2[i] = num;
		}
		System.out.println("첫 번째 출력");
		System.out.println("\t" + Arrays.toString(arr1));
		System.out.println("\t" + Arrays.toString(arr2));
		
		/*
		 * 1번 문제에서 생성한 첫번째 배열과 두번째배열의 합을 구하여 
		 * 새로운 세번째 배열을 만들어 출력한다.
		 * 
		 */
		int[] arr3 = arr1.clone();
		for(int i = 0; i < arr3.length; i++) {
			arr1[i] += arr2[i];
		}
		System.out.println("두 번째 출력");
		System.out.println("\t" + Arrays.toString(arr3));

   }
}
