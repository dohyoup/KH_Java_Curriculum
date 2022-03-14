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
		int[] arr3 = new int [arr1.length]; //반복횟수
		System.arraycopy(arr1, 0, arr3, 0, arr1.length-1); // 인덱스의 위치를 옮길때 쓰면 좋음
					   //원본  //0을  -> 0에다가라는의미 //복사본
		arr1[0] = 10;
		for(int i = 0; i< arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n", i, arr1[i], i, arr3[i]);
			
		}
		System.out.print("\n");
		
		// Arrays 객체를 사용한 깊은 복사
		int[] arr4 = Arrays.copyOf(arr1, arr1.length+3); //뒤에 더 늘릴수도 있고 줄일수도있다.
		arr1[1] = 20;
		for(int i = 0; i< arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n", i, arr1[i], i, arr4[i]);
	}
		System.out.print("\n");
		
		
		//.clone() 메서드를 사용한 깊은 복사
		int[] arr5 = arr1.clone(); // arr1값 그대로 깊은 복사를해서 arr5에 저장할거다 할때 clone을 쓴다.
		
		arr1[2] = 30;
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr5[%d] -> %d\n", i, arr1[i], i, arr5[i]);

		}
		
		
}
}
