package exam01;

public class Sample01 {

	public static void main(String[] args) {
		
		
		for(int i = 1; i <= 99; i++) {
			System.out.println(i+ "번째 출력");
		}
		
		System.out.println("------------------");
		
		for(int i = 0; i < 100; i++) {			
			if(i == 0) {
				//if(i % 2 == 0)
			   i+=1;
			}
			System.out.println(i+ "번째 출력");
		}
		
		System.out.println("------------------");
		
		for(int i = 2; i<=99; i+=2) {
			System.out.println(i+" 번째 출력");
		}
	
	
	}
	
}
