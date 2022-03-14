package pro04;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 10인 배열을 선언하고 10~1 까지의 값으로 초기화 한다.
		 */
		
		/*
		 * 배열의 크기가 10인 배열을 선언하고 2 부터 시작하여 짝수값에 해당하는 값으로 초기화 한다.
		 */
		
		/*
		 * 배열의 크기가 5인 실수 배열을 선언하고 1부터 0.5씩 증가된 값으로 초기화 한다.
		 */
		
		/*
		 * 배열의 크기가 5인 문자 배열을 선언하고 'A'~'E'까지의 문자값으로 초기화 한다.
		 */
		
//		int[] arr1 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//			
//		for(int i = 0; i <= 9; i++) {
//			System.out.println(arr1[i] + "\t");
//		}
//		System.out.println("\n");
//		
//		int[] arr2 = new int[] { 1,2,3,4,5,6,7,8,9,10};
//		for(int j =1; j<=10; j+=2) {
//			System.out.println(arr2[j]);
//		}
//		System.out.println("\n");
//		
		int[] arr3 = new int[10];
		int init = 10;
		for(int i = 0; i < 10; i++) {
			arr3[i] = init--;
		}
		for(int i = 0; i < 10; i++) {
			System.out.print(arr3[i] + "\t");
		}
		System.out.print("\n");
		
		
	}
	
	
}
