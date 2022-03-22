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
			arr3[i] = arr1[i] + arr2[i];
			
		}
		System.out.println("두 번째 출력");
     	System.out.println("\t" + Arrays.toString(arr3));
		
		/*
   * 3. 2번 문제까지 진행하여 만들어진 3개의 배열을 이용하여 짝수값만 저장되어 있는 배열과 홀수값만 저장
   *    되어 있는 배열을 만들고 짝수 배열과 홀수 배열을 출력한다.
		 */
		/*int[] arr4 = new int[30];
		int[] arr5 = new int[30];
		int num1 = 0; int num2 = 0;
		for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] % 2 == 0) {
					arr4[num1] = arr1[i];
					num1++;
				}else{
					arr5[num2] = arr1[i];
					num2++;
				}
			}
		for(int i = 0; i < arr2.length; i++) {
			if(arr2[i] % 2 == 0) {
				arr4[num1] = arr2[i];
				num1++;
			}else{
				arr5[num2] = arr2[i];
				num2++;
			}
		}
		for(int i = 0; i < arr3.length; i++) {
			if(arr3[i] % 2 == 0) {
				arr4[num1] = arr3[i];
				num1++;
			}else{
				arr5[num2] = arr3[i];
				num2++;
			}
		}
		System.out.println("세 번째 출력");
		Arrays.copyOf(arr4, arr1.length);
		System.out.println("\t" + Arrays.toString(arr4));
		System.out.println("\t" + Arrays.toString(arr5));		
		*/
		//두번째 방법
		/*
		int[] arr4; // 짝수
		int[] arr5; // 홀수
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				cnt1++;
			}else {
				cnt2++;
			}
			if(arr2[i] % 2 == 0) {
				cnt1++;
			}else {
				cnt2++;
			}
			if(arr3[i] % 2 == 0) {
				cnt1++;
			}else {
				cnt2++;
			}
		}
		arr4 = new int [cnt1];
		arr5 = new int [cnt2];
		int idx1 = 0, idx2 = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 ==0) {
			arr4[idx1] = arr1[i];
			idx1++;
			 }else {
			arr5[idx2] = arr2[i];
			idx2++;
		}
			if(arr2[i] % 2 ==0) {
				arr4[idx1] = arr1[i];
				idx1++;
				 }else {
				arr5[idx2] = arr1[i];
				idx2++;
			}
			if(arr3[i] % 2 ==0) {
				arr4[idx1] = arr1[i];
				idx1++;
				 }else {
				arr5[idx2] = arr1[i];
				idx2++;
			}
			
		}
		System.out.println("세번째 출력");
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
		*/
		//세번째 방법
		int[] arr4 = new int[0];
		int[] arr5 = new int[0];
		
		for(int i = 0; i < arr1.length; i++) {
			int[] temp;
			
			if(arr1[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0 ,arr4.length);
				arr4 = temp;
				
				arr4[arr4.length - 1] = arr1[i];
			}else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5,0,temp,0,arr5.length);
				arr5 = temp;
				
				arr5[arr5.length - 1] = arr1[i];
			}
			if(arr2[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0 ,arr4.length);
				arr4 = temp;
				
				arr4[arr4.length - 1] = arr2[i];
			}else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5,0,temp,0,arr5.length);
				arr5 = temp;
				
				arr5[arr5.length - 1] = arr2[i];
			}
			if(arr3[i] % 2 == 0) {
				temp = new int[arr4.length + 1];
				System.arraycopy(arr4, 0, temp, 0 ,arr4.length);
				arr4 = temp;
				
				arr4[arr4.length - 1] = arr3[i];
			}else {
				temp = new int[arr5.length + 1];
				System.arraycopy(arr5,0,temp,0,arr5.length);
				arr5 = temp;
				
				arr5[arr5.length - 1] = arr3[i];
			}
		}
		System.out.println("3. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr4));
		System.out.println("\t" + Arrays.toString(arr5));
		//4. 짝수/홀수 배열에 있는 값들중 중복된 값이 있는 경우 하나의 값만 남겨 새로운 배열로 만들고 출력한다.
		//중복된 값은 -1로 표기한다.
		int[] arr6 = new int [0];
		int[] arr7 = new int [0];
		
		for(int i = 0; i < arr4.length-1; i++) {
			if(arr4[i] != -1) {
			for(int j = i + 1; j < arr4.length; j++ ) {
			if(arr4[i] == arr4[j]) {
				arr4[j] = -1;
			    }
			}
		}
	}
		
		for(int i = 0; i < arr4.length; i++) {
			if(arr4[i] != -1) {
			int[] temp = new int[arr6.length + 1];
			System.arraycopy(arr6, 0, temp, 0, arr6.length);
			arr6 = temp;
			
			arr6[arr6.length - 1] = arr4[i];
			}
		}
		
		for(int i = 0; i < arr5.length - 1; i++) {
			if(arr5[i] != -1) {
				for(int j = i + 1; j < arr5.length; j++) {
					if(arr5[i] == arr5[j]) {
						arr5[j] = -1;
					}
				}
			}
		}
		for(int i = 0; i < arr5.length; i++) {
			if(arr5[i] != -1) {
			int[] temp = new int[arr7.length + 1];
				System.arraycopy(arr7,0,temp,0,arr7.length);
				arr7 = temp;
				
				arr7[arr7.length - 1] = arr5[i];
				}
		}
		System.out.println("4. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr6));
		System.out.println("\t" + Arrays.toString(arr7));
		
	//5. 짝수/홀수 배열에 있는 값을 작은값 부터 큰값 순으로 정렬된 배열을 만들고 출력한다.
		int[]arr8 = arr6.clone();
		int[]arr9 = arr7.clone();
		
		for(int i = 0; i < arr8.length - 1; i++) {
			for(int j = i + 1; j < arr8.length; j++) {
			if(arr8[i] > arr8[j]){
				int temp = arr8[j];
				arr8[j] = arr8[i];
				arr8[i] = temp;
			   }
			}
		}
		for(int i = 0; i < arr9.length - 1; i++) {
			for(int j = i + 1; j < arr9.length; j++) {
				if(arr9[i] > arr9[j]) {
					int temp = arr9[j];
					arr9[j] = arr9[i];
					arr9[i] = temp;
				}
			}
		}
		System.out.println("5번째 출력");
		System.out.println("\t" + Arrays.toString(arr8));
		System.out.println("\t" + Arrays.toString(arr9));
		
		//6. 짝수/홀수 배열로 나누어져 있는 것을 하나의 배열로 만들고 출력한다.
		int[]arr10 = new int[arr8.length + arr9.length];
		for(int i = 0; i < arr10.length; i++) {
			System.arraycopy(arr8,0,arr10,0,arr8.length);
			System.arraycopy(arr9,0,arr10,arr8.length,arr9.length);
		}
		System.out.println("6번째 출력");
		System.out.println("\t" + Arrays.toString(arr10));
   }
}
