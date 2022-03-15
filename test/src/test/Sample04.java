package test;

import java.util.Arrays;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 *  -기존 배열의 크기보다 크거나 작은 새로운 배열을 만들어서 사용하는 형태
		 */
		
		int[] arr1 = new int[] {1,2,3}; //3
		// 저장공간이 늘어났다고 착각하게 만들어주는 것 
		System.out.println(Arrays.toString(arr1));
		
		int[] temp = new int[arr1.length+1]; //4
		for(int i = 0; i < arr1.length; i++) {
			temp[i] = arr1[i]; // 깊은복사
		}
		arr1 = temp; //얕은복사
		System.out.println(Arrays.toString(arr1));
		
		//Arrays.copyOf를 사용한 동적배열
		temp = Arrays.copyOf(arr1, arr1.length+1);
		arr1 = temp;
		
		System.out.println(Arrays.toString(arr1));
	
		temp = new int[arr1.length+1];
		System.arraycopy(arr1, 0, temp,0, arr1.length);
		arr1 = temp;
		
		System.out.println(Arrays.toString(arr1));
		}
	
		
	}

