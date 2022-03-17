package exam01;

import java.util.Arrays;

public class Sample05 {

	public static void main(String[] args) {
		
		int[] arr1 = new int[] {1, 2, 3, 4, 5};
		int[] arr2 = new int[arr1.length];
		// Arrays 객체를 사용한 깊은 복사
				int[] arr4 = Arrays.copyOf(arr1, arr1.length); //뒤에 더 늘릴수도 있고 줄일수도있다.
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
