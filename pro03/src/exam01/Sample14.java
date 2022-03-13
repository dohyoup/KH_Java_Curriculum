package exam01;

import java.util.Random;
import java.util.Scanner;


public class Sample14 {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int num2;
		int count = 1;
		int num = random.nextInt(100);
		while(true) {	
			System.out.println("숫자를 입력해 주세요. : ");		
			num2 = sc.nextInt();
			if(num2==num) {
				System.out.println("정답입니다 !!");
				System.out.printf("%d회 만에 맞추셨습니다.",count);
				break;
			}else {
				if(num2 > num) {
					System.out.println("Down");
				}else if(num2<num){
					System.out.println("Up");
				}
			}
			count++;
		}
	}
		
}