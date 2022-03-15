package test;
import java.util.Random;
public class Sample03 {

	public static void main(String[] args) {
		//pro04-Sample09 해당
		
	/*
	 * 배열의 크기가 5인 정수 배열을 생성하고 해당 배열에 1~19 까지의
	 * 정수 값을 임의로 생성하여 초기화 하는 작업을 수행하도록 한다.
	 * 단, 배열에 초기화된 값은 중복되어서는 안된다.
	 * 
	 */
		Random rand = new Random();
		int[] arr1 = new int [5];
		boolean duplicate;
		
		for(int i = 0; i < arr1.length;) {
			int num = rand.nextInt(19)+1;
			duplicate = false;
		//	arr1[i] = num; // 이부분 몰랐었음 =>같다라는 의미가아니라 넘값을 배열에 넣겠다는뜻
			for(int j = 0; j < i; j++) {
				if(arr1[j] == num)
					duplicate = true;
					break; //중복되면 인접한 for문 중단.
			}
		
		if(!duplicate) {
			arr1[i] = num;
			System.out.print(arr1[i] + "\n");
			i++;
		}
	 }
	}		// 이거 영상찾아보고 이유 알아둬라 배열에서 특수문자나올땐 뭘안해서인지
}
	
