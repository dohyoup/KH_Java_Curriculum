package exam01;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 중첩 반복문
		 * 
		 */
		for(int i = 1; i<=3; i++) {
			System.out.println("i가1번 반복할 때마다.");
			for(int j = 1; j <= 3; j++) {
				System.out.println("j의 반복문은 3번씩 총 9번 코드의 실행이 이루어진다.");
			}
		}
		
		/*
		 * 구구단 
		 */
		for(int i = 1; i<=9; i++ ) {
			for(int j =1; j<=9; j++) {
			System.out.printf("%d x %d = %d\t",i,j,i * j);
			}
		    System.out.println();
		}
		int num = 1;
		for(int i = 1; i<=6; i++) {
			for(int j = 1; j<=i; j++) {	
				System.out.print(num++ + "\t");
				
			}
			System.out.println();
		}
	}

}
