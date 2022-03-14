package pro04;

import java.util.Arrays;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 배열의 깊은 복사 -> 반복문을 사용하여 값을 하나씩 배열에 저장
		 * 
		 * 
		 */
		
		int[] arr1 = new int[] {1, 2, 3, 4, 5};
		int[] arr2 = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr2[i];
		}
		// 자바의 기본 기능을 사용한 깊은 복사
		int[] arr3 = new int [arr1.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length); // 형한테 질문
						//원본     //복사본
		arr1[0] = 10;
		for(int i = 0; i< arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n", i, arr1[i], i, arr3[i]);
			
		}
		System.out.print("\n");
		
		// Arrays 객체를 사용한 깊은 복사
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);
		arr1[1] = 20;
		for(int i = 0; i< arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n", i, arr1[i], i, arr4[i]);
	}
		System.out.print("\n");
}
}
